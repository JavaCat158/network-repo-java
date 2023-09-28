package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        int port = 8080; // порт для прослушивания входящих соединений

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server start...");

        while (true) {
            System.out.println("Loading ...");
            Socket clientSocket = serverSocket.accept();

            System.out.println("New connection accepted");
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String name = in.readLine();
            System.out.println("Received message: " + name + " from client on port: " + clientSocket.getPort());

            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

            clientSocket.close();
            System.out.println("Connection closed");
        }
    }
}