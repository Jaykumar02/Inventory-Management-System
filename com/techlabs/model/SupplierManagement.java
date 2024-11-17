package com.techlabs.model;

import com.techlabs.exceptions.DuplicateSupplierName;
import com.techlabs.exceptions.InvalidIDException;
import java.util.Random;
import java.util.Scanner;

public class SupplierManagement {
   Scanner scanner;
   Random random;
   private Supplier supplier;
   private SupplierInventory supplierIvnentory;

   public SupplierManagement(SupplierInventory supplierInventory) {
      this.scanner = new Scanner(System.in);
      this.random = new Random();
      this.supplierIvnentory = supplierInventory;
   }

   public void addSupplier() {
      System.out.println("Enter Supplier Name: ");
      String supplierName = this.scanner.nextLine();
      System.out.println("Enter Supplier Contact Info:");
      String supplierInfo = this.scanner.nextLine();
      int supplierID = this.random.nextInt(1000) + 1;
      System.out.println("Supplier ID is : " + supplierID);
      this.supplier = new Supplier(supplierID, supplierName, supplierInfo);

      try {
         this.supplierIvnentory.addSupplier(this.supplier);
      } catch (DuplicateSupplierName var5) {
         System.out.println(var5.getMessage());
      }

   }

   public void viewSupplierDetail() {
      System.out.println("| Supplier  ID    | Supplier Name       | Supplier ContactInfo            |");
      System.out.println("****************************************************************************");
      this.supplierIvnentory.ViewSupplierDetail(this.supplier);
   }

   public void ViewAllSupplier() {
      System.out.println("| Supplier  ID | Supplier Name      | Supplier ContactInfo            |");
      System.out.println("****************************************************************************");
      this.supplierIvnentory.viewAllSupplier();
   }

   public void updateSupplier() {
      System.out.println("Enter Supplier ID you want to update: ");
      int suppID = this.scanner.nextInt();
      this.scanner.nextLine();
      System.out.println("Enter New Supplier Name or Press ENTER to keep same");
      String suppName = this.scanner.nextLine();
      System.out.println("Enter New Supplier Info or Press ENTER to keep same");
      String suppInfo = this.scanner.nextLine();

      try {
         this.supplierIvnentory.updateSupplier(suppID, suppName, suppInfo);
      } catch (InvalidIDException var5) {
         System.out.println(var5.getMessage());
      }

   }

   public void deleteSupplier() {
      System.out.println("Enter Supplier ID you want to Delete");
      int supplierID = this.scanner.nextInt();

      try {
         this.supplierIvnentory.deleteSupplier(supplierID);
      } catch (InvalidIDException var3) {
         System.out.println(var3.getMessage());
      }

   }
}