package com.luxoft.bankapp.domain;

public class CheckingAccount extends AbstractAccount {
    public double overdraft;
    public int id;
    public double initialBalance;

    public CheckingAccount(int id, double initialBalance, double overdraft) {
        super(id, initialBalance, overdraft);
        if (overdraft < 0) {
            throw new IllegalArgumentException("Invalid overdraft value: " + overdraft);
        }
        this.overdraft = overdraft;
        this.id = id;
        this.initialBalance = initialBalance;
    }

    @Override
    public double maximumAmountToWithdraw() {
        return balance;
    }
}
