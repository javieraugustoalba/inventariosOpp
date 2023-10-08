/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectdemo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.Date;


public class ProductData {

    public static void insertProduct(Product product) {
        // Get a database connection
        Connection connectionInsert = ConDB.getConnection();
        if (connectionInsert != null) {
            System.out.println("Connected to the database - insert!");
            
            try{
                String storedProcedureCall = "{call InsertProduct(?,?,?,?,?,?,?,?,?,?)}";
                // Set the parameters for the insert statement
                try (CallableStatement callableStatement = connectionInsert.prepareCall(storedProcedureCall)) {
                    // Set the parameters for the insert statement
                    callableStatement.setString(1, product.getName());
                    callableStatement.setString(2, product.getDescription());
                    callableStatement.setString(3, product.getBarcode());
                    callableStatement.setDouble(4, product.getPrice());
                    callableStatement.setInt(5, product.getStockQuantity());
                    callableStatement.setInt(6, product.getMinQuantity());
                    callableStatement.setInt(7, product.getMaxQuantity());
                    callableStatement.setTimestamp(8, new java.sql.Timestamp(System.currentTimeMillis())); // EntryDate as current timestamp
                    callableStatement.setInt(9, product.getCategoryID());
                    callableStatement.setInt(10, product.getSupplierID());
                    // Execute the stored procedure
                    callableStatement.execute();
                    // Don't forget to close the connection when you're done
                }
                connectionInsert.close();
                System.out.println("Connection closed - insert.");
            } catch (SQLException e) {
                e.printStackTrace();
            }           
        }else{
            System.out.println("Failed to connect to the database.");
        }
    }
    
    // Find Product by ID.
    public static Product findProductById(int productID) {
        Connection connection = ConDB.getConnection();
        Product product = null;

        if (connection != null) {
            try {
                String storedProcedureCall = "{call FindProduct(?)}";
                try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                    callableStatement.setInt(1, productID);
                    callableStatement.execute();

                    // Assuming you have a constructor in the Product class that accepts ResultSet
                    try (ResultSet resultSet = callableStatement.getResultSet()) {
                        if (resultSet.next()) {
                            // Create a new Product object using the ResultSet data
                            product = new Product(
                                resultSet.getString("Name"),
                                resultSet.getString("Description"),
                                resultSet.getString("Barcode"),
                                resultSet.getDouble("Price"),
                                resultSet.getInt("StockQuantity"),
                                resultSet.getInt("MinQuantity"),
                                resultSet.getInt("MaxQuantity"),
                                resultSet.getTimestamp("EntryDate"),
                                resultSet.getInt("CategoryID"),
                                resultSet.getInt("SupplierID")
                            );
                        }
                    }
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

        return product;
    }
    
    // Update product, it will use the find by id
    public static void updateProduct(Product product) {
        Connection connection = ConDB.getConnection();

        if (connection != null) {
            try {
                String storedProcedureCall = "{call UpdateProduct(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
                try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                    callableStatement.setInt(1, product.getProductID());
                    callableStatement.setString(2, product.getName());
                    callableStatement.setString(3, product.getDescription());
                    callableStatement.setString(4, product.getBarcode());
                    callableStatement.setDouble(5, product.getPrice());
                    callableStatement.setInt(6, product.getStockQuantity());
                    callableStatement.setInt(7, product.getMinQuantity());
                    callableStatement.setInt(8, product.getMaxQuantity());
                    callableStatement.setTimestamp(9, new java.sql.Timestamp(product.getEntryDate().getTime())); // EntryDate as timestamp
                    callableStatement.setInt(10, product.getCategoryID());
                    callableStatement.setInt(11, product.getSupplierID());

                    callableStatement.execute();
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
    }    
    
    
    // Delete method
    public static void deleteProductById(int productId) {
        Connection connection = ConDB.getConnection();

        if (connection != null) {
            try {
                String storedProcedureCall = "{call DeleteProductById(?)}";
                try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                    callableStatement.setInt(1, productId);
                    callableStatement.execute();
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
    }    
    
}
