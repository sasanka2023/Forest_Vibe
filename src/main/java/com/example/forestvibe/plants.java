package com.example.forestvibe;

import Model.Plant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class plants extends HelloApplication implements Initializable {


    @FXML
    private Button btn;
    @FXML
    public Button btn2;
    @FXML
    public Button btn3;
    @FXML
    public Button btn4;
    public Button btn5;
    @FXML
    private ImageView imageview;
    @FXML

    private Stage stage;
    private Scene scene;

    @FXML
    private VBox chosenplant;

    @FXML
    private Label chplantdesc;

    @FXML
    private ImageView chplantname;

    @FXML
    private Label fruitname;

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private Label l3;

    @FXML
    private Label l4;

    @FXML
    private Label l5;

    @FXML
    private Label l6;

    @FXML
    private HBox plantlayout;

    @FXML
    private ScrollPane scroll;
    @FXML
    private TextField search;


    @FXML
    private TableView<PlantDetails> table; // Make sure to replace ModelClass with your actual class type

    @FXML
    private TableColumn<PlantDetails, String> c1; // Replace ModelClass and String with your actual types

    @FXML
    private TableColumn<PlantDetails, String> c2;




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






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.setupButtonEventHandler(btn);
        super.setupButtonEventHandler(btn2);
        super.setupButtonEventHandler(btn3);
        super.setupButtonEventHandler(btn4);
        super.setupButtonEventHandler(btn5);
        //plantlayout.setVisible(false);
        List<Plant> recentlyAdded = new ArrayList<>(recentlyAdded());
        List<Plant> recentlyAdded2 = new ArrayList<>(recentlyAdded2());
        c1.setCellValueFactory(new PropertyValueFactory<>("propertyname"));
        c2.setCellValueFactory(new PropertyValueFactory<>("propertydetails"));
        c1.setText("Property");
        c2.setText("Value");



    }
    private List<Plant> recentlyAdded(){
        List<Plant> ls = new ArrayList<>();

        Map<String,String> plantlist = new HashMap<>();
        plantlist.put("Rose","plants/webpc-passthru.jpg");
        plantlist.put("Baby Rose","plants/Flower/Baby_Roses.jpg");
        plantlist.put("Begonia","plants/Flower/Begonia.jpg");
        plantlist.put("Cannas","plants/Flower/Cannas.jpg");
        plantlist.put("Celosia","plants/Flower/Celosia.jpg");
        plantlist.put("Dianthus","plants/Flower/Dianthus.jpg");

        for(Map.Entry<String,String> e : plantlist.entrySet() ){
            Plant plant = new Plant();
            plant.setName(e.getKey());
            plant.setImgsrc(e.getValue());
            ls.add(plant);
        }

        return ls;
    }
    private List<Plant> recentlyAdded4(){
        List<Plant> ls = new ArrayList<>();

        Map<String,String> plantlist = new HashMap<>();
        plantlist.put("Bandakka","plants/Vegetable/Bandakka.jpg");
        plantlist.put("Cabbage","plants/Vegetable/Cabbage.jpg");
        plantlist.put("Dambala","plants/Vegetable/Dambala.jpg");
        plantlist.put("Nivithi","plants/Vegetable/Nivithi.jpg");
        plantlist.put("Wam Batu","plants/Vegetable/Wam_Batu.jpg");


        for(Map.Entry<String,String> e : plantlist.entrySet() ){
            Plant plant = new Plant();
            plant.setName(e.getKey());
            plant.setImgsrc(e.getValue());
            ls.add(plant);
        }

        return ls;
    }
    private List<Plant> recentlyAdded3(){
        List<Plant> ls = new ArrayList<>();

        Map<String,String> plantlist = new HashMap<>();
        plantlist.put("Dawu","plants/Medicine/Dawu.jpg");
        plantlist.put("Eththora","plants/Medicine/Eththora.jpg");
        plantlist.put("Karaliringuru","plants/Medicine/Karaliringu.jpg");
        plantlist.put("Lunumidella","plants/Medicine/Lunumidella.jpg");
        plantlist.put("Wadakaha","plants/Medicine/Wadakaha.jpg");


        for(Map.Entry<String,String> e : plantlist.entrySet() ){
            Plant plant = new Plant();
            plant.setName(e.getKey());
            plant.setImgsrc(e.getValue());
            ls.add(plant);
        }

        return ls;
    }
    private List<Plant> recentlyAdded2(){
        List<Plant> ls = new ArrayList<>();
        Plant plant = new Plant();
        plant.setName("Mango");
        plant.setImgsrc("plants/mango.png");
        ls.add(plant);

        plant = new Plant();
        plant.setName("Mango");
        plant.setImgsrc("plants/mango.png");
        ls.add(plant);

        plant = new Plant();
        plant.setName("Mango");
        plant.setImgsrc("plants/mango.png");
        ls.add(plant);

        plant = new Plant();
        plant.setName("Mango");
        plant.setImgsrc("plants/mango.png");
        ls.add(plant);

        plant = new Plant();
        plant.setName("Mango");
        plant.setImgsrc("plants/mango.png");
        ls.add(plant);


        return ls;
    }


    public void flower(MouseEvent mouseEvent) {
        //plantlayout.setVisible(!plantlayout.isVisible());

        if (plantlayout.isVisible()) {
            // Load and display the plant cards
            List<Plant> flowerPlants = recentlyAdded();

            try {
                plantlayout.getChildren().clear(); // Clear existing plant cards

                for (Plant plant : flowerPlants) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/com/example/forestvibe/plantCard.fxml"));
                    VBox plantcard = fxmlLoader.load();
                    PlantCard plantcontroller = fxmlLoader.getController();
                    plantcontroller.setData(plant);
                    plantlayout.getChildren().add(plantcard);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public void medicine(MouseEvent mouseEvent) {
        //plantlayout.setVisible(!plantlayout.isVisible());

        if (plantlayout.isVisible()) {
            // Load and display the plant cards
            List<Plant> flowerPlants = recentlyAdded3();

            try {
                plantlayout.getChildren().clear(); // Clear existing plant cards

                for (Plant plant : flowerPlants) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/com/example/forestvibe/plantCard.fxml"));
                    VBox plantcard = fxmlLoader.load();
                    PlantCard plantcontroller = fxmlLoader.getController();
                    plantcontroller.setData(plant);
                    plantlayout.getChildren().add(plantcard);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public void vegitables(MouseEvent mouseEvent) {
        //plantlayout.setVisible(!plantlayout.isVisible());

        if (plantlayout.isVisible()) {
            // Load and display the plant cards
            List<Plant> flowerPlants = recentlyAdded4();

            try {
                plantlayout.getChildren().clear(); // Clear existing plant cards

                for (Plant plant : flowerPlants) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/com/example/forestvibe/plantCard.fxml"));
                    VBox plantcard = fxmlLoader.load();
                    PlantCard plantcontroller = fxmlLoader.getController();
                    plantcontroller.setData(plant);
                    plantlayout.getChildren().add(plantcard);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void fruit(MouseEvent mouseEvent) {
        //plantlayout.setVisible(!plantlayout.isVisible());

        if (plantlayout.isVisible()) {
            // Load and display the plant cards
            List<Plant> flowerPlants = recentlyAdded2();

            try {
                plantlayout.getChildren().clear(); // Clear existing plant cards

                for (Plant plant : flowerPlants) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/com/example/forestvibe/plantCard.fxml"));
                    VBox plantcard = fxmlLoader.load();
                    PlantCard plantcontroller = fxmlLoader.getController();
                    plantcontroller.setData(plant);
                    plantlayout.getChildren().add(plantcard);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void search(){
        Database connection = new Database();
        Connection con = connection.getConnection();

        String name = search.getText();

        try{
            String searchQuery = "SELECT * FROM plants WHERE name = ?";
            PreparedStatement preparedStatement = con.prepareStatement(searchQuery);

            String searchQuery2 = "SELECT * FROM "+name;


            System.out.println(searchQuery2);
            preparedStatement.setString(1,name);

            PreparedStatement preparedStatement2 = con.prepareStatement(searchQuery2);


            ResultSet query = preparedStatement.executeQuery();
            ResultSet query2 = preparedStatement2.executeQuery();  // Corrected line

            List<PlantDetails> detailsList = new ArrayList<>();
            ObservableList<PlantDetails> observableList;

            while (query.next()) {
                if (name.equals(query.getString(1))) {
                    fruitname.setText(query.getString(1));
                    Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(query.getString(2))));
                    chplantname.setImage(image);
                    chplantdesc.setText(query.getString(3));
                }
            }

            while (query2.next()) {
                String property = query2.getString(1);
                String details = query2.getString(2);

                detailsList.add(new PlantDetails(property, details));
                observableList = FXCollections.observableArrayList(detailsList);
                table.setItems(observableList);
                table.refresh();
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
