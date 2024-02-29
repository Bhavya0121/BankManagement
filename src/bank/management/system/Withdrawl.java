package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    String pin;
    TextField textField;

    JButton b1,b2;

    Withdrawl(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1300,800);
        add(l3);

        JLabel label1 = new JLabel("MAXIMUM WITHDRAWL IS RS.10,000");
        //label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,14));
        label1.setBounds(400,390,400,18);
        l3.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        //label1.setForeground(Color.WHITE);
        label2.setFont(new Font("System",Font.BOLD,12));
        label2.setBounds(400,410,400,16);
        l3.add(label2);

        textField = new TextField();
        textField.setBackground(new Color(128, 118, 65));
        textField.setForeground(Color.WHITE);
        textField.setBounds(400,430,320,25);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(textField);

        b1 = new JButton("WITHDRAW");
        b1.setBounds(620,500,130,25);
        b1.setBackground(new Color(128, 118, 65));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(620,530,130,25);
        b2.setBackground(new Color(128,118,65));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        //setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");

                } else {
                    Connec c = new Connec();
                    ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else if (resultSet.getString("type").equals("Withdrawl")){
                            balance -=Integer.parseInt(resultSet.getString("amount"));
                        }
//                        else {
//                            balance -= Integer.parseInt(resultSet.getString("amount"));
//                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawl','"+ amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                    setVisible(false);
                    new Transaction(pin);
                }
            } catch (Exception E) {
                E.printStackTrace();

            }
        }else if (e.getSource()==b2){
            setVisible(false);
            new Transaction(pin);

        }
    }

    public static void main(String[] args) {
        new Withdrawl("");

    }
}
