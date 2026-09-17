import java.io.*;
import java.net.*;

public class ServeurUDP
{
    public static void main(String[] args) throws Exception
    {
        DatagramSocket sock = new DatagramSocket(1234);
        while (true)
        {
            System.out.println("-Waiting data");
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            sock.receive(packet);
            String str = new String(packet.getData());
            System.out.println("str=" + str);

            InetAddress clientAddr = packet.getAddress();
            int clientPort = packet.getPort();
            byte[] reponse = str.getBytes();
            DatagramPacket packetReponse = new DatagramPacket(reponse, reponse.length, clientAddr, clientPort);
            sock.send(packetReponse);
        }
    }
}
