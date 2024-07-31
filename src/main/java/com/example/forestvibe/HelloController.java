package com.example.forestvibe;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    @FXML

    private BorderPane borderPane;
    @FXML
    private AnchorPane apane;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        splash();

    }
    private void splash(){
        new Thread(){
            public void run(){
                try{
                    Thread.sleep(2000);
                }catch (Exception e){
                    System.out.println(e);
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            borderPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
                            Stage stage = new Stage();
                            Scene scene = new Scene(borderPane);
                            stage.setTitle("Helow");
                            stage.setScene(scene);
                            //stage.setMinHeight(750);
                            //stage.setMinWidth(1250);
                            stage.setMinHeight(400);
                            stage.setMinWidth(600);
                            stage.setResizable(false);
                            stage.show();
                            apane.getScene().getWindow().hide();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }
                });

            }
        }.start();
    }
}
