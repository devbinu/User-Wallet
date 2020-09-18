package com.userregistration.userregistration.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue
	private long id;
	
	private String status;
	private String type;
	private Date createdOn;
	private String senderUsername;
	private String receiverUsername;
	private int transactionAmount;
	private double chargesAmount;
	private double commissionAmount;
	private boolean isTransactionDetailPrintedInPassbook;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Transaction(long id, String status, String type, Date createdOn, String senderUsername,
			String receiverUsername, int transactionAmount, double chargesAmount, double commissionAmount,
			boolean isTransactionDetailPrintedInPassbook) {
		super();
		this.id = id;
		this.status = status;
		this.type = type;
		this.createdOn = createdOn;
		this.senderUsername = senderUsername;
		this.receiverUsername = receiverUsername;
		this.transactionAmount = transactionAmount;
		this.chargesAmount = chargesAmount;
		this.commissionAmount = commissionAmount;
		this.isTransactionDetailPrintedInPassbook = isTransactionDetailPrintedInPassbook;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSenderUsername() {
		return senderUsername;
	}

	public void setSenderUsername(String senderUsername) {
		this.senderUsername = senderUsername;
	}

	public String getReceiverUsername() {
		return receiverUsername;
	}

	public void setReceiverUsername(String receiverUsername) {
		this.receiverUsername = receiverUsername;
	}

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public double getChargesAmount() {
		return chargesAmount;
	}

	public void setChargesAmount(double chargesAmount) {
		this.chargesAmount = chargesAmount;
	}

	public double getCommissionAmount() {
		return commissionAmount;
	}

	public void setCommissionAmount(double commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	public boolean isTransactionDetailPrintedInPassbook() {
		return isTransactionDetailPrintedInPassbook;
	}

	public void setTransactionDetailPrintedInPassbook(boolean isTransactionDetailPrintedInPassbook) {
		this.isTransactionDetailPrintedInPassbook = isTransactionDetailPrintedInPassbook;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", status=" + status + ", type=" + type + ", createdOn=" + createdOn
				+ ", senderUsername=" + senderUsername + ", receiverUsername=" + receiverUsername
				+ ", transactionAmount=" + transactionAmount + ", chargesAmount=" + chargesAmount
				+ ", commissionAmount=" + commissionAmount + ", isTransactionDetailPrintedInPassbook="
				+ isTransactionDetailPrintedInPassbook + "]";
	}
	
}
