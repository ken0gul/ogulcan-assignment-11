package com.codercampus.Assignment11.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.codercampus.Assignment11.domain.Transaction;

@Repository
public class TransactionRepository {
	private List<Transaction> transactions = new ArrayList<>(100);

	public TransactionRepository() {
		super();
		populateData();
	}

	public List<Transaction> findAll() {
		return transactions;
	}

	@SuppressWarnings("unchecked")
	private void populateData() {
		try (FileInputStream fileInputStream = new FileInputStream("transactions.txt");
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
			this.transactions = (List<Transaction>) objectInputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Transaction findById(Long id) {
		Map<Long, List<Transaction>> transactionsMap = transactions.stream().map(t -> t)
				.collect(Collectors.groupingBy(Transaction::getId));
		List<Transaction> m = transactionsMap.get(id);
		System.out.println(m);

		return transactionsMap.get(id).get(0);

	}

}
