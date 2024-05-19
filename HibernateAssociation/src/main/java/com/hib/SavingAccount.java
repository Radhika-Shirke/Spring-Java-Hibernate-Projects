package com.hib;

import javax.persistence.*;

@Entity
@DiscriminatorValue("AccountTypeSaving")
public class SavingAccount extends Account {
	
	int balance;
	String contact;
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public String getContact() {
		return contact;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "SavingAccount [balance=" + balance + ", contact=" + contact + "]";
	}

}
