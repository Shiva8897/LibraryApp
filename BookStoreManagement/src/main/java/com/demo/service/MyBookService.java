package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Entity.MyBookList;
import com.demo.repository.MyBookRepository;

@Service
public class MyBookService {
	 
	@Autowired
	private MyBookRepository mybookrepo;
	
	public void saveMyBook(MyBookList book) {
		mybookrepo.save(book);
	}

	public List<MyBookList> getAllMyBooks(){
		return mybookrepo.findAll();
	}
	public void deleteById(int id) {
		mybookrepo.deleteById(id);
	}

}
