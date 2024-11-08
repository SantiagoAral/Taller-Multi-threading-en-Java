package com.example;

import java.util.concurrent.Callable;

public class TransactionTask implements Callable<String> {
    private final BankAccount account;
    private final String transactionType;
    private final double amount;

    public TransactionTask(BankAccount account, String transactionType, double amount) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    @Override
    public String call() {
        try {
            if ("deposit".equalsIgnoreCase(transactionType)) {
                account.deposit(amount);
                return "Deposited " + amount;
            } else if ("withdraw".equalsIgnoreCase(transactionType)) {
                account.withdraw(amount);
                return "Withdrew " + amount;
            } else {
                return "Invalid transaction type";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
