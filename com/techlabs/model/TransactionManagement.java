package com.techlabs.model;

import com.techlabs.exceptions.InsufficientStockException;
import com.techlabs.exceptions.InvalidIDException;
import java.util.Random;
import java.util.Scanner;

public class TransactionManagement {
   Scanner scanner;
   Random random;
   private TransactionInventory transactionInventory;
   private ProductInventory productInventory;
   private Product product;
   private Transaction transaction;
   int productID;
   int stock;
   String transactionDate;
   int transactionID;
   String transactiontype;
   int quantity;

   public TransactionManagement(TransactionInventory TInventory, ProductInventory productInventory) {
      this.scanner = new Scanner(System.in);
      this.random = new Random();
      this.transactionInventory = TInventory;
      this.productInventory = productInventory;
   }

   public void displayProducts() {
      this.productInventory.viewAllProduct();
   }

   public void takeInputs() {
      System.out.println("Enter Product ID : ");
      this.productID = this.scanner.nextInt();

      try {
         this.product = this.productInventory.findProductByID(this.productID);
      } catch (InvalidIDException var2) {
         System.out.println(var2.getMessage());
      }

      if (this.product == null) {
         System.out.println("Product not found!");
      } else {
         System.out.println("Enter the Number Of Stock : ");
         this.stock = this.scanner.nextInt();
         this.scanner.nextLine();
         System.out.println("Enter Transaction Date ");
         this.transactionDate = this.scanner.nextLine();
         this.transactionID = this.random.nextInt(1000) + 1;
         System.out.println("Your Transaction ID is: " + this.transactionID);
      }
   }

   public void addStock() {
      this.transactiontype = "Added Stock";

      try {
         this.quantity = this.product.getProductQuantity() + this.stock;
         this.product.setProductQuantity(this.quantity);
         this.transaction = new Transaction(this.transactionID, this.transactiontype, this.transactionDate, this.stock);
         this.transactionInventory.addStock(this.transaction);
         System.out.println("Transaction Complete ");
      } catch (Exception var2) {
         System.out.println(var2);
      }

   }

   public void removeStock() {
      if (this.product.getProductQuantity() < this.stock) {
         throw new InsufficientStockException(this.stock);
      } else {
         this.quantity = this.product.getProductQuantity() - this.stock;
         this.product.setProductQuantity(this.quantity);
         this.transactiontype = "Removed Stock";
         System.out.println("Transaction Complete ");
         this.transaction = new Transaction(this.transactionID, this.transactiontype, this.transactionDate, this.stock);
         this.transactionInventory.addStock(this.transaction);
      }
   }

   public void viewTransactionHistory() {
      this.transactionInventory.viewHistory();
   }
}
