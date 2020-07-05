package com.example.springdatajdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Address {
  @Id
  private int id;
  private String country;
  private String city;
  private String street;
}
