package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class NipunaFormController implements Initializable {
    public TextField txtMassage;
    public TextArea txtAria;
    static Socket socket = null;
    static DataInputStream dataInputStream;
    static DataOutputStream dataOutputStream;

    String messageIn = "";
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket=new Socket("localhost",5000);
                    dataInputStream=new DataInputStream(socket.getInputStream());
                    dataOutputStream=new DataOutputStream(socket.getOutputStream());



                    while (!messageIn.equals("end")){
                        messageIn=dataInputStream.readUTF();
                        txtAria.appendText("\nServer :"+messageIn.trim()+"\n");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public void btnMassageOnAction(ActionEvent actionEvent) throws IOException {
        String reply = "";
        reply=txtMassage.getText();
        txtAria.appendText(("\t\t\t\t\t\t\t\tNipuna:" +reply.trim()));
        dataOutputStream.writeUTF(reply);
        txtMassage.setText("");
    }
}
