package Singleton;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SingletonImpressao {
    private static SingletonImpressao instancia;
    ThreadImpressao1 thread;

    LinkedList<String> filaImprimir;

    private SingletonImpressao() {
        filaImprimir = new LinkedList<>();
    }

    public static SingletonImpressao getInstancia() {
        if (instancia == null)
            instancia = new SingletonImpressao();
        return instancia;
    }
    List<ThreadImpressao1> threads;
    public void CapturaimpressaoMsg(String msgAuditoria)
         {
            filaImprimir.add(msgAuditoria);
        }


     String retiraMsgImpressao()
    {
            String msg = filaImprimir.poll();
            return msg;
    }

    public void ativar()
    {
            if (threads == null) {
                threads = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    ThreadImpressao1 thread = new ThreadImpressao1();
                    thread.setName("Thread " + (i + 1));
                    thread.start();
                    threads.add(thread);
                }
            }
        }


    public void desativar() throws InterruptedException {
        if (thread != null) {
            thread.setStatus(false);
            thread.join(2000);
            if (thread.isAlive()) {
                thread.interrupt();
            }
        }
    }
}