package example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        int port = 8080; // порт для прослушивания входящих соединений

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server start...");

        System.out.println("Waiting client ...");
        Socket clientSocket = serverSocket.accept();

        try(BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            System.out.println("New connection accepted");

            String name = in.readLine();
            while (true) {
                System.out.println("Received message: " + name + " from client on port: " + clientSocket.getPort());

                out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                if (name.equals("Ildar")) {
                    break;
                }
            }
        }
    }
}