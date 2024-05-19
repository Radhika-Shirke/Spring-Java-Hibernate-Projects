package com.hib;

import javax.persistence.*;

@Entity
@DiscriminatorValue("SalaryAccount")
public class SalaryAccount extends Account {
	
	int salary;
	String email;
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public SalaryAccount(int salary, String email) {
		super();
		this.salary = salary;
		this.email = email;
	}
	public SalaryAccount() {
		super();
	}
	@Override
	public String toString() {
		return "SalaryAccount [salary=" + salary + ", email=" + email + ", accountId=" + accountId + ", bankName="
				+ bankName + "]";
	}
	
	

}
