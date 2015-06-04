package com.raftelti.ufabc.mc0037.atividade1.dao;

import com.raftelti.ufabc.mc0037.atividade1.jdbc.ConnectionFactory;
import com.raftelti.ufabc.mc0037.atividade1.modelo.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
	private Connection connection;

	public ContatoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insere(Contato contato) {
		String sql = "INSERT INTO contatos (nome,email,endereco) VALUE(?,?,?)";

		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getEmail());
			statement.setString(3, contato.getEndereco());

			statement.execute();
			statement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

    public void remove(Contato contato) {
        String sql = "DELETE FROM contatos WHERE id = ?";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setLong(1, contato.getId());

            statement.execute();
            statement.close();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Contato contato) {
        String sql = "UPDATE contatos SET nome=?, email=?, endereco=? WHERE id = ?";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getEmail());
            statement.setString(3, contato.getEndereco());
            statement.setLong(4, contato.getId());

            statement.execute();
            statement.close();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

	public List<Contato> getLista() {
		List<Contato> contatos = new ArrayList<Contato>();
		String sql = "SELECT * FROM contatos ORDER BY nome";

		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				contatos.add(contato);
			}

			statement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return contatos;
	}
}
