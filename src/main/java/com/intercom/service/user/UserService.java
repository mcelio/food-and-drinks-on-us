package com.intercom.service.user;

import com.intercom.datatransferobject.com.intercom.domainobject.UserDO;
import java.io.IOException;

public interface UserService {

  Iterable<UserDO> listUsersWithinRadiusOfOneHundredKilometers() throws IOException;
}
