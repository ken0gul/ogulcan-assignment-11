package com.codercampus.Assignment11.web;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.coderscampus.Assignment11.service.TransactionService;

@org.springframework.stereotype.Controller
public class Controller {

	private TransactionService transactionService = new TransactionService();

	@GetMapping("/transactions")
	public String getTransactions(Model model) {
		Transaction transaction = new Transaction();
		model.addAttribute("transaction", transaction);
		List<Transaction> allTransactions = transactionService.findAll();
		Collections.sort(allTransactions, new Comparator<Transaction>(

				) {

					@Override
					public int compare(Transaction o1, Transaction o2) {
						return o1.getDate().compareTo(o2.getDate());
					}
				});
		model.addAttribute("transactions", allTransactions);
		return "transactions";
	}
	
	

	
}


