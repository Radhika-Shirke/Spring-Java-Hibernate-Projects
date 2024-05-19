package com.hibernate;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "User_Vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int veh_id;
	String name;
	String vehType;
//	
	/*
	 * @ManyToOne User user;
	 */
	
	
	/*
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */
	
	@ManyToMany
	
	List<User>user;

	 
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public int getVeh_id() {
		return veh_id;
	}
	public void setVeh_id(int veh_id) {
		this.veh_id = veh_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVehType() {
		return vehType;
	}
	public void setVehType(String vehType) {
		this.vehType = vehType;
	}
	public Vehicle(int veh_id, String name, String vehType) {
		super();
		this.veh_id = veh_id;
		this.name = name;
		this.vehType = vehType;
	}
	
	public Vehicle(String name, String vehType) {
		super();
		this.name = name;
		this.vehType = vehType;
	}

	public Vehicle() {
		super();
	}
	@Override
	public String toString() {
		return "Vehicle [veh_id=" + veh_id + ", name=" + name + ", vehType=" + vehType + ", user=" + user + "]";
	}
	
	
}
