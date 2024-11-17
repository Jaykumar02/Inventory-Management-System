package com.techlabs.exceptions;

public class DuplicateProductNameException extends RuntimeException {
   public String getMessage() {
      return "Duplicate Product ! Product already exists";
   }
}