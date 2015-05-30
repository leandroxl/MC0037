package br.edu.ufabc.prograd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection getConnection() {
		System.out.println("Conectando ao banco de dados.");
		try {
			String url = "jdbc:mysql://localhost/progweb";
			return DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
