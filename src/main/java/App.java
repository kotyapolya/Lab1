import com.sun.javafx.scene.control.skin.Utils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MainScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("My JavaFX App");
        stage.setScene(scene);
        stage.show();
    }

    private Utils getClass() {
        return null;
    }

    public static void main(String[] args) {
        launch();
    }
}
