package org.lu.ics.labs;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import org.lu.ics.labs.Account;
import org.lu.ics.labs.Person;
import org.lu.ics.labs.Controller;

public class CustomerApplication {
    private JFrame frame;
    private JTextField textField_Name;
    private JTextField textField_pNbr;
    private Controller controller = new Controller();
    private JTextField textField_kontonummer;
    private JButton btnNewButton_removePerson;
    private JButton btnNewButton_findPerson;
    private JButton btnNewButton_addPerson;
    private JTextArea textArea;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JButton btnLggTillKonto;
    private JLabel lblAccountNumber;
    private JButton btnShowAccounts;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	CustomerApplication window = new CustomerApplication();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public CustomerApplication() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textArea = new JTextArea();
        textArea.setBounds(34, 217, 300, 30);
        frame.getContentPane().add(textArea);

        btnNewButton_addPerson = new JButton("Add Person");
        btnNewButton_addPerson.addActionListener(new ActionListener() {
     
            public void actionPerformed(ActionEvent e) {
                String name = textField_Name.getText();
                String pNbr = textField_pNbr.getText();
                
                if (!pNbr.equals("") && !name.equals("")) {
	                Person p = new Person(name, pNbr);
	                
	                controller.addPerson(p);
	                textArea.setText("The person has been added.");
                } else {
                	textArea.setText("Error: Enter a personal number / name");
                }
            }
        });
        btnNewButton_addPerson.setBounds(21, 72, 139, 25);
        frame.getContentPane().add(btnNewButton_addPerson);

        btnNewButton_findPerson = new JButton("Find Person");
        btnNewButton_findPerson.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pNbr = textField_pNbr.getText();
                Person p = controller.findPerson(pNbr);
                if (p != null) {
                    textArea.setText(p.getName());
                } else {
                    textArea.setText("The person can't be found.");
                }
            }
        });
        btnNewButton_findPerson.setBounds(156, 71, 139, 25);
        frame.getContentPane().add(btnNewButton_findPerson);

        btnNewButton_removePerson = new JButton("Remove Person");
        btnNewButton_removePerson.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
                String pNbr = textField_pNbr.getText();
                
                if (!pNbr.equals("")) {
	                controller.removePerson(pNbr);
	                textArea.setText("The person has been deleted.");
                } else {
                	textArea.setText("Error: Enter a personal number");
                }
                
            }
        });
        btnNewButton_removePerson.setBounds(303, 72, 139, 25);
        frame.getContentPane().add(btnNewButton_removePerson);

        btnLggTillKonto = new JButton("Add account");
        btnLggTillKonto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String pnr = textField_pNbr.getText();
            	Person person = controller.findPerson(pnr);
            	
            	if (person != null) {
            	
                controller.addAccount(new Account(textField_kontonummer.getText()),
                        controller.findPerson(textField_pNbr.getText()));
                Person tmp = controller.findPerson(textField_pNbr.getText());
                textArea.setText("Account " + (textField_kontonummer.getText()) + " has been added for person " + tmp.getName());
            	} 
            	else {
            		textArea.setText("Error: Person doesnt exist" );
            	}
            }
        });
        btnLggTillKonto.setBounds(18, 148, 139, 25);
        frame.getContentPane().add(btnLggTillKonto);


        lblAccountNumber = new JLabel("Kontonummer:");
        lblAccountNumber.setBounds(34, 113, 106, 16);
        frame.getContentPane().add(lblAccountNumber);

        textField_kontonummer = new JTextField();
        textField_kontonummer.setBounds(167, 108, 116, 22);
        frame.getContentPane().add(textField_kontonummer);
        textField_kontonummer.setColumns(10);

        textField_Name = new JTextField();
        textField_Name.setBounds(164, 10, 116, 22);
        frame.getContentPane().add(textField_Name);
        textField_Name.setColumns(10);

        lblNewLabel = new JLabel("Name:");
        lblNewLabel.setBounds(35, 13, 56, 16);
        frame.getContentPane().add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Personnummer:");
        lblNewLabel_1.setBounds(30, 44, 106, 16);
        frame.getContentPane().add(lblNewLabel_1);

        textField_pNbr = new JTextField();
        textField_pNbr.setBounds(164, 41, 116, 22);
        frame.getContentPane().add(textField_pNbr);
        textField_pNbr.setColumns(10);

        btnShowAccounts = new JButton("Find all Accounts");
        btnShowAccounts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	String pnr = textField_pNbr.getText();
            	Person person = controller.findPerson(pnr);
            	if (person != null) {
                	
            		
            		  String pNbr = textField_pNbr.getText();
                      textArea.setText("");
                      for (Account a : controller.findPerson(pNbr).getBankAccount()) {
                          textArea.append(a.getPerson().getName() + " owns account: " + a.getNbr() + "\n");
                      }
                	} 
                	else {
                		textArea.setText("Error: Person doesnt exist " );
                	}
              

            }
        });
        btnShowAccounts.setBounds(156, 147, 139, 25);
        frame.getContentPane().add(btnShowAccounts);

        JButton btnNewButton = new JButton("Show Balance");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String nbr = textField_kontonummer.getText();
                String pNbr = textField_pNbr.getText();

                Account a = controller.findSpecificAccount(pNbr, nbr);
                if (a != null) {
                    textArea.setText("Your balance is : " + a.getBalance());
                }
            }
        });
        btnNewButton.setBounds(305, 145, 137, 25);
        frame.getContentPane().add(btnNewButton);
    }
}