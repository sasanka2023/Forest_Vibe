package com.example.forestvibe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Secondpage extends HelloApplication implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button btn;
    @FXML
    public Button btn2;
    @FXML
    public Button btn3;
    @FXML
    public Button btn4;
    @FXML
    public Button btn5;
    private VBox box1;
    @FXML
    private Pane pane1;
    public void switchtoscene1(javafx.event.ActionEvent event) throws IOException {
        // Load the content of Secondpage.fxml
        Parent root = FXMLLoader.load(getClass().getResource("Firstpage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchtoscene3(javafx.event.ActionEvent event) throws IOException {
        // Load the content of Secondpage.fxml
        Parent root = FXMLLoader.load(getClass().getResource("Third.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchtoscene4(javafx.event.ActionEvent event) throws IOException {
        // Load the content of Secondpage.fxml
        Parent root = FXMLLoader.load(getClass().getResource("four.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchtoscene5(javafx.event.ActionEvent event) throws IOException {
        // Load the content of Secondpage.fxml
        Parent root = FXMLLoader.load(getClass().getResource("plants.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void lesson1() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("lesson1.fxml"));
        box1 = loader.load();
        pane1.getChildren().clear();
        pane1.getChildren().add(box1);
    }
    public void lesson2() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("lesson2.fxml"));
        box1 = loader.load();
        pane1.getChildren().clear();
        pane1.getChildren().add(box1);
    }
    public void lesson3() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("lesson3.fxml"));
        box1 = loader.load();
        pane1.getChildren().clear();
        pane1.getChildren().add(box1);
    }
    public void lesson4() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("lesson4.fxml"));
        box1 = loader.load();
        pane1.getChildren().clear();
        pane1.getChildren().add(box1);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.setupButtonEventHandler(btn);
        super.setupButtonEventHandler(btn2);
        super.setupButtonEventHandler(btn3);
        super.setupButtonEventHandler(btn4);
        super.setupButtonEventHandler(btn5);

    }



}
