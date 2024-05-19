package com.hib;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "AccountTable")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "BankAccountType", discriminatorType = DiscriminatorType.STRING)

public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	int accountId;
	String bankName;
	
	public int getAccountId() {
		return accountId;
	}
	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public Account(int accountId, String bankName) {
		super();
		this.accountId = accountId;
		this.bankName = bankName;
	}
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", bankName=" + bankName + "]";
	}
	
	

}
