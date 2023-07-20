package com.luxoft.bankapp.exceptions;

public class OverdraftLimitExceededException extends NotEnoughFundsException {
    private double overdraft;
    private double maximum_withdrawel_amount;

    public OverdraftLimitExceededException(int id, double balance, double amount, double overdraft) {
        super(id, balance, amount, (overdraft+balance));
        this.overdraft = overdraft;
        this.maximum_withdrawel_amount = balance + overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }
}

