package com.intercom.datatransferobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

  @JsonIgnore
  private Long id;

  @NotNull(message = "Name can not be null!")
  private String name;

  private Double latitude;

  private Double longitude;

  private UserDTO() {
  }

  private UserDTO(Long id, String name, Double latitude, Double longitude) {
    this.id = id;
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }


  public static UserDTOBuilder newBuilder() {
    return new UserDTOBuilder();
  }

  @JsonProperty
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public static class UserDTOBuilder {

    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;


    public UserDTOBuilder setId(Long id) {
      this.id = id;
      return this;
    }

    public UserDTOBuilder setName(String name) {
      this.name = name;
      return this;
    }

    public UserDTOBuilder setLatitude(Double latitude) {
      this.latitude = latitude;
      return this;
    }

    public UserDTOBuilder setLongitude(Double longitude) {
      this.longitude = longitude;
      return this;
    }

    public UserDTO createUserDTO() {
      return new UserDTO(id, name, latitude, longitude);
    }
  }
}
