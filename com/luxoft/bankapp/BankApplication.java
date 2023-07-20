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

        // CheckingAccount Test exception handling
        CheckingAccount checkingAccount = new CheckingAccount(1, 1000, 200);
        bank.addAccount(checkingAccount);
        double amount_to_withdraw_from_checkingAccount = 100000;

        try {
            checkingAccount.withdraw(amount_to_withdraw_from_checkingAccount);
        } 
        catch (OverdraftLimitExceededException e) {
            System.out.println("Not enough funds for account " + checkingAccount.id + ". Current balance: " + checkingAccount.initialBalance
            + ", requested amount: " + amount_to_withdraw_from_checkingAccount +
             " maximum withdrawel amount: " + (checkingAccount.initialBalance+e.getOverdraft()));
        }
        catch (NotEnoughFundsException e) {
            e.printStackTrace();
        }

         // SavingAccount Test exception handling
        SavingAccount savingAccount = new SavingAccount(2, 25000, 1000);
        bank.addAccount(savingAccount);
        double amount_to_withdraw_from_saving_account = 50000;

        try {
            checkingAccount.withdraw(amount_to_withdraw_from_saving_account);
        } 
        catch (OverdraftLimitExceededException e) {
            System.out.println("Not enough funds for account " + checkingAccount.id + ". Current balance: " + checkingAccount.initialBalance
            + ", requested amount: " + amount_to_withdraw_from_saving_account +
             " maximum withdrawel amount: " + (checkingAccount.initialBalance+e.getOverdraft()));
        }
        catch (NotEnoughFundsException e) {
            e.printStackTrace();
        }
    }
}


