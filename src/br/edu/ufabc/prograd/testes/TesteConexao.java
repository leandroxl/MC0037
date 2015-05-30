package br.edu.ufabc.prograd.testes;

import br.edu.ufabc.prograd.jdbc.ConnectionFactory;

public class TesteConexao {
	public static void main(String[] args) {
		try {
			new ConnectionFactory().getConnection();
			System.out.println("Conectado!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
