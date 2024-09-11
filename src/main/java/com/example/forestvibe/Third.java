package com.example.forestvibe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;

public class Third extends HelloApplication implements Initializable {
    @FXML
    private Button btn;
    @FXML
    public Button btn2;
    @FXML
    public Button btn3;
    @FXML
    public Button btn4;
    public Button btn5;
    private Stage stage;
    private Scene scene;

    @FXML
    private ImageView gallery;
    @FXML
    private Pane display;
    @FXML
    private VBox leef;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private Label selectedLabel;

    private String selected;

    private int imgIndex = 0;
    String [] arr1 ={"forests/kanneliya/caption (1).jpg","forests/kanneliya/caption (2).jpg","forests/kanneliya/caption (3).jpg","forests/kanneliya/caption (4).jpg"};
    String [] arr2 = {"forests/sinharaja/image1.jpeg","forests/sinharaja/image2.jpg","forests/sinharaja/image3.jpeg","forests/sinharaja/image4.jpeg","forests/sinharaja/1.jpeg","forests/sinharaja/2.jpeg","forests/sinharaja/3.jpeg","forests/sinharaja/4.jpeg","forests/sinharaja/5.jpeg"};
    String [] arr3 = {"forests/Badagamuwa Conservation Forest/img1.jpg","forests/Badagamuwa Conservation Forest/img2.jpg"};
    String [] arr4 = {"forests/Riverstone/river.jpg","forests/Riverstone/riverstone-excursion(1).jpg","forests/Riverstone/riverstone-excursion.jpg","forests/Riverstone/riverstone-gap(1).jpg","forests/Riverstone/riverstone-gap.jpg","forests/Riverstone/sera-ella.jpg"};
    String [] arr5 = {};
    public void switchtoscene1(javafx.event.ActionEvent event) throws IOException {
        // Load the content of Secondpage.fxml
        Parent root = FXMLLoader.load(getClass().getResource("Firstpage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchtoscene2(javafx.event.ActionEvent event) throws IOException {
        // Load the content of Secondpage.fxml
        Parent root = FXMLLoader.load(getClass().getResource("Secondpage.fxml"));
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        super.setupButtonEventHandler(btn);
        super.setupButtonEventHandler(btn2);
        super.setupButtonEventHandler(btn3);
        super.setupButtonEventHandler(btn4);
        super.setupButtonEventHandler(btn5);


        CardController card = new CardController();



        ObservableList<String> items = FXCollections.observableArrayList(
                "Sinharaja Forest",
                "Badagamuwa Forest",
                "Kanneliya Forest",
                "Riverston"
        );
        combo.setItems(items);
        // Create a map to associate each forest name with its corresponding FXML file
        Map<String, String> forestFXMLMap = new HashMap<>();
        forestFXMLMap.put("Sinharaja Forest", "card.fxml");
        forestFXMLMap.put("Badagamuwa Forest", "card2.fxml");
        forestFXMLMap.put("Kanneliya Forest", "card3.fxml");
        forestFXMLMap.put("Riverston", "card4.fxml");
        // Set up an event handler for the ComboBox
        combo.setOnAction(event -> {
            // Get the selected item
            selected = combo.getSelectionModel().getSelectedItem();
            // Load the corresponding FXML file
            String fxmlFile = forestFXMLMap.get(selected);
            if (fxmlFile != null) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
                    leef = loader.load();
                    display.getChildren().clear();
                    display.getChildren().add(leef);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // Call your function with the selected item
            selectedLabel.setText(selected);
            if ("Kanneliya Forest".equals(selected)) {
                Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream(arr1[0])));
                gallery.setImage(img);
                arr5 = arr1;
            }
            else if("Sinharaja Forest".equals(selected)){
                Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream(arr2[0])));
                gallery.setImage(img);
                arr5 = arr2;
            }
            else if("Badagamuwa Forest".equals(selected)){
                Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream(arr3[0])));
                gallery.setImage(img);
                arr5 = arr3;
            }
            else if("Riverston".equals(selected)){
                Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream(arr4[0])));
                gallery.setImage(img);
                arr5 = arr4;
            }
        });



        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("card.fxml"));
            leef = loader.load();
            display.getChildren().add(leef);



            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }








    public void next(ActionEvent actionEvent) {
        if (imgIndex < arr5.length) {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(arr5[imgIndex])));
            gallery.setImage(image);
            imgIndex++;

            // If you want to loop back to the first image after reaching the last one
            if (imgIndex == arr1.length) {
                imgIndex = 0;
            }
        }

    }
}
