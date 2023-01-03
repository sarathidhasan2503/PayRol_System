package com.tns.payro_System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLjavaconnection {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		try {
			// connection
			String url = "jdbc:mysql://localhost:3306/sarathidhasan";
			String user = "root";
			String password = "123456";

			conn = DriverManager.getConnection(url, user, password);
			if (conn != null) {
				System.out.println("Connected to the database sarathidhasan");
			}
			String sql="INSERT INTO `sarathidhasan`.`Payrol_System`"
					 + " (`ID`, `Emp_Name`, `No_of_Days`, `Rate_per_Day`,`Salary`)"
					 + "VALUES(100,'sarathi',23,2000,45000)";
           Statement stmt = conn.createStatement();
           stmt.executeUpdate(sql);
           System.out.println("Added");
		} catch (SQLException ex) {
			System.out.println("Exception ::" + ex.getMessage());
			ex.printStackTrace();
		}finally {
			conn.close();
		}

	}

}