package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.model.User;

@Service
public class UserService {
	
	private final UserDao userDao;
	
	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public boolean authenticateUser(String email, String password) {
		Optional<User> user = userDao.getUserByEmail(email);
		return user.isPresent() && user.get().getPassword().equals(password);
	}
}