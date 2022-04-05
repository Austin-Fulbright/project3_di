import java.net.*;
import java.util.*;
import java.io.*;

public class ParticipantThread extends Thread{
    Socket socket;
    ParticipantThread(Socket st){
        socket = st;
    }
    public void run(){
        try{
        DataInputStream istream = new DataInputStream(socket.getInputStream());
        DataOutputStream ostream = new DataOutputStream(socket.getOutputStream());
        System.out.println("thread started");
        String msg = "";
        String nextmsg = "";
        while(true){
            //check if it has been registered, if it has been registred
            //update the map with the newly online user
            msg = istream.readUTF();
            System.out.println(msg);
            String message = "";
            //ostream.writeUTF(msg);
            //ostream.flush();
            //if command == recconect then get the ID and then the port and ip adress, update information
            if(msg.equals("register")){
                nextmsg = istream.readUTF();
                System.out.println(nextmsg+"first message taken");
                ParticipantCl currentPart = new ParticipantCl(nextmsg, 111, socket);
                nextmsg = istream.readUTF();
                System.out.println(nextmsg+"second"+currentPart.ip);
                Cordinator.participants.put(Integer.parseInt(nextmsg), currentPart);
                //System.out.println(Cordinator.participants.get(Integer.parseInt(nextmsg)).ip + " this is the port");        
            }
            if(msg.equals("deregister")){
                nextmsg = istream.readUTF();
                System.out.println(nextmsg+"first message taken");
                Cordinator.participants.remove(Integer.parseInt(nextmsg));
                System.out.println(Cordinator.participants.isEmpty());
            }
            if(msg.equals("multicast send")){
                nextmsg = istream.readUTF();
                Cordinator.multicastSend(nextmsg);
            }
        }
        }catch(Exception e){
            System.out.println(e);
        }
    }


}