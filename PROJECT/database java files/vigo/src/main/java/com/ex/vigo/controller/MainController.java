package com.ex.vigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ex.vigo.model.LoginModel;
import com.ex.vigo.service.LoginService;

@RestController
public class MainController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping("/authenticate")
	private LoginModel authenticate(@RequestBody LoginModel loginModel) {
		return loginService.authenticate(loginModel);
	}
	
}
