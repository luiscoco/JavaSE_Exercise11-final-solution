package com.luxoft.bankapp;

import com.luxoft.bankapp.domain.*;
import com.luxoft.bankapp.exceptions.*;

public class BankApplication {
    public static void main(String[] args) throws ClientExistsException {
        Bank bank = new Bank();

        Client client1 = new Client("John Doe");
        bank.addClient(client1);

        Client client2 = new Client("Jane Smith");
        bank.addClient(client2);

        System.out.println("Printed clients: " + bank.getPrintedClients());
        System.out.println("Emailed clients: " + bank.getEmailedClients());
        System.out.println("Debugged clients: " + bank.getDebuggedClients());

        // Test exception handling
        Account checkingAccount = new CheckingAccount(1, 1000, 200);
        bank.addAccount(checkingAccount);

        try {
            checkingAccount.withdraw(100000);
        } 
        catch (OverdraftLimitExceededException e) {
            e.printStackTrace();
            e.getOverdraft();
        }
    }
}


