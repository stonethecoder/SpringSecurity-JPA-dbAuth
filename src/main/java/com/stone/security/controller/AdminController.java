package com.stone.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stone.security.model.User;
import com.stone.security.repository.UserRepo;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@PostMapping("/add")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String addUser(@RequestBody User user) {
		String encodedPwd= encoder.encode(user.getPassword());
		user.setPassword(encodedPwd);
		userRepo.save(user);
		return "user added sucessfully...";
	}
	
	@GetMapping("/demo")
	public String getDemo() {
		return "Hi";
	}

}
