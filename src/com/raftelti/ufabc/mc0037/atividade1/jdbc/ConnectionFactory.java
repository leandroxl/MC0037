package com.raftelti.ufabc.mc0037.atividade1.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection getConnection() {
		System.out.println("Conectando ao banco de dados.");
		try {
			String url = "jdbc:mysql://localhost/agendadb";
			return DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
