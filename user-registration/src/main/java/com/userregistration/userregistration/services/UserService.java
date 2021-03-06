package com.userregistration.userregistration.services;

import com.userregistration.userregistration.models.User;

public interface UserService {

	User createUser(User user);

	User getUser(String username, String password);

	String isUserRegistered(String username, String password);
}
