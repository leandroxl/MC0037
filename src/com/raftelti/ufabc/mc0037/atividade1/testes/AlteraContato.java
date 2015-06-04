package com.raftelti.ufabc.mc0037.atividade1.testes;

import com.raftelti.ufabc.mc0037.atividade1.dao.ContatoDAO;
import com.raftelti.ufabc.mc0037.atividade1.modelo.Contato;

public class AlteraContato {
    public static void main(String[] args) {
        ContatoDAO contatoDAO = new ContatoDAO();
        Contato c = contatoDAO.getLista().get(0);

        c.setEmail("teste@gmail.com");

        contatoDAO.altera(c);
        System.out.println("Contato alterado.");
    }
}
