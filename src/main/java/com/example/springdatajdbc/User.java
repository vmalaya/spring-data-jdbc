package com.example.springdatajdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  private int id;
  private String name;
  private String password;
}
