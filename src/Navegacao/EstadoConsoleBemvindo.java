package Navegacao;

import java.io.IOException;
import java.util.Scanner;

public class EstadoConsoleBemvindo extends MaquinaEstadoConsole{

    public boolean Executa() throws IOException{
        boolean sair = false;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Bem Vindo!");
            System.out.println("Por favor informe a opção desejada:");
            System.out.println("1 - Iniciar impressões");
            System.out.println("2 - Sair");
            int opcao = scan.nextInt();

            switch (opcao) {
                case 2:
                    sair = true;
                    break;
                case 1:
                    EnumEstadoConsole.IMPRIMINDO.getEstadoMaquina().Executa();
                    sair = true;
                    break;
                default:
                    System.out.println("Comando desconhecido!");
                    break;
            }

        }while (sair == false);

        return false;


    }




}
