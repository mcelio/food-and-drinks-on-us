package com.intercom.service.user;

import com.google.gson.Gson;
import com.intercom.datatransferobject.com.intercom.domainobject.UserDO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for user
 * and geographic operations. specific things.
 * <p/>
 */
@Service
public class DefaultUserService implements UserService {

  private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DefaultUserService.class);
  private static final String USERS_URL = "https://s3.amazonaws.com/intercom-take-home-test/customers.txt";
  private static final int THRESHOLD = 100;
  private Gson json = new Gson();

  public DefaultUserService() {
  }


  /**
   * Selects all users within radius of a hundred kilometers.
   *
   * @return user list
   */
  @Override
  public Iterable<UserDO> listUsersWithinRadiusOfOneHundredKilometers() throws IOException {
    List<UserDO> users = new ArrayList<UserDO>();
    URL url = new URL(USERS_URL);
    try (InputStream is = new URL(USERS_URL).openConnection().getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        Stream<String> stream = reader.lines()) {
      stream.forEachOrdered(line -> addUser(line, users));
    }
    // Sorting
    users.sort(Comparator.comparing(UserDO::getId));
    return users;
  }

  /**
   * It parses a json line form text file.
   */
  private UserDO parse(String line) {
    return json.fromJson(line, UserDO.class);
  }

  /**
   * It adds user to a list.
   */
  private void addUser(String line, List<UserDO> users) {
    UserDO user = parse(line);
    if (isInCircle(user.getLatitude(), user.getLongitude())) {
      users.add(user);
    }
  }

  /**
   * Check if coordinates are in circle.
   *
   * @return true if yes
   */
  public boolean isInCircle(double latitude, double longitude) {
    final int R = 6371; // Radius of the earth
    // center coordinates
    double centerLat = 53.339428;
    double centerLong = -6.257664;
    double distance = distance(centerLat, latitude, centerLong, longitude);
    return (distance <= THRESHOLD);
  }

  /**
   * Calculate distance between two coordinates.
   */
  private double distance(double centerLat, double latitude, double centerLon, double longitude) {
    final int R = 6371; // Radius of the earth
    Double latDistance = convertDegreeToRadius(latitude - centerLat);
    Double lonDistance = convertDegreeToRadius(longitude - centerLon);
    Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
        + Math.cos(convertDegreeToRadius(centerLat)) * Math.cos(convertDegreeToRadius(latitude))
        * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
    Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    double distance = R * c;
    distance = Math.pow(distance, 2);
    return Math.sqrt(distance);
  }

  /**
   * Converts degree to radius
   *
   * @return double converted
   */
  private double convertDegreeToRadius(double deg) {
    return (deg * Math.PI / 180.0);
  }
}
