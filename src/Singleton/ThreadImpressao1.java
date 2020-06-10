package Singleton;
import java.io.*;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ThreadImpressao1 extends Thread {
    private boolean status;

    private static ServerSocket server;
    private static int port = 11340;
    private List<ClientManager> clientesConectados = Collections.synchronizedList(new ArrayList<ClientManager>());



    @Override
    public void run() {
       try {
           status = true;
           server = new ServerSocket (port);

            while (status) {
                String imprimir = SingletonImpressao.getInstancia().retiraMsgImpressao();

                if (imprimir != null) {
                    try {
                        impressaoMsg(imprimir);
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        } catch(IOException  ex)
       {
            if (ex.getMessage().equals("socket Closed")){
                System.out.println("Conexão Server Encerrada");
            } else {
                Logger.getLogger(ThreadImpressao1.class.getName()).log(Level.SEVERE, null, ex);
            }
       }



    }
    private void impressaoMsg(String imprimir) throws IOException, InterruptedException {
        System.out.println(imprimir);
        Thread.sleep(1000);
    }


    public void setStatus(boolean _status) {
        status = _status;
    }
}
