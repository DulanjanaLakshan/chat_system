package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane root;
    public AnchorPane loginForm;
    public TextField txtUserName;

    static  String username;

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        username=txtUserName.getText();
        if (username.equals("")) {
            new Alert(Alert.AlertType.WARNING, "Please check your Username").showAndWait();
            clearloginOnAction();

        } else {
            Stage stage=(Stage) txtUserName.getScene().getWindow();
            stage.close();
            Stage stage1=new Stage();
            stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/Client1Form.fxml"))));
            stage1.setResizable(false);
            stage1.setTitle(username);
            stage1.centerOnScreen();
            stage1.show();
        }
    }
    public void clearloginOnAction() {
        txtUserName.clear();

    }

}
