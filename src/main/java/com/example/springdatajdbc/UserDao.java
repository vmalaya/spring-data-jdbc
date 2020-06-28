package com.example.springdatajdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDao {
  private JdbcTemplate jdbcTemplate;

  @Autowired
  public void setDataSource(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public int getCountOfUsers() {
    return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM USERS", Integer.class);
  }

  public List<User> getAllUsers() {
    return jdbcTemplate.query("SELECT * FROM USERS", new UserMapper());
  }
}
