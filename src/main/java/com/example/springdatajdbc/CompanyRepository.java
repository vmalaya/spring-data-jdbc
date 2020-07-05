package com.example.springdatajdbc;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CompanyRepository extends CrudRepository<Company, Integer> {

  @Query("select user.id, user.name from company inner join user where company.name = :name ")
  List<User> findUsersByCompanyName(@Param("name") String name);

  @Query("select distinct address.country from company inner join user inner join address where company.name = :company")
  List<String> findCountriesOfUsersByCompany(@Param("company") String company);

  @Query("select count(user.name) from company inner join user where company.name = :company")
  int countUsersInCompany(@Param("company") String company);
}
