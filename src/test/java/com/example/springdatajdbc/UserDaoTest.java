package com.example.springdatajdbc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@SpringBootTest
@ContextConfiguration(classes = { DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
class UserDaoTest {
  @Autowired
  UserDao userDao;

  @Test
  void should_get_count_of_users() {
    Assertions.assertThat(userDao.getCountOfUsers()).isEqualTo(3);
  }

  @Test
  void should_get_all_users() {
    Assertions.assertThat(userDao.getAllUsers()).contains(new User(1, "Aragorn"), new User(2, "Mike"), new User(3, "Sherlock"));

  }
}
