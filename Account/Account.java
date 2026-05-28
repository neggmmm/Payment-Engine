package Account;

import Enums.Currency;

public abstract class Account {
    private String id;
    private String name;
    private Currency currency;
    private double balance;

    public Account(String id, String name, Currency currency, double balance) {
        this.id = id;
        this.name = name;
        this.currency = currency;
        this.balance = balance;
    }

    public abstract double getTransactionLimit();

    public abstract String getAccountType();

    public void credit(double amount) {
        this.balance += amount;
    }

    public void debit(double amount) {
        this.balance -= amount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | Balance: %.2f %s",
                getAccountType(), name, balance, currency);
    }
}
