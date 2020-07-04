package com.example.springdatajdbc;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Integer> {

  @Query("select user.id, user.name from company inner join user where company.name = :name ")
  List<User> findUsersByCompanyName(@Param("name") String name);
}
