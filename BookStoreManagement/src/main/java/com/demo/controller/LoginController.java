package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.Entity.Signup;
import com.demo.Entity.UserLogin;
import com.demo.repository.SignupRepository;

@Controller
public class LoginController {
	
	@Autowired
	private SignupRepository signrepo;
	
	@GetMapping("/login")
	public String ShowLogin(Model model) {
		model.addAttribute("userlogin",new UserLogin());
		return "Login";
	}
	
	@PostMapping("/login")
	public String SubmitLogin(UserLogin userlogin,Model model) {
		Signup signup = signrepo.findByUname(userlogin.getUname());
		if(signup != null && signup.getUname().equals(userlogin.getUname()) && signup.getPwd().equals(userlogin.getPwd())) {
			model.addAttribute("Loginsuccessfull",	true);
			return "redirect:/home";
		}
		else {
			model.addAttribute("LoginError", true)
;			return "redirect:/login?error";
		}
		
	}

}
