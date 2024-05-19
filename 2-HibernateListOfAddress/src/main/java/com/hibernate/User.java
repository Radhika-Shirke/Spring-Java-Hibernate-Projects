package com.hibernate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "User_Table")
public class User {
	
//	@Embedded
//	@AttributeOverrides({
//			@AttributeOverride(name = "city", column = @Column(name = "homecity")),
//			@AttributeOverride( name = "state", column = @Column(name = "homestate"))
//	} )
//	Address homeAddress;
//	
//	@Embedded
//	@AttributeOverrides({
//		@AttributeOverride(name = "city", column = @Column(name = "officecity")),
//		@AttributeOverride( name = "state", column = @Column(name = "officestate"))
//	} )
	//Address officeAddress;
	
	@Id
	//@GeneratedValue( strategy = GenerationType.SEQUENCE)
	//@GeneratedValue( strategy = GenerationType.IDENTITY)
	@GeneratedValue( strategy = GenerationType.AUTO)

	@Column(name = "User_ID")
	private int userId;
	
	@Column(name = "User_Name")
	private String userName;
	
	@ElementCollection
	@JoinTable(name = "User_Address_Table", joinColumns = @JoinColumn(name = "User_Id_FK"))
	List<Address> officeAddress;
	
	public User(int userId, String userName, Address homeAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		//this.homeAddress = homeAddress;
	}
	
	
	
//	public Address getOfficeAddress() {
//		return officeAddress;
//	}



//	public void setOfficeAddress(Address officeAddress) {
//		this.officeAddress = officeAddress;
//	}



	public User(Address homeAddress, Address officeAddress, int userId, String userName) {
		super();
		//this.homeAddress = homeAddress;
		//this.officeAddress = officeAddress;
		this.userId = userId;
		this.userName = userName;
	}



	public List<Address> getOfficeAddress() {
		return officeAddress;
	}



	public void setOfficeAddress(List<Address> officeAddress) {
		this.officeAddress = officeAddress;
	}



	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}



//	public Address getHomeAddress() {
//		return homeAddress;
//	}
//
//	public void setHomeAddress(Address homeAddress) {
//		this.homeAddress = homeAddress;
//	}
	

//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", userName=" + userName + ", address=" + address + "]";
//	}
	

}
