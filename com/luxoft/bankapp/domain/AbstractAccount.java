package com.luxoft.bankapp.domain;

import com.luxoft.bankapp.exceptions.NotEnoughFundsException;
import com.luxoft.bankapp.exceptions.OverdraftLimitExceededException;

public abstract class AbstractAccount implements Account {
    protected int id;
    protected double balance;
    protected double overdraft;

    public AbstractAccount(int id, double initialBalance, double overdraft) {
        this.id = id;
        this.balance = initialBalance;
        this.overdraft = overdraft;
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
            double maximum_withdrawel_amount = maximumAmountToWithdraw();
            throw new NotEnoughFundsException(id, balance, amount, maximum_withdrawel_amount);
        }

        if (amount <= balance + overdraft) {
            balance -= amount;
            
        } else {
            System.out.println("Insufficient funds!");
            throw new OverdraftLimitExceededException(id, balance, amount, overdraft);
        }

        balance -= amount;
    }
}
