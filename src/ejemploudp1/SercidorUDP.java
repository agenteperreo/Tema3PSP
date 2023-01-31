package ejemploudp1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class SercidorUDP {

    public static void main(String[] args) {
        try {
            System.out.println("Creación del socket");
            DatagramSocket socket =new DatagramSocket(41600);

            while(true) {
                System.out.println("Cración del array de bytes");
                byte[] buffer = new byte[32];

                System.out.println("Creación del datagrama");
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                System.out.println("A la espera de recibir datgrama");
                socket.receive(packet);

                System.out.println("Leemos el mensaje");
                String mensaje = new String(packet.getData());
                System.out.println("Mensaje enviado por el cliente: " + mensaje.trim());
            }

        } catch (SocketException e) {
            System.err.println("Error en la creacion del socket.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error en la recepcion del paquete.");
            e.printStackTrace();
        }
    }
}
