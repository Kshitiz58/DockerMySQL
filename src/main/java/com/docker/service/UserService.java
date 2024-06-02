package com.docker.service;

import com.docker.model.User;

public interface UserService {

	User userLogin(String un, String psw);
	
	void userSignup(User user);
}
