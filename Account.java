package org.lu.ics.labs;

import org.lu.ics.labs.PersonRegister;
import org.lu.ics.labs.Account;
import org.lu.ics.labs.Person;

public class Account {
    private String nbr;
    private double balance;
    private Person person;

    public Account(String nbr) {
        this.nbr = nbr;
    }

    public void setNbr(String nbr) {
        this.nbr = nbr;
    }

    public String getNbr() {
        return nbr;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void credit(double amount) {
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        balance = balance - amount;
    }
}