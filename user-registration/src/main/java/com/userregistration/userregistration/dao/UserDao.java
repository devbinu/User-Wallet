package com.userregistration.userregistration.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userregistration.userregistration.models.User;

public interface UserDao extends JpaRepository<User, Long> {

}
