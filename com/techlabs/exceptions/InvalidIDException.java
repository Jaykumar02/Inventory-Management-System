    package com.techlabs.exceptions;

public class InvalidIDException extends RuntimeException {
   public String getMessage() {
      return " Invalid ID ! ID not found";
   }
}