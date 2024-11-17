package com.techlabs.model;

import com.techlabs.exceptions.DuplicateProductNameException;
import com.techlabs.exceptions.InvalidIDException;
import java.util.Random;
import java.util.Scanner;

public class ProductManagement {
   Scanner scanner;
   Random random;
   private Product product;
   private ProductInventory inventory;

   public ProductManagement(ProductInventory inventory) {
      this.scanner = new Scanner(System.in);
      this.random = new Random();
      this.inventory = inventory;
   }

   public void addProduct() {
      System.out.println("Enter Name: ");
      String name = this.scanner.nextLine();
      System.out.println("Enter Description: ");
      String description = this.scanner.nextLine();
      System.out.println("Enter Price: ");
      double price = this.scanner.nextDouble();
      System.out.println("Enter Quantity: ");
      int quantity = this.scanner.nextInt();
      int productID = this.random.nextInt(10000) + 1;
      this.scanner.nextLine();
      this.product = new Product(productID, name, description, quantity, price);

      try {
         this.inventory.addProduct(this.product);
      } catch (DuplicateProductNameException var8) {
         System.out.println(var8.getMessage());
      }

   }

   public void updateProductDetails(int productID) {
      try {
         this.inventory.updateProduct(productID);
      } catch (InvalidIDException var3) {
         System.out.println(var3.getMessage());
      }

   }

   public void deleteProduct(int productID) {
      try {
         this.inventory.removeProduct(productID);
      } catch (InvalidIDException var3) {
         System.out.println(var3.getMessage());
      }

   }

   public void viewProduct() {
      this.inventory.viewProduct(this.product);
   }

   public void viewAllProduct() {
      this.inventory.viewAllProduct();
   }
}
