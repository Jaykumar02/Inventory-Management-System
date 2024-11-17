package com.techlabs.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransactionInventory {
   private Transaction transaction;
   private List<Transaction> transactions = new ArrayList();
//   private SaveDetails details = new SaveDetails();

   public void addStock(Transaction transaction) {
      this.transactions.add(transaction);
   }

   public void viewHistory() {
      Iterator var2 = this.transactions.iterator();

      while(var2.hasNext()) {
         Transaction transaction = (Transaction)var2.next();
         System.out.println(transaction);
      }

   }

   public void saveDetails() {
//      this.details.saveTransactions(this.transactions);
   }
}
