package com.campmap.service;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.message.AuthException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class JwtTokenUtils {

  private static final long EXPIRATION_TIME = 60 * 60 * 1000;

  private static final String SECRET = "Thanks9527";


  public String generateToken(String username) {
    Map<String, Object> claims = new HashMap<>();

    claims.put("userName", username);

    return Jwts.builder().setClaims(claims)
        .setExpiration(new Date(Instant.now()
            .toEpochMilli() + EXPIRATION_TIME)).signWith(
            SignatureAlgorithm.HS256, SECRET).compact();
  }

  public void validateToken(String token) throws AuthException {
    try {
      Jwts.parser().setSigningKey(SECRET).parseClaimsJwt(token);
    } catch (MalformedJwtException e) {
     throw new AuthException("Invalid JWT Token");
    } catch (ExpiredJwtException e) {
      throw new AuthException("Expired JWT Token");
    }
  }

}
