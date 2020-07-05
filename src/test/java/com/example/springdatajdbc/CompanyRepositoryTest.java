package com.example.springdatajdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
class CompanyRepositoryTest {
  @Autowired
  private CompanyRepository companyRepository;

  @BeforeEach
  void setup() {
    Set users = new HashSet<User>();
    users.add(new User(1, "Ben", "bens_password", new Address(1, "Ukraine", "Kyiv", "SomeStreetInKyiv")));
    users.add(new User(2, "Dan", "dans_password", new Address(2, "USA", "LA", "RoRoRo")));

    Company company =  new Company(1, "Coco", users);
    companyRepository.save(company);
  }

  @Test
  void should_find_all() {
    System.out.println(companyRepository.findAll());
  }

  @Test
  void should_find_users_by_company_name() {
    List<User> users = companyRepository.findUsersByCompanyName("Coco");
    System.out.println(users);
    Assertions.assertEquals(2, users.size());
  }

  @Test
  void should_find_countries_of_users_by_company(){
    List<String> countries = companyRepository.findCountriesOfUsersByCompany("Coco");
    System.out.println(countries);
    Assertions.assertTrue(countries.containsAll(Arrays.asList("Ukraine", "USA")));
  }

  @Test
  void should_count_users_in_company() {
    int usersInCompany = companyRepository.countUsersInCompany("Coco");
    System.out.println(usersInCompany);
    Assertions.assertEquals(2, usersInCompany);
  }
}
