
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
    private double initialX;
    private double initialY;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                initialX = event.getSceneX();
                initialY = event.getSceneY();

            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                root.getScene().getWindow().setX(event.getScreenX() - initialX);

                root.getScene().getWindow().setY(event.getScreenY() - initialY);

            }
        });

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Conversor Alura");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}