package org.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        String fraseCliente;
        String fraseMaiuscula;
        ServerSocket socketRecepcao = new ServerSocket(8080);
        while (true) {
            Socket socketConexao = socketRecepcao.accept();
            System.out.println("Conexão");
            BufferedReader doCliente = new BufferedReader(new InputStreamReader(socketConexao.getInputStream()));
            DataOutputStream paraCliente = new DataOutputStream(socketConexao.getOutputStream());
            fraseCliente = doCliente.readLine();
            fraseMaiuscula = fraseCliente.toUpperCase() + "\n";
            paraCliente.writeBytes(fraseMaiuscula);

        }



    }
}