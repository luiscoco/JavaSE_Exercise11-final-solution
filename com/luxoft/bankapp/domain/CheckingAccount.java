package com.luxoft.bankapp.domain;

import com.luxoft.bankapp.exceptions.NotEnoughFundsException;
import com.luxoft.bankapp.exceptions.OverdraftLimitExceededException;

public class CheckingAccount extends AbstractAccount {
    private double overdraft;

    public CheckingAccount(int id, double initialBalance, double overdraft) {
        super(id, initialBalance);
        if (overdraft < 0) {
            throw new IllegalArgumentException("Invalid overdraft value: " + overdraft);
        }
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount) throws OverdraftLimitExceededException {
        if (amount <= balance + overdraft) {
            balance -= amount;
        } else {
            throw new OverdraftLimitExceededException(id, balance, amount, overdraft);
        }
    }
}
