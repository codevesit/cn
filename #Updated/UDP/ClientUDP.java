import java.io.*;
import java.util.*;
import java.net.*;
class ClientUDP
{
public static void main(String args[])throws IOException
{
BufferedReader br=new BufferedReader(new 
InputStreamReader(System.in));
DatagramSocket ds=new DatagramSocket();
InetAddress ip=InetAddress.getByName("localhost");
byte[] sendData=new byte[3];
byte[] recData=new byte[3];
System.out.println("Enter your name :");
String input=br.readLine();
sendData=input.getBytes();
DatagramPacket dp=new 
DatagramPacket(sendData,sendData.length,ip,2100);
ds.send(dp);
DatagramPacket dp1=new 
DatagramPacket(recData,recData.length);
ds.receive(dp1);
String output=new String(dp1.getData());
System.out.println(output);
ds.close();
}
}
