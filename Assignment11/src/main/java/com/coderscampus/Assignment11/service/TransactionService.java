package com.coderscampus.Assignment11.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {

	
	
	private TransactionRepository repo = new TransactionRepository();
	
	public List<Transaction> findAll() {
		
		return repo.findAll();
	}

	// Return a transaction so you can use it on your controller
	public Transaction findById(Long id) {
		return repo.findById(id);
		
	}

	

	
}