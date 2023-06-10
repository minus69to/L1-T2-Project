package com.example.javapart2final;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static List<Movies> mv = new ArrayList();


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final String INPUT_FILE_NAME = "movies.txt";

            BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));

            while (true)
            {
                String line = br.readLine();
                if (line == null) break;
                String [] str = line.split(",");

                Movies m = new Movies(str[0],str[1],str[2],str[3],str[4],str[5],str[6],str[7],str[8]);
                mv.add(m);
            }

            br.close();

        ServerSocket serverSocket = new ServerSocket(22223);
        System.out.println("Server Started...");



        while (true)
        {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            new ServerThread(ois,oos);


        }

    }
}
class ServerThread implements Runnable{
    ObjectInputStream ois ;
    ObjectOutputStream oos ;

    public ServerThread(ObjectInputStream ois, ObjectOutputStream oos) {
        this.ois = ois;
        this.oos = oos;
        Thread th = new Thread(this);
        th.start();

    }

    @Override
    public void run(){
        while (true)  {
                List<Movies> mv2 = new ArrayList();
                mv2.clear();



                try {
                    Object cMsg = ois.readObject();
                    if (cMsg instanceof String) {
                        String serverMsg = (String) cMsg;
                        for (Movies m : Server.mv) {
                            if (m.getProductionCom().equalsIgnoreCase(serverMsg)) {
                                mv2.add(m);
                            }
                        }
                        oos.writeObject(mv2);
                    }


                    if (cMsg instanceof Movies) {
                        Movies M = (Movies) cMsg;
                        Server.mv.add(M);

                        final String OUTPUT_FILE_NAME = "movies.txt";


                        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
                        for (Movies m : Server.mv) {
                            bw.write(m.getTitle() + "," + m.getYearR() + "," + m.getGenre1() + "," + m.getGenre2() + "," + m.getGenre3() + "," + m.getRuntime() + "," + m.getProductionCom() + "," + m.getBudget() + "," + m.getRevenue());
                            bw.write(System.lineSeparator());
                        }
                        bw.close();

                    }
                    if (cMsg instanceof String[]) {
                        String[] string = (String[]) cMsg;
                        for (Movies m : Server.mv) {
                            if (m.getTitle().equalsIgnoreCase(string[0]) && m.getProductionCom().equalsIgnoreCase(string[1]))
                                m.setProductionCom(string[2]);
                        }


                        final String OUTPUT_FILE_NAME = "movies.txt";

                        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
                        for (Movies m : Server.mv) {
                            bw.write(m.getTitle() + "," + m.getYearR() + "," + m.getGenre1() + "," + m.getGenre2() + "," + m.getGenre3() + "," + m.getRuntime() + "," + m.getProductionCom() + "," + m.getBudget() + "," + m.getRevenue());
                            bw.write(System.lineSeparator());
                        }
                        bw.close();
                    }
                    if (cMsg instanceof Integer ){
                        break;
                    }
                }catch (Exception ignored){}

        }

    }
}