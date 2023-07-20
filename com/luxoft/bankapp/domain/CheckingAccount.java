package com.luxoft.bankapp.domain;

import com.luxoft.bankapp.exceptions.NotEnoughFundsException;
import com.luxoft.bankapp.exceptions.OverdraftLimitExceededException;

public class CheckingAccount extends AbstractAccount {
    public double overdraft;
    public int id;
    public double initialBalance;

    public CheckingAccount(int id, double initialBalance, double overdraft) {
        super(id, initialBalance);
        if (overdraft < 0) {
            throw new IllegalArgumentException("Invalid overdraft value: " + overdraft);
        }
        this.overdraft = overdraft;
        this.id = id;
        this.initialBalance = initialBalance;
    }

    @Override
    public void withdraw(double amount) throws NotEnoughFundsException {
        if (amount <= balance + overdraft) {
            balance -= amount;
            
        } else {
            System.out.println("Insufficient funds!");
            throw new OverdraftLimitExceededException(id, balance, amount, overdraft);
        }
    }

    @Override
    public double maximumAmountToWithdraw() {
        throw new UnsupportedOperationException("Unimplemented method 'maximumAmountToWithdraw'");
    }
}
