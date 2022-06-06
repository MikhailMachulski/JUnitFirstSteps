package com.company;

public class CheckingAccount extends Account{
    private int balance;

    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public void pay(int amount) {
        if (balance - amount >= 0) {
            balance = balance - amount;
        } else {
            System.out.println("You do not have enough money to pay.");
        }
    }

    @Override
    public void transfer(Account account, int amount) throws CreditAccount.CreditAccountException {
        if (balance - amount >= 0) {
            account.addMoney(amount);
            balance = balance - amount;
        } else {
            System.out.println("You do not have enough money to transfer.");
        }
    }

    @Override
    public void addMoney(int amount) {
        balance = balance + amount;
    }
}
