package com.packt.controller;

import java.util.List;

//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PathVariable;

import com.packt.dao.PivotalDAOService;
import com.packt.model.Users;

@RestController

public class AppController {

@Autowired
PivotalDAOService pivotalDAOService;	

//@GetMapping("/greeting/{name}")
	//public String greeting(@PathVariable String name) {
	//	return   "Welcome to  " + name + " Customer Shopping site";
//	}

@RequestMapping(value = "/users", method = RequestMethod.GET)
public List < Users > getUsers() {
return pivotalDAOService.getUsers();
}


@RequestMapping(value = "/users", method = RequestMethod.POST)
public String createUser(@RequestBody Users user) {
 pivotalDAOService.createUser(user);
 return "User created successfully";
}
}