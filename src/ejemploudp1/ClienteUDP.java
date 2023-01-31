package ejemploudp1;

import java.io.IOException;
import java.net.*;

public class ClienteUDP {
    public static void main(String[] args) {
        try {
            //Obtener la IP local
            InetAddress ip = InetAddress.getLocalHost();

            //
            System.out.println("Creación del socket.");
            DatagramSocket socket=new DatagramSocket();

            //Creacion del mensaje
            String mensaje="Hola Diego";
            byte[] buffer= mensaje.getBytes();
            DatagramPacket packet=new DatagramPacket(buffer, buffer.length, ip, 41600);

            System.out.println("Enviamos el paquete");
            socket.send(packet);

            //Cerramos el socket
            socket.close();
        } catch (SocketException e) {
            System.err.println("Error en la creación del socket.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error en el envio del paquete.");
            e.printStackTrace();
        }
    }
}
