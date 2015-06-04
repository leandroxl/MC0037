package com.raftelti.ufabc.mc0037.atividade1.testes;

import com.raftelti.ufabc.mc0037.atividade1.dao.ContatoDAO;
import com.raftelti.ufabc.mc0037.atividade1.modelo.Contato;

import java.util.List;

public class ListaContato {
    public static void main(String[] args) {
        ContatoDAO contatoDao = new ContatoDAO();
        List<Contato> contatos = contatoDao.getLista();

        for (Contato contato : contatos) {
            System.out.println(contato.getNome());
        }
    }
}
