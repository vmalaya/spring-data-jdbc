package com.example.springdatajdbc;

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

  @Test
  void should_find_all() {
    Set users = new HashSet<User>();
    users.add(new User(1, "Ben"));
    users.add(new User(2, "Dan"));

    Company company =  new Company(1, "Coco", users);
    companyRepository.save(company);

    System.out.println(companyRepository.findAll());
  }
}
