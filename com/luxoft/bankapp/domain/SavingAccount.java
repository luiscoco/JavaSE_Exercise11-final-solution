package com.luxoft.bankapp.domain;

public class SavingAccount extends AbstractAccount {
    public SavingAccount(int id, double initialBalance) {
        super(id, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    @Override
    public double maximumAmountToWithdraw() {
        return balance;
    }
}
