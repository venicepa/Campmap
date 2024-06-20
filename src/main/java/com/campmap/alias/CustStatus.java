package com.campmap.alias;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CustStatus {

  TEMP("1"),
  WORKING("2"),
  DELETE("3");

  private final String code;
}
