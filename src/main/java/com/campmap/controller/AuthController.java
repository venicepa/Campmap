package com.campmap.controller;



import com.campmap.model.Login;
import com.campmap.model.User;
import com.campmap.service.JwtTokenUtils;
import com.campmap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

  @Autowired
  private JwtTokenUtils jwtTokenUtils;

  @Autowired
  private UserService userService;

  @PostMapping(path = "/login")
  public ResponseEntity<String> login(@RequestBody Login login) {
    String token;

    token = jwtTokenUtils.generateToken(login.getUsername());

    HttpHeaders headers = new HttpHeaders();

    headers.add("Set-Cookie", "auth=" + token + "; Path=/; HttpOnly;");

    return ResponseEntity.ok().headers(headers).build();
  }

  @PostMapping(path = "/user/create")
  public ResponseEntity<String> createUsr(@RequestBody User createUser) {
    String userId = userService.createUser(createUser);
    return ResponseEntity.ok().body(userId);
  }

  @GetMapping(path = "/user/get/{userId}")
  public ResponseEntity<User> getUsr(@PathVariable("userId") String userId) {
    User user = userService.getUser(userId);
    return ResponseEntity.ok().body(user);
  }
}
