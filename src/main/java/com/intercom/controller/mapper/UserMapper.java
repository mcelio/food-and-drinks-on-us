package com.intercom.controller.mapper;

import com.intercom.datatransferobject.UserDTO;
import com.intercom.datatransferobject.UserDTO.UserDTOBuilder;
import com.intercom.datatransferobject.com.intercom.domainobject.UserDO;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

  public static UserDO makeUserDO(UserDTO userDTO) {
    return new UserDO(userDTO.getName(), userDTO.getLatitude(),
        userDTO.getLongitude());
  }


  public static UserDTO makeUserDTO(UserDO userDO) {
    UserDTOBuilder userDTOBuilder = UserDTO.newBuilder()
        .setId(userDO.getId())
        .setName(userDO.getName())
        .setLatitude(userDO.getLatitude())
        .setLongitude(userDO.getLongitude());
    return userDTOBuilder.createUserDTO();
  }

  public static List<UserDTO> makeUserDTOList(Collection<UserDO> users) {
    return users.stream()
        .map(UserMapper::makeUserDTO)
        .collect(Collectors.toList());
  }
}
