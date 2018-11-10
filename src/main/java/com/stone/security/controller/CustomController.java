package com.stone.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class CustomController {

	@GetMapping("/access")
	public String showUser() {
		
		return "Url Security Provided";
	}
}
