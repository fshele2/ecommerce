package com.Nestful.ecommerce.exceptions;

public class OrderDoesNotExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public OrderDoesNotExistException() {
        super("You are trying to find an order that does not exist.");
    }

    public OrderDoesNotExistException(String message) {
        super(message);
    }
}