import java.util.*;
import java.io.*;
import java.net.*;


public class Athread extends Thread{
    Socket socket;
    Integer clientID;
    public Athread(Socket s, Integer id){
        socket = s;
        clientID = id;
    }
    public void run(){
 
        try{
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String msg = "";
            while(true){
                msg = br.readLine();
                dos.writeUTF(msg);
                dos.flush();
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
}