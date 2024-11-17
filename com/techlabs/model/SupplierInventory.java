package com.techlabs.model;

import com.techlabs.exceptions.DuplicateSupplierName;
import com.techlabs.exceptions.InvalidIDException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SupplierInventory {
   private Supplier supplier;
   private List<Supplier> suppliers = new ArrayList();
//   private SaveDetails details = new SaveDetails();

   public void addSupplier(Supplier supplier) {
      Iterator var3 = this.suppliers.iterator();

      while(var3.hasNext()) {
         Supplier supplierCheck = (Supplier)var3.next();
         if (supplierCheck.getSupplierName().equalsIgnoreCase(supplier.getSupplierName())) {
            throw new DuplicateSupplierName();
         }
      }

      this.suppliers.add(supplier);
   }

   public void ViewSupplierDetail(Supplier supplier) {
      System.out.println(supplier);
   }

   public void viewAllSupplier() {
      Iterator var2 = this.suppliers.iterator();

      while(var2.hasNext()) {
         Supplier supplierList = (Supplier)var2.next();
         System.out.println(supplierList);
      }

   }

   public void updateSupplier(int supplierID, String supplierName, String supplierInfo) {
      Iterator var5 = this.suppliers.iterator();

      while(var5.hasNext()) {
         Supplier supplierList = (Supplier)var5.next();
         if (supplierList.getSupplierID() != supplierID) {
            throw new InvalidIDException();
         }

         if (!supplierName.trim().isEmpty()) {
            supplierList.setSupplierName(supplierName);
         }

         if (!supplierInfo.trim().isEmpty()) {
            supplierList.setSupplierContactInfo(supplierInfo);
         }
      }

   }

   public void deleteSupplier(int supplierID) {
      Iterator<Supplier> iterator = this.suppliers.iterator();
      if (iterator.hasNext()) {
         Supplier supplierList = (Supplier)iterator.next();
         if (supplierList.getSupplierID() != supplierID) {
            throw new InvalidIDException();
         }

         iterator.remove();
         System.out.println("Supplier with ID " + supplierID + " has been removed.");
      }

   }

   public void saveDetails() {
//      this.details.saveSuppliers(this.suppliers);
   }
}
