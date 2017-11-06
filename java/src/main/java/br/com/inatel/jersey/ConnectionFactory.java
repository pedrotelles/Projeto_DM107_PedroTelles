package br.com.inatel.jersey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
	     try {
	    	 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	         return DriverManager.getConnection(
	        		 "jdbc:mysql://127.0.0.1:3307/posdm107", "root", "");
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
}
