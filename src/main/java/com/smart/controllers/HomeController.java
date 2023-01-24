package com.smart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.dao.UserRepo;
import com.smart.entities.User;

@Controller
public class HomeController {
	@Autowired
	private UserRepo userRepo;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Homepage");
		return "home";
	}

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About Page");
		return "about";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "Register - Smart Contact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/do_register")
	public String registerUser(@ModelAttribute("user") User user,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model) {
		if (agreement) {
			System.out.println("You have not agreed the term and Condittion");
		}
		user.setRole("ROLE_USER");
		user.setEnabled(true);

		
		User result = this.userRepo.save(user);
		System.out.println(result);
		model.addAttribute("user", user);
		return "signup";
	}

}
