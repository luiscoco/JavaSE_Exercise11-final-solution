package com.luxoft.bankapp.exceptions;

public class ClientExistsException extends BankException {
    public ClientExistsException(String message) {
        super(message);
    }
}
