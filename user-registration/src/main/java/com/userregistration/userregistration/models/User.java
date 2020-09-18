package com.userregistration.userregistration.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;
	
	private String username;
	private String password;
	private String name;
	private String emailId;
	private long contactNumber;
	private double walletAmount;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long id, String username, String password, String name, String emailId, long contactNumber,
			double walletAmount) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.walletAmount = walletAmount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public double getWalletAmount() {
		return walletAmount;
	}

	public void setWalletAmount(double walletAmount) {
		this.walletAmount = walletAmount;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", emailId="
				+ emailId + ", contactNumber=" + contactNumber + ", walletAmount=" + walletAmount + "]";
	}

}
