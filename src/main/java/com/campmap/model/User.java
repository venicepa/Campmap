package com.campmap.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {

  public String userName;
  public String password;
  public String nickName;
  public String firstName;
  public String lastName;
  public String phoneNumber;
  public String phoneAreaCode;
}
