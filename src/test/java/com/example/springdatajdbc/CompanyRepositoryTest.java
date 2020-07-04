package com.example.springdatajdbc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
class CompanyRepositoryTest {
  @Autowired
  private CompanyRepository companyRepository;

  @BeforeEach
  void setup() {
    Set users = new HashSet<User>();
    users.add(new User(1, "Ben", "bens_password"));
    users.add(new User(2, "Dan", "dans_password"));

    Company company =  new Company(1, "Coco", users);
    companyRepository.save(company);
  }

  @Test
  void should_find_all() {
    System.out.println(companyRepository.findAll());
  }

  @Test
  void should_find_users_by_company_name() {
    System.out.println(companyRepository.findUsersByCompanyName("Coco"));
  }
}
