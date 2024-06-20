package com.campmap;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CampmapApplcation {

  public static void main(String[] args) {
    SpringApplication.run(CampmapApplcation.class, args);
  }

}
