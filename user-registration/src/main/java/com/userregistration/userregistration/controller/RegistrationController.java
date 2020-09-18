package com.userregistration.userregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userregistration.userregistration.models.User;
import com.userregistration.userregistration.services.UserService;

@RestController
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/user", consumes = "application/json")
	public User createUserForSignUp(@RequestBody User user) {
		
		return userService.createUser(user);
	}
	
	@GetMapping(path = "/user/check/{username}/{password}")
	public String isUserRegisteredForSignIn(@PathVariable String username, @PathVariable String password) {
		
		return userService.isUserRegistered(username, password);
	}
	
	@GetMapping(path = "/user/{username}/{password}")
	public User getUserForSignIn(@PathVariable String username, @PathVariable String password) {
		
		return userService.getUser(username, password);
	}
}
