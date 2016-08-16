package com.bsp.latihan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcPreparedStatementTest {
	private static Connection conn;
	private static PreparedStatement pstm;
	
	public static void main(String[] args) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","");
			
			String queryInsert = "INSERT INTO books VALUES (?, ?, ?, ?, ?)";
			pstm = conn.prepareStatement(queryInsert);
			
			pstm.setInt(1, 7001);
			pstm.setString(2, "Mahjong 101");
			pstm.setString(3, "Kumar");
			pstm.setDouble(4, 88.88);
			pstm.setInt(5, 88);
			
			int rowsInserted = pstm.executeUpdate();
			System.out.println(rowsInserted + " rows affected.");
			
			String query = "SELECT * FROM books";
	        System.out.println("Query SQL: " + query);
			ResultSet rs = pstm.executeQuery(query);
			while(rs.next()) {
	            System.out.println(rs.getInt("id") + ", "
	                  + rs.getString("author") + ", "
	                  + rs.getString("title") + ", "
	                  + rs.getDouble("price") + ", "
	                  + rs.getInt("qty"));
	         }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}