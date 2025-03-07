package controllers;

import com.sun.javafx.scene.control.skin.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainController {
    @FXML
    private Button settingsButton;

    @FXML
    private TextField nameField;

    public void openSettings() {
        Stage stage = (Stage) settingsButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/SettingsScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    private Utils getClass() {
        return null;
    }
}
