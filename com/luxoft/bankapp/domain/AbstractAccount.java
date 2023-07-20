package com.luxoft.bankapp.domain;

import com.luxoft.bankapp.exceptions.NotEnoughFundsException;

public abstract class AbstractAccount implements Account {
    protected int id;
    protected double balance;

    public AbstractAccount(int id, double initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid deposit amount: " + amount);
        }
        balance += amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void withdraw(double amount) throws NotEnoughFundsException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid withdrawal amount: " + amount);
        }

        if (amount > maximumAmountToWithdraw()) {
            throw new NotEnoughFundsException(id, balance, amount);
        }

        balance -= amount;
    }
}
