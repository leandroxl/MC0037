package com.raftelti.ufabc.mc0037.atividade1.testes;


import com.raftelti.ufabc.mc0037.atividade1.dao.ContatoDAO;
import com.raftelti.ufabc.mc0037.atividade1.modelo.Contato;

public class CriaContato {
    public static void main(String[] args) {
        try {
            ContatoDAO contatoDao = new ContatoDAO();
            Contato contato = new Contato();

            contato.setNome("Rafael Telles");
            contato.setEmail("raftel.ti@gmail.com");
            contato.setEndereco("Santo André, SP");

            contatoDao.insere(contato);

            System.out.println("Contato inserido.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
