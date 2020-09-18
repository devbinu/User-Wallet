package com.userregistration.userregistration.transaction.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userregistration.userregistration.constants.BusinessConstants;
import com.userregistration.userregistration.dao.TransactionDao;
import com.userregistration.userregistration.dao.UserDao;
import com.userregistration.userregistration.models.Transaction;
import com.userregistration.userregistration.models.User;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDao transactionDao;

	@Autowired
	private UserDao userDao;

	@Override
	public Transaction initiateTransaction(Transaction transaction) {

		// Set Parameters in Transaction Entity such as charges, commission etc.
		setParametersInTransaction(transaction);

		// Set Status of Transaction to be "Created"
		updateStatusOfTransaction(transaction, BusinessConstants.STATUS_CREATED);

		// Update Wallet of user according to transaction type
		updateWalletAccordingToTransactionType(transaction);

		return transactionDao.save(transaction);
	}
	
	@Override
	public List<Transaction> getTransactionsForPassbook(String username) {
		
		// Get Transaction of username whose passbook flag = false
		List<Transaction> transactionList = transactionDao.findTransactionsForPassbookbyUsername(username);
		
		// Update passbook flag = true as these transactions are going to print in passbook
		updatePassbookFlagForPrintedTransactions(transactionList);
		transactionDao.saveAll(transactionList);
		
		return transactionList;
	}

	private void updatePassbookFlagForPrintedTransactions(List<Transaction> transactionList) {
		
		for(Transaction transaction: transactionList)
			transaction.setTransactionDetailPrintedInPassbook(Boolean.TRUE);
	}

	private void updateWalletAccordingToTransactionType(Transaction transaction) {
		
		// Update Status of Transaction to be "InProgress"
		updateStatusOfTransaction(transaction, BusinessConstants.STATUS_IN_PROGRESS);
		
		double totalTransactionalAmountToBeAdded = (double) transaction.getTransactionAmount() - transaction.getChargesAmount()
				- transaction.getCommissionAmount();
		
		if (transaction.getType().equalsIgnoreCase(BusinessConstants.TYPE_ADD_MONEY)) {
			
			addMoneyToUserWallet(transaction.getReceiverUsername(), totalTransactionalAmountToBeAdded);
		}
		else if(transaction.getType().equalsIgnoreCase(BusinessConstants.TYPE_TRANSFER_MONEY)) {
			
			double totalTransactionalAmountToBeDeducted = (double) transaction.getTransactionAmount() + transaction.getChargesAmount()
					+ transaction.getCommissionAmount();
			
			if(isAmountSufficientInWalletOfSender(transaction.getSenderUsername(), totalTransactionalAmountToBeDeducted)) {
				
				deductMoneyToUserWallet(transaction.getSenderUsername(), totalTransactionalAmountToBeDeducted);
				addMoneyToUserWallet(transaction.getReceiverUsername(), totalTransactionalAmountToBeAdded);
			}
			else {
				// Update Status of Transaction to be "Failed"
				updateStatusOfTransaction(transaction, BusinessConstants.STATUS_FAILED);
				return;
			}
		}
		
		// Update Status of Transaction to be "Completed"
		updateStatusOfTransaction(transaction, BusinessConstants.STATUS_COMPLETED);
	}

	private void deductMoneyToUserWallet(String username, double totalAmountToBeDeducted) {
		
		// Get Details of User from Username and Deduct Wallet Amount of that user
		User user = userDao.findUserbyUsername(username);
		user.setWalletAmount(user.getWalletAmount() - totalAmountToBeDeducted);
		userDao.save(user);
	}

	private boolean isAmountSufficientInWalletOfSender(String senderUsername, double totalTransactionalAmount) {
		
		// Get Details of User from Username and Return true if Wallet has sufficient amount
		User user = userDao.findUserbyUsername(senderUsername);
		return user.getWalletAmount() >= totalTransactionalAmount;
	}

	private void addMoneyToUserWallet(String username, double totalAmountToBeAdded) {
		
		// Get Details of User from Username and Add Wallet Amount of that user
		User user = userDao.findUserbyUsername(username);
		user.setWalletAmount(user.getWalletAmount() + totalAmountToBeAdded);
		userDao.save(user);
	}

	private void updateStatusOfTransaction(Transaction transaction, String status) {

		transaction.setStatus(status);
	}

	private void setParametersInTransaction(Transaction transaction) {

		// Compute charges and commission
		double chargeAmount = (double) transaction.getTransactionAmount() * BusinessConstants.CHARGE_FRACTION;
		double commissionAmount = (double) transaction.getTransactionAmount() * BusinessConstants.COMMISSION_FRACTION;

		transaction.setChargesAmount(chargeAmount);
		transaction.setCommissionAmount(commissionAmount);

		// Set isTransactionDetailPrintedInPassbook to false by default
		transaction.setTransactionDetailPrintedInPassbook(Boolean.FALSE);

	}

}
