package com.userregistration.userregistration.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.userregistration.userregistration.models.User;

public interface UserDao extends JpaRepository<User, Long> {

	@Query(value = "Select * from user where username = ?1 and password = ?2", nativeQuery = true)
	User findUserbyUsernameAndPassword(String username, String password);
}
