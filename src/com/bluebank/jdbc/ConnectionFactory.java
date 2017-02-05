package com.bluebank.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException {
		Connection conexao =null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Conectado");
			conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "system", "admin");

		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
		return conexao;
	}
	

  
}
