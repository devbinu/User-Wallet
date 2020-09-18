package com.userregistration.userregistration.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.userregistration.userregistration.models.Transaction;

public interface TransactionDao extends JpaRepository<Transaction, Long> {

	@Query(value = "Select * from transaction where is_transaction_detail_printed_in_passbook = false and (sender_username = ?1 or receiver_username = ?1)", nativeQuery = true)
	List<Transaction> findTransactionsForPassbookbyUsername(String username);
}
