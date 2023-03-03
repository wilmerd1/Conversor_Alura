

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
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
            public void handle(MouseEvent me) {
                initialX= me.getSceneX();
                initialY = me.getSceneY();
             
            }
          });
        
          root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
              
               
                root.getScene().getWindow().setX(me.getScreenX() - initialX);
                
                root.getScene().getWindow().setY(me.getScreenY() - initialY);
              
            }
          });
        

       /*  root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }

        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getSceneX() - xOffset);
                primaryStage.setY(event.getSceneY() - yOffset);
            }

        });*/


        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Conversor Alura");
      //  primaryStage.initModality(Modality.WINDOW_MODAL);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}