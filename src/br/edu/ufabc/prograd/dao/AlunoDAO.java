package br.edu.ufabc.prograd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufabc.prograd.jdbc.ConnectionFactory;
import br.edu.ufabc.prograd.modelo.Aluno;

public class AlunoDAO {
	private Connection connection;

	public AlunoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insere(Aluno aluno) {
		String sql = "INSERT INTO alunos (nome,email,endereco) VALUE(?,?,?)";

		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getEmail());
			statement.setString(3, aluno.getEndereco());

			statement.execute();
			statement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

    public void remove(Aluno aluno) {
        String sql = "DELETE FROM alunos WHERE id = ?";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setLong(1, aluno.getId());

            statement.execute();
            statement.close();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Aluno aluno) {
        String sql = "UPDATE alunos SET nome=?, email=?, endereco=? WHERE id = ?";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getEmail());
            statement.setString(3, aluno.getEndereco());
            statement.setLong(4, aluno.getId());

            statement.execute();
            statement.close();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

	public List<Aluno> getLista() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		String sql = "SELECT * FROM alunos ORDER BY nome";

		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getLong("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setEndereco(rs.getString("endereco"));
				
				alunos.add(aluno);
			}

			statement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return alunos;
	}
}
