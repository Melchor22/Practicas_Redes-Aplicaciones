
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    public static void main(String args[]){
        String ipServidor = "localhost";
        int puerto = 6001;
        
        try{
            Socket clientSocket = new Socket(ipServidor, puerto);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader input = new BufferedReader(isr);
            
            System.out.println(input.readLine());
            System.out.println(input.readLine());
            
            out.println("Confirmación");
            
            out.close();
            input.close();
            isr.close();
            clientSocket.close();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}