package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.Entity.Book;
import com.demo.Entity.MyBookList;
import com.demo.service.BookService;
import com.demo.service.MyBookService;




@Controller
public class BookController {
	
	@Autowired
	private BookService bookservice;
	@Autowired
	private MyBookService mybookservice;
	
	@GetMapping("/home")
	public String home() {
		return "home";	
		
	}
	
	@GetMapping("/book_register")
	public String bookregister() {
		return "bookregister";
	}
	@GetMapping("/available_books")
	public ModelAndView availablebooks() {
		List<Book>list=bookservice.getAllBooks();
        return new ModelAndView("bookList","book",list);
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		bookservice.save(b);
		return "redirect:/available_books";
	}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
	List<MyBookList> list=mybookservice.getAllMyBooks();
	model.addAttribute("book",list);
		return "myBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=bookservice.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		mybookservice.saveMyBook(mb);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model ) {
		Book b=bookservice.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
	}
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bookservice.deleteById(id);
		return "redirect:/available_books";
	}

}
