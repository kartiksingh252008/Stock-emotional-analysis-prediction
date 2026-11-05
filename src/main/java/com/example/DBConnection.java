package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
 try {
     String url = "JDBC:mysql://localhost:3306/stock_prediction";
     String user = "root";
     String pass = "kartik@0989";
     Connection con = DriverManager.getConnection(url, user, pass);
     System.out.println("Success");
     return con ;
 } catch (SQLException e) {
     System.out.println("error connecting to the database");
     return null ;
 }
    }
}
