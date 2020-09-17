package com.userregistration.userregistration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userregistration.userregistration.dao.UserDao;
import com.userregistration.userregistration.models.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User createUser(User user) {
		
		userDao.save(user);
		
		return user;
	}

}
