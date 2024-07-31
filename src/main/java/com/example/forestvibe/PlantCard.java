package com.example.forestvibe;

import Model.Plant;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class PlantCard {

    @FXML
    private VBox plantcd;

    @FXML
    private ImageView plantimg;

    @FXML
    private  Label plantname;
    private Plant plant;
    private Label fruitname;

    public void setData(Plant plant){

        plantname.setText(plant.getName());

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(plant.getImgsrc())));
        plantimg.setImage(image);
        plantimg.getImage();

    }



}
