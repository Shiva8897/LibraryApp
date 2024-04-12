package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.service.MyBookService;

@Controller
public class MyBookListController {

	@Autowired
	private MyBookService mybookservice;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		mybookservice.deleteById(id);
		return "redirect:/my_books";
	}
	
}
