package com.rs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static String dir = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/testtask";
	static String username = "root";
	static String password = "root";

	public static Connection getConnection() {
		// TODO Auto-generated constructor stub
		Connection connection = null;
		try {
			// register the driver//
			Class.forName(dir);

			// create the connection//
			connection = DriverManager.getConnection(url, username, password);

		
	}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
		}

public static void closeConnection(Connection connection) {
	try {
		connection.close();
	}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}}