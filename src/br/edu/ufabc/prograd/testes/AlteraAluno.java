package br.edu.ufabc.prograd.testes;

import br.edu.ufabc.prograd.dao.AlunoDAO;
import br.edu.ufabc.prograd.modelo.Aluno;

public class AlteraAluno {
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno c = alunoDAO.getLista().get(0);

        c.setEmail("teste@gmail.com");

        alunoDAO.altera(c);
        System.out.println("Aluno alterado.");
    }
}
