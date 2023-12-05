import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String args[]){
        int puerto = 6001;
        
        try{
            ServerSocket serverSocket = new ServerSocket(puerto);
            
            while(true){
                Socket ch = serverSocket.accept();
                PrintWriter out = new PrintWriter(ch.getOutputStream(), true);
                InputStreamReader isr = new InputStreamReader(ch.getInputStream());
                BufferedReader input = new BufferedReader(isr);
                
                out.println("Dato 1");
                out.println("Dato 2");
                
                System.out.println(input.readLine());
                
                out.close();
                input.close();
                isr.close();
                ch.close();
                serverSocket.close();
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}