package com.docker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.docker.model.User;
import com.docker.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping({"/","/login"})
	public String getLogin() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String getSignup() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User user) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userService.userSignup(user);
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String doLogin(@ModelAttribute User user, Model model) {
			userService.userLogin(user.getUsername(), user.getPassword());
			model.addAttribute("uname", user.getUsername());
		return "redirect:/home";
	}
	@GetMapping("/home")
	public String getHome() {
		return "Home";
	}
	
}
