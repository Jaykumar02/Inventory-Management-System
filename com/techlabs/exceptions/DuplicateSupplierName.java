package com.techlabs.exceptions;

public class DuplicateSupplierName extends RuntimeException {
	   public String getMessage() {
	      return "Duplicate Supplier ! Supplier  already Exists";
	   }
	}
