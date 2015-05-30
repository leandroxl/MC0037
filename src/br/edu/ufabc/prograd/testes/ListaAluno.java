package br.edu.ufabc.prograd.testes;

import java.util.List;

import br.edu.ufabc.prograd.dao.AlunoDAO;
import br.edu.ufabc.prograd.modelo.Aluno;

public class ListaAluno {
	public static void main(String[] args) {
		AlunoDAO alunoDao = new AlunoDAO();
		List<Aluno> alunos = alunoDao.listar();
		
		for(Aluno aluno : alunos) {
			System.out.println(aluno.getNome());
		}
	}
}
