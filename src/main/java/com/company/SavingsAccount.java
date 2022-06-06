package com.company;

public class SavingsAccount extends Account{
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
        System.out.println("You can not pay with saving account.");
    }

    @Override
    public void transfer(Account account, int amount) throws CreditAccount.CreditAccountException {
        account.addMoney(amount);
        balance = balance - amount;
    }

    @Override
    public void addMoney(int amount) {
        balance = balance + amount;
    }

}
