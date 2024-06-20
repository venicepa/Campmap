package com.campmap.converter;


import com.campmap.database.UserEntity;
import com.campmap.model.User;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;

public class UserConverter {

  private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final int NUMBER_LENGTH = 8;
  private static final Random RANDOM = new Random();

  public static UserEntity toUser(User createUser) {

    LocalDateTime now = LocalDateTime.now();
    Timestamp nowTimestamp = Timestamp.valueOf(now);

    UserEntity userEntity = UserEntity.builder().userId(generateId()).firstName(createUser.getFirstName())
        .lastName(createUser.getLastName()).phoneNumber(createUser.getPhoneNumber())
        .phoneAreaCode(createUser.getPhoneAreaCode()).createdAt(nowTimestamp).modifiedAt(nowTimestamp).build();

    return userEntity;
  }

  public static User toUser(UserEntity userEntity) {
    User user = User.builder().firstName(userEntity.getFirstName()).lastName(userEntity.getLastName())
        .phoneNumber(userEntity.getPhoneNumber()).phoneAreaCode(userEntity.getPhoneAreaCode()).build();
    return user;
  }

  private static String generateId() {
    String letter = String.valueOf(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
    String numbers = String.format("%08d", RANDOM.nextInt(100000000));
    return letter + numbers;
  }
}
