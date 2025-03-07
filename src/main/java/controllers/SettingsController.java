package controllers;

import com.sun.javafx.scene.control.skin.Utils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SettingsController {
    @FXML
    private Button backButton;

    public void goBack() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    private Utils getClass() {
        return null;
    }
}
