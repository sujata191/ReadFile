package com.rs.fer.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.rs.util.DBUtil;

public class ReadFile {

	public static void main(String[] args) {
		String firstname;
		String lastname;
		String qualification;
		String DOJ;
		String course;
		String salary;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\sujata\\Desktop\\documents\\Test.txt"));

			connection = DBUtil.getConnection();
			String str;

			while ((str = read.readLine()) != null) {

				String[] s1 = str.split(",");
				firstname = s1[0];
				lastname = s1[1];
				qualification = s1[2];
				String[] s77 = s1[3].split("10:30:250000");
				DOJ = s77[0] + s77[1];
				course = s1[4];
				salary = s1[5];
				String sql = "INSERT INTO Details (firstname, lastname,qualification, DOJ, course,salary) values ("
						+ firstname + "," + lastname + "," + qualification + "," + DOJ + "," + course + "," + salary
						+ ")";
				statement = (PreparedStatement) connection.prepareStatement(sql);
				statement.executeUpdate();
				System.out.println("" + firstname + "," + lastname + "," + qualification + "," + DOJ + "," + course
						+ "," + salary);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

	}
}
