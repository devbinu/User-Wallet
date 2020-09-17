package com.userregistration.userregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userregistration.userregistration.models.User;
import com.userregistration.userregistration.services.UserService;

@RestController
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/user", consumes = "application/json")
	public User createUser(@RequestBody User user) {
		
		return userService.createUser(user);
	}
}
