package com.example.forestvibe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {

    public void setupButtonEventHandler(Button button) {
        button.setOnMouseEntered(this::handleMouseEntered);
        button.setOnMouseExited(this::handleMouseExited);
    }
    public void handleMouseExited(javafx.scene.input.MouseEvent mouseEvent) {
        Button sourceButton = (Button) mouseEvent.getSource();
        sourceButton.setStyle("-fx-background-color: transparent;");
    }

    public void handleMouseEntered(javafx.scene.input.MouseEvent mouseEvent) {
        Button sourceButton = (Button) mouseEvent.getSource();
        sourceButton.setStyle("-fx-background-color: transparent;");
    }



    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();



    }

    public static void main(String[] args) {
        launch(args);
    }

}

