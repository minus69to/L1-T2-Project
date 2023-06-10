package MyPraactice;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",44444);
        System.out.println("client connected");

        ObjectOutputStream oos= new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());



          oos.writeObject("hello");
        System.out.println("After writing");


    }
}
