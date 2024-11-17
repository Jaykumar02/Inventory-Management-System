package com.techlabs.model;

import com.techlabs.exceptions.DuplicateProductNameException;
import com.techlabs.exceptions.InvalidIDException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ProductInventory {
   Scanner scanner;
   private List<Product> products;
//   private SaveDetails details;

   public ProductInventory() {
      this.scanner = new Scanner(System.in);
      this.products = new ArrayList();
//      this.details = new SaveDetails();
   }

   public void addProduct(Product product) {
      Iterator var3 = this.products.iterator();

      while(var3.hasNext()) {
         Product productCheck = (Product)var3.next();
         if (productCheck.getProductName().equalsIgnoreCase(product.getProductName())) {
            throw new DuplicateProductNameException();
         }
      }

      this.products.add(product);
   }

   public void updateProduct(int productID) {
      Iterator var3 = this.products.iterator();

      while(var3.hasNext()) {
         Product product = (Product)var3.next();
         if (product.getProductID() != productID) {
            throw new InvalidIDException();
         }

         this.scanner.nextLine();
         System.out.println("Enter new Name: ");
         String newName = this.scanner.nextLine();
         if (!newName.trim().isEmpty()) {
            product.setProductName(newName);
         }

         System.out.println("Enter new Description: ");
         String newDescription = this.scanner.nextLine();
         if (!newDescription.trim().isEmpty()) {
            product.setProductDescription(newDescription);
         }

         System.out.println("Enter new Price Or press Zero(0) to keep same price: ");
         double newPrice = this.scanner.nextDouble();
         if (newPrice != 0.0D) {
            product.setProductPrice(newPrice);
         }

         System.out.println("Enter new Quantity Or press Zero(0) to keep same Quantity: ");
         int newQuantity = this.scanner.nextInt();
         if (newQuantity != 0) {
            product.setProductQuantity(newQuantity);
         }
      }

   }

   public void removeProduct(int productID1) {
      Iterator<Product> iterator = this.products.iterator();
      if (iterator.hasNext()) {
         Product rmProduct = (Product)iterator.next();
         if (rmProduct.getProductID() == productID1) {
            iterator.remove();
            System.out.println("Product with ID " + productID1 + " removed successfully.");
         } else {
            throw new InvalidIDException();
         }
      } else {
         System.out.println("Product with ID " + productID1 + " not found.");
      }
   }

   public void viewProduct(Product product) {
      System.out.println("| Product ID    | Product Name       | Product Description            | Product Quantity | Product Price |");
      System.out.println("**********************************************************************************************************");
      System.out.println(product);
   }

   public void viewAllProduct() {
      System.out.println("| Product ID    | Product Name       | Product Description            | Product Quantity | Product Price |");
      System.out.println("**********************************************************************************************************");
      Iterator var2 = this.products.iterator();

      while(var2.hasNext()) {
         Product productList = (Product)var2.next();
         System.out.println(productList);
      }

   }

   public Product findProductByID(int productID) {
      Iterator var3 = this.products.iterator();
      if (var3.hasNext()) {
         Product product = (Product)var3.next();
         if (product.getProductID() == productID) {
            return product;
         } else {
            throw new InvalidIDException();
         }
      } else {
         return null;
      }
   }

   public void saveDetails() {
//      this.details.saveProduts(this.products);
   }
}
