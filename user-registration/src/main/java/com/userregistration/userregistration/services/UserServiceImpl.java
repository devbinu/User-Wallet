package com.userregistration.userregistration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.userregistration.userregistration.constants.BusinessConstants;
import com.userregistration.userregistration.dao.UserDao;
import com.userregistration.userregistration.models.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User createUser(User user) {
		
		// Set Initial Wallet Amount = 0
		user.setWalletAmount(0);
		
		return userDao.save(user);
	}

	@Override
	public User getUser(String username, String password) {
		
		User user = userDao.findUserbyUsernameAndPassword(username, password);
		
		return user;
	}

	@Override
	public String isUserRegistered(String username, String password) {
		
		User user = userDao.findUserbyUsernameAndPassword(username, password);
		
		if(user == null) {
			return BusinessConstants.USER_NOT_FOUND_FOR_SIGN_IN;
		}
		
		return BusinessConstants.USER_FOUND_FOR_SIGN_IN;
	}

}
