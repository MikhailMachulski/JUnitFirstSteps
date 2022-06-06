package com.company;

public abstract class Account {
    protected int balance;

    public abstract void pay (int amount);
    public abstract void transfer (Account account, int amount) throws CreditAccount.CreditAccountException;
    public abstract void addMoney (int amount) throws CreditAccount.CreditAccountException;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
