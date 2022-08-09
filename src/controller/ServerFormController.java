package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFormController {
    public TextArea textAria;
    public TextField txtServerMassege;
    Socket accept=null;

    public void initialize(){
        new Thread(()->{
           try {
               ServerSocket serverSocket=new ServerSocket(5000);
               System.out.println("Server Started!");
               accept=serverSocket.accept();
               System.out.println("Client Connected");
               InputStreamReader inputStreamReader = new InputStreamReader(accept.getInputStream());
               BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
               String recode = bufferedReader.readLine();
               System.out.println(recode);
           }catch (Exception e){

           }
        });
    }

    public void btnSendOnAction(ActionEvent actionEvent) throws IOException {
        PrintWriter printWriter = new PrintWriter(accept.getOutputStream());
        printWriter.println(txtServerMassege.getText());
        printWriter.flush();
    }
}
