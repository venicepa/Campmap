package com.campmap.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@Builder
public class UserEntity {

  @Id
  private String userId;

  private String firstName;
  private String lastName;
  private String phoneAreaCode;
  private String phoneNumber;
  private String faxId;
  private String bankInfo;
  private String bankAccount;
  private Boolean isVendor;
  private String password;
  private String status;
  private Boolean isDeleted;

  @Column(insertable = false, updatable = false)
  private Timestamp createdAt;

  @Column(insertable = false, updatable = false)
  private Timestamp modifiedAt;
}
