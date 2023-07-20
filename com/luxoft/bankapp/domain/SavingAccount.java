package com.luxoft.bankapp.domain;

import com.luxoft.bankapp.exceptions.NotEnoughFundsException;
import com.luxoft.bankapp.exceptions.OverdraftLimitExceededException;

public class SavingAccount extends AbstractAccount {
    public SavingAccount(int id, double initialBalance) {
        super(id, initialBalance);
    }

    @Override
    public void withdraw(double amount) throws NotEnoughFundsException {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
            throw new OverdraftLimitExceededException(id, balance, amount, overdraft);
        }
    }

    @Override
    public double maximumAmountToWithdraw() {
        return balance;
    }
}
