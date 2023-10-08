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
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

public class UserData {

    public static void insertUser(User user) {
        Connection connection = ConDB.getConnection();

        if (connection != null) {
            System.out.println("Connected to the database - user insertion!");

            try {
                String storedProcedureCall = "{call InsertUser(?,?)}";
                try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                    callableStatement.setString(1, user.getUsername());
                    callableStatement.setString(2, user.getPassword());
                    callableStatement.execute();
                }
                connection.close();
                System.out.println("Connection closed - user insertion.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }

    public static boolean authenticateUser(String username, String password) {
        Connection connection = ConDB.getConnection();

        if (connection != null) {
            try {
                String storedProcedureCall = "{call AuthenticateUser(?,?,?)}";
                try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                    callableStatement.setString(1, username);
                    callableStatement.setString(2, password);
                    callableStatement.registerOutParameter(3, Types.BOOLEAN);
                    System.out.println(username);
                    System.out.println(password);
                    callableStatement.execute();
                    
                    boolean isAuthenticated = callableStatement.getBoolean(3);
                    System.out.println(isAuthenticated);
                    return isAuthenticated;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Failed to connect to the database.");
        }
        return false;
    }
}
