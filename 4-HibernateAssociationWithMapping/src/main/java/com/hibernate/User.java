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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_ID")
	private int userId;
	
	@Column(name = "User_Name")
	private String userName;
	
	
	/*
	 * @OneToOne(mappedBy = "user") Vehicle veh;
	 */
	
	/*
	 * @OneToMany List<Vehicle>veh;
	 */
	
		/*
		 * Vehicle veh;
		 * 
		 * @OneToMany List <Vehicle> veh
		 */
	
	@ManyToMany
	
	List<Vehicle>veh;


	public int getUserId() {
		return userId;
	}


	public List<Vehicle> getVeh() {
		return veh;
	}


	public void setVeh(List<Vehicle> veh) {
		this.veh = veh;
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


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", veh=" + veh + "]";
	}

	
}
