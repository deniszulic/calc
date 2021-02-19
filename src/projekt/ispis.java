package projekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ispis extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("pocetni.fxml"));
        Scene scene = new Scene(root, 920, 600);
        stage.setTitle("Kalkulator");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setMaxWidth(937);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
