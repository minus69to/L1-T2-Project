package MyPraactice;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static int count=1;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(44444);
        System.out.println("Server is waiting");



            Socket clientSocket = serverSocket.accept();
            System.out.println("Server connected");
            ObjectInputStream ois=new ObjectInputStream(clientSocket.getInputStream());

        System.out.println("After opening a stream");
            System.out.println("Received message :"+ois.read());


    }
}
