package lk.hasindu.viewandsavepdf;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/mainPage.fxml"));

        stage.setTitle("View and Save PDF");

        Scene scene = new Scene(new Group(load));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}