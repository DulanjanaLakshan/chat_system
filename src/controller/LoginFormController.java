package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public TextField txtUsername;
    public PasswordField txtPassword;

    private final String n_user = "nipuna";
    private final String n_password = "1234";

    private final String o_user = "oshada";
    private final String o_password = "admin";
    Stage primaryStage;

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        if (n_user == txtUsername.toString() && n_password == txtPassword.toString()) {
            Parent load = FXMLLoader.load(getClass().getResource("../views/NipunaForm.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else if (o_user == txtUsername.toString() && o_password == txtPassword.toString()){
            Parent load = FXMLLoader.load(getClass().getResource("../views/OshadaForm.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else {
            Parent load = FXMLLoader.load(getClass().getResource("../views/NipunaForm.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
    }

    public void closeOnAction(ActionEvent actionEvent) {
    }
}
