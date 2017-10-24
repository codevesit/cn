
package client;

import java.io.IOException;
import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Client {
    
    private static Socket socket;
    
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            String host = "localhost";
            int port = 3000;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);
            System.out.println("Enter the digits for operation");
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            int number1 = sc.nextInt();
            System.out.println("Enter 1 for addition");
            int number2 = sc.nextInt();
            String sendMessage = number+" "+number1+" "+number2+"\n";
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(sendMessage);
            bw.flush();
            
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
            System.out.println("Message received from the server : " +message);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        finally{
            try
            {
                socket.close();
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
        }
        
        
    }
    
}
