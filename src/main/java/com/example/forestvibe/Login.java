package com.example.forestvibe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class Login {
   private Stage stage;
   private Scene scene;
   @FXML
   private Button login1;
   @FXML
   private Label massage;
   @FXML
   private TextField username;
   @FXML
   private TextField password;
   public void login(javafx.event.ActionEvent event) throws IOException {

      Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Firstpage.fxml")));
      stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.setMinHeight(750);
      stage.setMinWidth(1250);
      stage.setResizable(false);
      stage.centerOnScreen();

      stage.show();
   }

   public void adminlogin(){
      if ((!username.getText().isBlank()) && (!password.getText().isBlank())) {
         Database connection = new Database();
         Connection con = connection.getConnection();

         try {
            String verifyLoginQuery = "SELECT * FROM admin WHERE Username = ? AND Password = ?";
            PreparedStatement preparedStatement = con.prepareStatement(verifyLoginQuery);

            // Set parameters for the prepared statement
            preparedStatement.setString(1, username.getText());
            preparedStatement.setString(2, password.getText());

            // Execute the query
            ResultSet query = preparedStatement.executeQuery();

            if (query.next()) {
               String password = query.getString(2);
               if (password.equals("@Hackdoze1")) {
                  switchToScene5();
               } else {
                  massage.setText("Invalid");
               }
            }
         } catch (SQLException | IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
         }
      }
   }
   public void switchToScene5() throws IOException{
      Parent root = FXMLLoader.load(getClass().getResource("plantsadmin.fxml"));
      stage = new Stage();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
   }





}
