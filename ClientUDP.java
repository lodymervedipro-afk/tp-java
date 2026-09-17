import java.io.*;
import java.net.*;

public class ClientUDP
{
    public static void main(String[] args) throws Exception
    {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("adresse=" + addr.getHostName());

        String s = "Hello World";
        byte[] data = s.getBytes();

        DatagramPacket packet = new DatagramPacket(data, data.length, addr, 1234);
        DatagramSocket sock = new DatagramSocket();
        sock.send(packet);

        DatagramPacket packetReponse = new DatagramPacket(new byte[1024], 1024);
        sock.receive(packetReponse);
        String reponse = new String(packetReponse.getData());
        System.out.println("Réponse du serveur : " + reponse);

        sock.close();
    }
}
