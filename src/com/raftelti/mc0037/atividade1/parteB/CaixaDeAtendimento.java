package com.raftelti.mc0037.atividade1.parteB;

/**
 * Created by Rafael on 28/05/2015.
 */
public class CaixaDeAtendimento {
    private static int proximoDaFila = 0;
    private long id;

    public CaixaDeAtendimento(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void chamaProximoFila() {
        System.out.printf("Senha: %d\tCaixa: %d\n", ++proximoDaFila, id);
    }

    public static void main(String[] args) {
        CaixaDeAtendimento[] caixas = new CaixaDeAtendimento[5];
        for (int i = 0; i < 5; i++) {
            caixas[i] = new CaixaDeAtendimento(i + 1);
        }

        for (int i = 0; i < 10; i++) {
            caixas[(int) (5 * Math.random())].chamaProximoFila();
        }
    }
}
