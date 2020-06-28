package com.example.springdatajdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

  @Override
  public User mapRow(final ResultSet rs, final int rowNum) throws SQLException {
    final User user = new User();

    user.setId(rs.getInt("id"));
    user.setName(rs.getString("name"));

    return user;
  }
}