package com.intercom.controller;

import com.intercom.controller.mapper.UserMapper;
import com.intercom.datatransferobject.UserDTO;
import com.intercom.service.user.UserService;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * All operations to users will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(final UserService userService) {
    this.userService = userService;
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @GetMapping("/list")
  public List<UserDTO> findUsers() throws IOException {
    return UserMapper.makeUserDTOList(
        StreamSupport
            .stream(userService.listUsersWithinRadiusOfOneHundredKilometers().spliterator(), false)
            .collect(Collectors.toList()));
  }
}
