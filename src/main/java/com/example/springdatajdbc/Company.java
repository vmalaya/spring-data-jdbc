package com.example.springdatajdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import java.util.Set;

@Data
@AllArgsConstructor
public class Company {
  @Id
  private Integer id;
  private String name;
  private Set<User> user;
}
