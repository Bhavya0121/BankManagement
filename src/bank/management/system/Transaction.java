package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    Transaction(String pin){
        this.pin = pin;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1300,600);
        add(l3);

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setBounds(370,300,500,22);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("System",Font.BOLD,24));
        l3.add(label);

        b1 = new JButton("DEPOSIT");
        b1.setForeground(Color.BLACK);
        b1.setBackground(new Color(128, 110, 65));
        b1.setBounds(350,355,160,20);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("WITHDRAWL");
        b2.setForeground(Color.BLACK);
        b2.setBackground(new Color(128, 110, 65));
        b2.setBounds(590,355,160,20);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setForeground(Color.BLACK);
        b3.setBackground(new Color(128, 110, 65));
        b3.setBounds(350,380,160,20);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setForeground(Color.BLACK);
        b4.setBackground(new Color(128, 110, 65));
        b4.setBounds(590,380,160,20);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setForeground(Color.BLACK);
        b5.setBackground(new Color(128, 110, 65));
        b5.setBounds(350,405,160,20);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setForeground(Color.BLACK);
        b6.setBackground(new Color(128, 110, 65));
        b6.setBounds(590,405,160,20);
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("EXIT");
        b7.setForeground(Color.BLACK);
        b7.setBackground(new Color(128, 110, 65));
        b7.setBounds(590,430,160,20);
        b7.addActionListener(this);
        l3.add(b7);

        setLayout(null);
        setSize(1550,830);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            new Deposit(pin);
            setVisible(false);
        }else if (e.getSource()==b7){
            System.exit(0);
        }else if (e.getSource()== b2){
            new Withdrawl(pin);
            setVisible(false);
        }else if (e.getSource()==b6){
            new BalanceEnquiry(pin);
            setVisible(false);
        }else if (e.getSource()==b3){
            new FastCash(pin);
            setVisible(false);
        }else if (e.getSource()==b5){
            new Pin(pin);
            setVisible(false);
        }else if (e.getSource()==b4){
            new Mini(pin);
           setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Transaction("");

    }
}
