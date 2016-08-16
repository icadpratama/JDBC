package com.bsp.latihan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsertTest {
	private static Connection conn;
	private static Statement stm;
	
	public static void main(String[] args) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","");
			stm = conn.createStatement();

			String queryDelete = "DELETE FROM books WHERE id>=3000 AND id<4000";
			System.out.println("Query SQL: " + queryDelete);
			int countDeleted = stm.executeUpdate(queryDelete);
			System.out.println(countDeleted + " records deleted.\n");
			
			String queryInsert = "INSERT INTO books " 
					+ "VALUES (3001, 'Gone Fishing', 'Kumar', 11.11, 11)";
			System.out.println("Query SQL: " + queryInsert);
			int countInserted = stm.executeUpdate(queryInsert);
			System.out.println(countInserted + " records inserted.\n");
			
			queryInsert = "INSERT INTO books VALUES "
		               + "(3002, 'Gone Fishing 2', 'Kumar', 22.22, 22),"
		               + "(3003, 'Gone Fishing 3', 'Kumar', 33.33, 33)";
			System.out.println("Query SQL: " + queryInsert);
			countInserted = stm.executeUpdate(queryInsert);
			System.out.println(countInserted + " records inserted.\n");
			
	        queryInsert = "INSERT INTO books (id, title, author) "
	               + "VALUES (3004, 'Fishing 101', 'Kumar')";
	        System.out.println("Query SQL: " + queryInsert);
	        countInserted = stm.executeUpdate(queryInsert);
	        System.out.println(countInserted + " records inserted.\n");
	 
	        String query = "SELECT * FROM books";
	        System.out.println("Query SQL: " + query);
	        ResultSet rs = stm.executeQuery(query);
	        while(rs.next()) {
	            System.out.println(rs.getInt(1) + ", "
	                    + rs.getString(2) + ", "
	                    + rs.getString(3) + ", "
	                    + rs.getDouble(4) + ", "
	                    + rs.getInt(5));
	         }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}