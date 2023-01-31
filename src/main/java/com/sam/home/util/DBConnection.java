package com.sam.home.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() throws Exception {
		String userid = "user01";
		String pwd = "user01";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		
		Connection connection = DriverManager.getConnection(url, userid, pwd);
		
		
		return connection;
	}
	public static void disConnection(PreparedStatement preparedStatement, Connection connection) throws Exception {
		preparedStatement.close();
		connection.close();
	}
	public static void disConnection(ResultSet resultSet,PreparedStatement preparedStatement, Connection connection) throws Exception {
		resultSet.close();
		preparedStatement.close();
		connection.close();
	}
	
}
