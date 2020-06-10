package com.company;

import Navegacao.EnumEstadoConsole;
import Singleton.SingletonImpressao;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
	// write your code here
        Boolean saida = false;

        SingletonImpressao.getInstancia().ativar();
        try{
            while (!saida){
                saida = EnumEstadoConsole.BEM_VINDO.getEstadoMaquina().Executa();
            }

        } finally {
            SingletonImpressao.getInstancia().desativar();
        }



    }
}
