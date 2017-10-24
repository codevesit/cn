/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    private static Socket socket;
    
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            int port = 3000;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port "+port);
            while(true)
            {
                socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
//                BufferedReader br = new BufferedReader(isr);
                Scanner sc = new Scanner(isr);
                int number = sc.nextInt();
                int number1 = sc.nextInt();
                int number2 = sc.nextInt();
                System.out.println("Message received from client is "+number);
                String returnMessage = null;
                switch(number2)
                {
                    case 1:
                         returnMessage = String.valueOf(number+number1) + "\n";
                }
                
                
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println("Message sent to the client is "+returnMessage);
                bw.flush();
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
        finally{
            try
            {
                socket.close();
            }
            catch(IOException e){}
        }
    }
    
}
