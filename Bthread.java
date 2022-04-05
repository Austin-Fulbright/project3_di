import java.util.*;
import java.io.*;
import java.net.*;


public class Bthread extends Thread{
    Socket socket;
    File logFile;
    public Bthread(Socket s, File log){
        socket = s;
        logFile = log;
    }
    public void run(){
        try{
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String msg = "";
            FileWriter logWrite = new FileWriter("log1.txt");
            while(true){
                msg = dis.readUTF();
                System.out.println(msg);
                logWrite.write("write this");
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
}