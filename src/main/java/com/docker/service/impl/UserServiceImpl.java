package com.docker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docker.model.User;
import com.docker.repository.UserRepository;
import com.docker.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User userLogin(String un, String psw) {
		return userRepo.findByUsernameAndPassword(un, psw);
	}

	@Override
	public void userSignup(User user) {
		userRepo.save(user);
	}

}
