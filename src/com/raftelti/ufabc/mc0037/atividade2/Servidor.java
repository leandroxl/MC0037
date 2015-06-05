package com.raftelti.ufabc.mc0037.atividade2;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rafael on 04/06/2015.
 */
public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Servidor em execução!");
            while (true) {

                Socket clientSocket = serverSocket.accept();

                InputStream in = clientSocket.getInputStream();
                OutputStream out = clientSocket.getOutputStream();

                byte[] bReq = new byte[256];
                in.read(bReq);
                String req = new String(bReq);

                Pattern pattern = Pattern.compile("GET \\/(.+) HTTP\\/1\\.1");
                Matcher matcher = pattern.matcher(req);
                String recurso = "index.html";
                if (matcher.find()) {
                    recurso = matcher.group(1);
                }

                String res = geraRespostaHTTP(recurso);
                out.write(res.getBytes());
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String geraRespostaHTTP(String recurso) throws IOException {
        System.out.print("Recurso: " + recurso);
        StringBuilder corpo = new StringBuilder();
        StringBuilder resposta = new StringBuilder();
        try {
            URL resource = Servidor.class.getResource("webcontent/" + recurso);
            File file = new File(resource.getFile());

            InputStream in = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));

            String line;
            while ((line = reader.readLine()) != null) {
                corpo.append(line).append("\n");
            }
            in.close();
            resposta.append("HTTP/1.1 200 OK").append("\n");
            resposta.append("Content-Type: " + Files.probeContentType(file.toPath())).append("\n");
        } catch (Exception e) {
            System.out.print(" - " + e);
            resposta.append("HTTP/1.1 500 Internal Server Error").append("\n");
        }
        resposta.append("Server: Test Server").append("\n");
        resposta.append("Connection: Close").append("\n");
        resposta.append("\n");
        resposta.append(corpo);

        System.out.println();

        return resposta.toString();
    }
}
