package com.example.springdatajdbc.hashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class PBKD2HasherTest {

  @Autowired
  private PBKDF2Hasher pbkd2Hasher;

  @Test
  void givenCorrectMessageAndHash_whenAuthenticated_checkAuthenticationSucceeds() {
    String message1 = "password123";

    String hash1 = pbkd2Hasher.hash(message1.toCharArray());
    System.out.println(hash1);

    Assertions.assertTrue(pbkd2Hasher.checkPassword(message1.toCharArray(), hash1));
  }
}
