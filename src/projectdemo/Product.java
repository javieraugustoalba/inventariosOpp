/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectdemo;

import java.util.Date;

public class Product {
    private int productID;
    private String name;
    private String description;
    private String barcode;
    private double price;
    private int stockQuantity;
    private int minQuantity;
    private int maxQuantity;
    private Date entryDate;
    private int categoryID;
    private int supplierID;

    // Constructors
    public Product() {
    }

    public Product(String name, String description, String barcode, double price, int stockQuantity,int minQuantity, int maxQuantity, Date entryDate, int categoryID, int supplierID) {
        this.name = name;
        this.description = description;
        this.barcode = barcode;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
        this.entryDate = entryDate;
        this.categoryID = categoryID;
        this.supplierID = supplierID;
    }
    
    // Product update will use this constructor what takes an extra argument the product id.
    public Product(int productId, String name, String description, String barcode, double price, int stockQuantity,int minQuantity, int maxQuantity, Date entryDate, int categoryID, int supplierID) {
        this.productID = productId;
        this.name = name;
        this.description = description;
        this.barcode = barcode;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
        this.entryDate = entryDate;
        this.categoryID = categoryID;
        this.supplierID = supplierID;
    }

    // Getters and setters
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }
}
