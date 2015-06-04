package com.raftelti.ufabc.mc0037.atividade1.testes;

import br.edu.ufabc.prograd.dao.AlunoDAO;
import br.edu.ufabc.prograd.modelo.Aluno;

import java.util.List;

public class ListaContato {
	public static void main(String[] args) {
		AlunoDAO alunoDao = new AlunoDAO();
		List<Aluno> alunos = alunoDao.listar();
		
		for(Aluno aluno : alunos) {
			System.out.println(aluno.getNome());
		}
	}
}
