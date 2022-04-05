import java.net.*;
import java.io.*;
import java.util.*;
public class Participant{

    public static void main(String args[]) throws Exception{
        //add two threads one for reciving messages from the cordinator(Thread-B)
        //one for reciving messages from the user(Thread-A)
        Socket client = new Socket("127.0.0.1", 8888);
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String Cmsg ="";
        String Smsg ="";
        while(Cmsg !="blap"){
            Cmsg = br.readLine();
            dos.writeUTF(Cmsg);
            Smsg= dis.readUTF();
            System.out.println(Smsg);
            dos.flush();
        }
        dis.close();
        dos.close();
        client.close();

    }

}
