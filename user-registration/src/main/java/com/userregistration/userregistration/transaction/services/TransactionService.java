package com.userregistration.userregistration.transaction.services;

import java.util.List;

import com.userregistration.userregistration.models.Transaction;

public interface TransactionService {

	Transaction initiateTransaction(Transaction transaction);

	List<Transaction> getTransactionsForPassbook(String username);
}
