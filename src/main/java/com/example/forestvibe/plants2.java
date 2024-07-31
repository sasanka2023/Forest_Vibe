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
import java.sql.*;
import java.util.*;

public class plants2 extends HelloApplication implements Initializable {


    public TextField name;
    public TextField bname;
    public TextField habitat;
    public TextField properties;
    public TextField value;
    public TextField img;
    public TextField bio;
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

        c1.setCellValueFactory(new PropertyValueFactory<>("propertyname"));
        c2.setCellValueFactory(new PropertyValueFactory<>("propertydetails"));
        c1.setText("Property");
        c2.setText("Value");



    }




    public void Create(){ //create a plant table
        Database connection = new Database();
        Connection con = connection.getConnection();



        String tablename = name.getText();
        String botname = bname.getText();
        String hab = habitat.getText();

        String Biodivarsity = bio.getText();
        String imagesrc = img.getText();
        String prop = properties.getText();
        String val = value.getText();
        Map<String,String> map = new HashMap<>();
        map.put("Name",tablename);
        map.put("Botanical Name",botname);
        map.put("habitat",hab);
        map.put("Biodiversity",Biodivarsity);
        map.put(prop,val);


        int flag = 0;
        try {
            Statement s = con.createStatement();
            //create a table for the selected plant
            String createquery = "CREATE TABLE "+tablename+" (property Varchar(100),details longtext)";
            s.execute(createquery);
            //query to insert the plant details int o selected plant table
            String AddValuequery = "Insert into "+tablename+" values(?,?)";
            String plantquery = "INSERT INTO plants VALUES (?, ?, ?)";


            PreparedStatement preparedStatement2 = con.prepareStatement(plantquery);
            preparedStatement2.setString(1, tablename);
            preparedStatement2.setString(2, imagesrc);
            preparedStatement2.setString(3, val);

            preparedStatement2.executeUpdate();


            PreparedStatement preparedStatement1 = con.prepareStatement(AddValuequery);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                preparedStatement1.setString(1,entry.getKey());
                preparedStatement1.setString(2,entry.getValue());
                flag = preparedStatement1.executeUpdate();

            }
            if(flag>0){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("data inserted successfully");
                alert.showAndWait();
            }




        con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public void Delete(){
            Database connection = new Database();
            Connection con = connection.getConnection();

            String tablename = name.getText();

            String delquery = "Drop table "+tablename;
            String delquery2 = "Delete from plants where name = ?";

            try{
                Statement s2 = con.createStatement();

                s2.executeUpdate(delquery);

                PreparedStatement preparedStatement1 = con.prepareStatement(delquery2);
                preparedStatement1.setString(1,tablename);
                preparedStatement1.executeUpdate();

                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    public void update(){
        
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

        con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
