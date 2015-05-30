package br.edu.ufabc.prograd.testes;

import br.edu.ufabc.prograd.dao.AlunoDAO;
import br.edu.ufabc.prograd.modelo.Aluno;

public class CriaAluno {
	public static void main(String[] args) {
		try {
			AlunoDAO alunoDao = new AlunoDAO();
			Aluno aluno = new Aluno();
			
			aluno.setNome("Rafael Telles");
			aluno.setEmail("raftel.ti@gmail.com");
			aluno.setEndereco("Santo André, SP");
			
			alunoDao.insere(aluno);
			
			System.out.println("Aluno inserido.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
