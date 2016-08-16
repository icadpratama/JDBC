package com.bsp.latihan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelectTest {
	private static Connection conn;
	private static Statement stm;

	public static void main(String[] args) {
		String query;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","");
			stm = conn.createStatement();
			
			query = "SELECT title, price, qty FROM books";
			System.out.println("Query SQL: " + query);
			System.out.println();
			
			ResultSet rs = stm.executeQuery(query);
			System.out.println("The records selected are:");
			int rowCount = 0;
			while(rs.next()){
				String title = rs.getString("title");
				double price = rs.getDouble("price");
				int qty = rs.getInt("qty");
				System.out.println(title + " || $" + price + " || " + qty);
				++rowCount;
			}
			
			System.out.println("Total number of records = " + rowCount);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error getConnection()");
		}
	}
}
