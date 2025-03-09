package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.UserService;

@Controller
public class LoginController {
	private final UserService userService;
	
	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/login")
    public ModelAndView showLoginPage() {
        return new ModelAndView("login");
    }
	
	@PostMapping("/login")
	public ModelAndView login(@RequestParam String email, @RequestParam String password) {
		boolean isAuthenticated = userService.authenticateUser(email, password);
		
		if( isAuthenticated ) {
			return new ModelAndView("redirect:/");
		}
		else {
			ModelAndView modelAndView = new ModelAndView("login");
			modelAndView.addObject("error", "이메일 또는 비밀번호가 올바르지 않습니다.");
			return modelAndView;
		}
	}
}