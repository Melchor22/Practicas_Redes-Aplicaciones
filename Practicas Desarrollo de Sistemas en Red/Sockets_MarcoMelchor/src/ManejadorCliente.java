import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ManejadorCliente implements Runnable{
    private Socket ch;
    PrintWriter out;
    BufferedReader input;
    
    public ManejadorCliente(Socket ch) throws IOException{
        this.ch = ch;
        out = new PrintWriter(ch.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(ch.getInputStream()));
        
        System.out.println("\nConexión recibida de: " + ch.getInetAddress().getHostName());
    }
    
    @Override
    public void run() {
        try{
            out.println("Dato 1");
            out.println("Dato 2");
            
            System.out.println(input.readLine());
            
            out.close();
            input.close();
            ch.close();
        }catch(IOException ex){
            System.err.println(ex);
        }
    }
}