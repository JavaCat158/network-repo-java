package example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {
        String host = "localhost"; // адрес сервера
        int port = 8080; // порт сервера

        Socket socket = new Socket(host, port);
        System.out.println("Connected to server on port: " + port);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String name = "Ildar"; // строка для отправки на сервер
        out.println(name);

        String response = in.readLine();
        System.out.println(response + " from server");

        socket.close();
        System.out.println("Connection closed");
    }
}