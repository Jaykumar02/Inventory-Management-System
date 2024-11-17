package com.techlabs.model;

public class Transaction {
   private int transactionID;
   private String transactionType;
   private String transactionDate;
   private int quantity;

   public Transaction(int transactionID, String transactionType, String transactionDate, int quantity) {
      this.transactionID = transactionID;
      this.transactionType = transactionType;
      this.transactionDate = transactionDate;
      this.quantity = quantity;
   }

   public int getTransactionID() {
      return this.transactionID;
   }

   public void setTransactionID(int transactionID) {
      this.transactionID = transactionID;
   }

   public String getTransactionType() {
      return this.transactionType;
   }

   public void setTransactionType(String transactionType) {
      this.transactionType = transactionType;
   }

   public String getTransactionDate() {
      return this.transactionDate;
   }

   public void setTransactionDate(String transactionDate) {
      this.transactionDate = transactionDate;
   }

   public int getQuantity() {
      return this.quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public String toString() {
      return "Transaction [transactionID=" + this.transactionID + ", transactionType=" + this.transactionType + ", transactionDate=" + this.transactionDate + ", quantity=" + this.quantity + "]";
   }
}
