package com.stone.security.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class CustomController {

	@GetMapping("/access")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public String showUser() {
		
		return "Url Security Provided";
	}
}
