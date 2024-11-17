package com.techlabs.model;

public class Product {
   private int productID;
   private String productName;
   private String productDescription;
   private int productQuantity;
   private double productPrice;

   public Product(int productID, String productName, String productDescription, int productQuantity, double productPrice) {
      this.productID = productID;
      this.productName = productName;
      this.productDescription = productDescription;
      this.productQuantity = productQuantity;
      this.productPrice = productPrice;
   }

   public int getProductID() {
      return this.productID;
   }

   public void setProductID(int productID) {
      this.productID = productID;
   }

   public String getProductName() {
      return this.productName;
   }

   public void setProductName(String productName) {
      this.productName = productName;
   }

   public String getProductDescription() {
      return this.productDescription;
   }

   public void setProductDescription(String productDescription) {
      this.productDescription = productDescription;
   }

   public int getProductQuantity() {
      return this.productQuantity;
   }

   public void setProductQuantity(int productQuantity) {
      this.productQuantity = productQuantity;
   }

   public double getProductPrice() {
      return this.productPrice;
   }

   public void setProductPrice(double productPrice) {
      this.productPrice = productPrice;
   }

   public String toString() {
      return String.format("| %-15s | %-20s | %-30s | %-15s | %-10.2f |", this.productID, this.productName, this.productDescription, this.productQuantity, this.productPrice);
   }
}
