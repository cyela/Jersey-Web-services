package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static final String driver = "oracle.jdbc.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String username = "hr";
	public static final String password = "hr";

	public static Connection getConnection(){
		Connection con= null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(URL, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}	
}