package com.example.springdatajdbc;

import com.example.springdatajdbc.hashing.PBKDF2Hasher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@RequiredArgsConstructor
public class User {

  @Id
  private int id;
  private String name;
  private String password;
  private Address address;

  public User(int id, String name, String password, Address address) {
    this.id = id;
    this.name = name;
    this.password = new PBKDF2Hasher().hash(password.toCharArray());
    this.address = address;
  }
}
