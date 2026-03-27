package com.denisa.smart_expense_tracker.exception;

public class DuplicateResourcesException extends RuntimeException{
    public DuplicateResourcesException(String message){
        super(message);
    }
}
