import java.io.*;
import java.net.*;


public class ParticipantCl{
    public String ip = "";
    public int port = -1;
    public Socket socket = null;
    ParticipantCl (String IP, int por, Socket soc){
        ip = IP;
        port = por;
        socket = soc;
    }


}