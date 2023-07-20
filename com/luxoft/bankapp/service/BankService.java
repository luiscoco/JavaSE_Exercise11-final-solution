package com.luxoft.bankapp.service;

import com.luxoft.bankapp.domain.Bank;
import com.luxoft.bankapp.domain.Account;
import com.luxoft.bankapp.exceptions.ClientExistsException;

public class BankService {
    public static void addAccount(Bank bank, Account account) throws ClientExistsException {
        if (bank.getClients().stream().anyMatch(c -> c.getName().equals("New Client"))) {
            throw new ClientExistsException("Client with the given name already exists");
        }
        bank.addAccount(account);
    }
}

