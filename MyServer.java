//MY SERVER CODE
import java.net.*;
import java.io.*;
import java.util.*;
class MyServer {
public static void main(String args[]) throws Exception {
Scanner input=new Scanner(System.in);
DataInputStream dis=null;
String data="";
DataOutputStream dos=null;
ServerSocket ss=new ServerSocket(3306);
System.out.println("Server is ready to talk...");
Socket s=ss.accept();
while(!data.equals("stop"))
{
 dis=new DataInputStream(s.getInputStream());
 data=dis.readUTF();
System.out.println("Client says:"+data);
System.out.println("Server says");
data=input.nextLine();
dos=new DataOutputStream(s.getOutputStream());
dos.writeUTF(data);
}
dis.close();
dos.flush();
dos.close();
s.close();
ss.close();
}}
//MY CLIENT CODE
import java.net.*;
import java.io.*;
import java.util.*;
class MyClient {
public static void main(String args[]) throws Exception {
Scanner input=new Scanner(System.in);
DataInputStream dis=null;
String data="";
DataOutputStream dos=null;
Socket s=new Socket("localhost",3306);
while(!data.equals("stop"))
{
 System.out.println("Client says:");
 data=input.nextLine();
dos=new DataOutputStream(s.getOutputStream());
dos.writeUTF(data);
dis=new DataInputStream(s.getInputStream());
data=dis.readUTF();
System.out.println("Server Says:"+data);
}
dos.flush();
dos.close();
dis.close();
s.close();
}}