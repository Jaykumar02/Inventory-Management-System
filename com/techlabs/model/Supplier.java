package com.techlabs.model;

public class Supplier {
   private int supplierID;
   private String supplierName;
   private String supplierContactInfo;

   public Supplier(int supplierID, String supplierName, String supplierContactInfo) {
      this.supplierID = supplierID;
      this.supplierName = supplierName;
      this.supplierContactInfo = supplierContactInfo;
   }

   public int getSupplierID() {
      return this.supplierID;
   }

   public void setSupplierID(int supplierID) {
      this.supplierID = supplierID;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public void setSupplierName(String supplierName) {
      this.supplierName = supplierName;
   }

   public String getSupplierContactInfo() {
      return this.supplierContactInfo;
   }

   public void setSupplierContactInfo(String supplierContactInfo) {
      this.supplierContactInfo = supplierContactInfo;
   }

   public String toString() {
      return String.format("| %-10d | %-20s | %-30s |", this.supplierID, this.supplierName, this.supplierContactInfo);
   }
}
