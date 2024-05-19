package com.hotelmanagement.HotelManagementProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HotelDB {
	
	static Connection con;
	
	static void dbConnect() throws ClassNotFoundException, SQLException
	{
		// 1. Loading Driver Class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. Establishing connection with DATABASE
		String connectionURL = 
	"jdbc:sqlserver://localhost:1433;databaseName=HotelManagement;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
		con = DriverManager.getConnection(connectionURL);
	
		System.out.println(con);
	}
	
	static void dbDisconnect() throws SQLException {
		con.close();
	}
	
	
	static String getRoomDetailsWithAvailability() throws SQLException {

		String query = "select r_no,r_details,r_price,r_availability from rooms";		
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		String result = "+-------+-----------------------+-------+---------------+\n";
		result += 	"|Room No|Details\t\t|Price\t|Availabilty\t|\n";
		result +=  	"+-------+-----------------------+-------+---------------+\n";
		while(rs.next()) 
		{
			result += "|"+rs.getInt(1) +"\t"+
					"|"+rs.getString(2) +"\t"+
					"|"+ rs.getInt(3)+"\t"+
					"|"+ rs.getString(4)+"\t|\n";
		}
		
		result +=  "+-------+-----------------------+-------+---------------+\n";
		return result;
		
	}

}
