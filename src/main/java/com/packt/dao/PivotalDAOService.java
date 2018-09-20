package com.packt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.packt.model.Users;

@Repository
public class PivotalDAOService {
 @Autowired
 JdbcTemplate jdbcTemplate;

 public List < Users > getUsers() {
  
	 Collection < Map < String, Object >> rows = jdbcTemplate.queryForList("SELECT * FROM USERS");
  
	 List < Users > usersList = new ArrayList < > ();
   
  rows.stream().map((row) -> {
 	 Users user = new Users();
     user.setId( String.valueOf(row.get("ID")));
     user.setName((String) row.get("NAME"));
   
     return user;
  }).forEach((ss) -> {
   usersList.add(ss);
  });
  return usersList;
 }
 
 public void createUser(Users user) {
  jdbcTemplate.update((Connection connection) -> {
   PreparedStatement preparedStatement = null;
   try {
    preparedStatement = connection.prepareStatement("INSERT INTO USERS (NAME) VALUES (?)");
    preparedStatement.setString(1, user.getName());
   } catch (Exception e) {
    if (preparedStatement != null) {
     preparedStatement.close();
    }
    throw (e);
   }
   return preparedStatement;
  });
 }
}