package org.lu.ics.labs;


import org.lu.ics.labs.PersonRegister;
import org.lu.ics.labs.Account;
import org.lu.ics.labs.Person;

public class test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        PersonRegister PR = new PersonRegister();

        Account a1 = new Account("111");
        a1.setBalance(100);

        Account a2 = new Account("112");
        a2.setBalance(200);

        Account b1 = new Account("113");
        b1.setBalance(300);

        Account b2 = new Account("114");
        b2.setBalance(400);

        Person a = new Person("Linnea Forsler", "980101-2825");
        a.addAccount(a1);
        a.addAccount(a2);
        PR.addPerson(a);

        Person b = new Person("Ida Carlsson", "990511-5805");
        b.addAccount(b1);
        b.addAccount(b2);
        PR.addPerson(b);

        Person x = PR.removePerson("980101-2825");
        if (x != null) {
            System.out.println(x.getName () + " är borttagen");
        }

        Person y = PR.findPerson("980101-2825");
        if(y != null) {
            System.out.println (y.getName ());

            for (Account tmp: y.getBankAccount()) {
                System.out.println(tmp.getBalance());
                System.out.println(tmp.getNbr());
            }
        } else {
            System.out.println("Personen finns inte");
        }
    }
}