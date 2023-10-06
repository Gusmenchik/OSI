import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 64889;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            try (Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
            ) {
                System.out.println("New connection accepted");
                final String name = in.readLine();
                System.out.printf("Hi %s, your port is %d%n", name, clientSocket.getPort());
            }
        }
    }
}

