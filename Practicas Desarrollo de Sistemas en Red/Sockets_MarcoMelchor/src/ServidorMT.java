import java.io.IOException;
import java.net.ServerSocket;

public class ServidorMT {
    public static void main(String args[]){
        try{
            ServerSocket serverSocket = new ServerSocket(6001);
            
            System.out.println("Servidor listo...");
            while(true){
                ManejadorCliente mc = new ManejadorCliente(serverSocket.accept());
                Thread hilo = new Thread(mc);
                
                hilo.start();
            }
        }catch(IOException ex){
            System.err.println(ex);
        }
    }
}