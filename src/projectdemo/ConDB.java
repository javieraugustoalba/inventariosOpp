/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectdemo;

/**
 *
 * @author balme
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConDB {
    
    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/shema1";
    private static final String USER = "root";
    private static final String PASSWORD = "Phoenix01";

    // Method to establish a database connection
    public static Connection getConnection() {
        try 
        {
            // Register the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Create a connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database: " + e.getMessage());
        }
    }        
}
