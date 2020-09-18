package com.userregistration.userregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userregistration.userregistration.models.Transaction;
import com.userregistration.userregistration.transaction.services.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@PostMapping(path = "/transaction", consumes = "application/json")
	public Transaction initiateTransactionForAddMoney(@RequestBody Transaction transaction) {
		
		return transactionService.initiateTransaction(transaction);
	}
	
	@GetMapping(path = "/transaction/passbook/{username}")
	public List<Transaction> viewPassbook(@PathVariable String username) {
		
		// Get All Transactions Which are not Present in Passbook
		return transactionService.getTransactionsForPassbook(username);
	}
}
