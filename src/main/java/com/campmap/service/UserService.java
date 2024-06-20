package com.campmap.service;


import com.campmap.converter.UserConverter;
import com.campmap.database.UserEntity;
import com.campmap.database.UserRepository;
import com.campmap.model.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;
  public String createUser(User createUser) {
    UserEntity userEntity = UserConverter.toUser(createUser);
    userRepository.save(userEntity);
    return userEntity.getUserId();
  }

  public User getUser(String userId) {
    Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
    if (userEntityOptional.isPresent()) {
      return UserConverter.toUser(userEntityOptional.get());
    } else {
      throw new RuntimeException("Not exists user, id:" + userId);
    }
  }
}
