package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.Entity.Book;
import com.demo.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookrepo;
	
	public void save(Book b) {
		bookrepo.save(b);
		
	}
	

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookrepo.findAll();
	}
	
	public Book getBookById(int id) {
		return bookrepo.findById(id).get();
	}
	
	public void deleteById(int id) {
		bookrepo.deleteById(id);
	}

}
