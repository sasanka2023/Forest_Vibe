package com.example.forestvibe;


import java.sql.*;

public class Database extends Firstpage{



    public  Connection databaseLink;
    public  Connection getConnection(){
        String databasename = "user_info";
        String databaseUser = "root";
        String databasePassword = "";
        String Url = "jdbc:mysql://localhost:3306/"+databasename;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(Url,databaseUser,databasePassword);

            /*ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
            System.out.println("Connected to database");*/

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return databaseLink;

    }

}
