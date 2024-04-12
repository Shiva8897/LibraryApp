package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.Entity.Signup;
import com.demo.repository.SignupRepository;

@Controller
public class SignupController {
	  
	@Autowired
	private SignupRepository signrepo;
	
	@GetMapping("/")
	public String SignupForm(Model model) {
		model.addAttribute("user", new Signup());
		return "Signup";
	}
	
	@PostMapping("/signup")
	public String submitForm(Signup signup) {
			signrepo.save(signup);
			
			if(signup.getUname().length()==0&&signup.getPwd().length()==0) {
			return "signup";
			}
			else {
				return "redirect:/login";
			}
	}
	
	@GetMapping("/homepage")
	public String homepagelogin() {
		return "index";
	}


}
