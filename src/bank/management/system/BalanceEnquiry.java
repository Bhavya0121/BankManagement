package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class BalanceEnquiry extends JFrame implements ActionListener {
    String pin;
    JLabel label2;

    JButton b1;
    BalanceEnquiry(String pin){
        this.pin =pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1300,800);
        add(l3);

        JLabel label1 = new JLabel("Your Current Balance is: ");
        //label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,14));
        label1.setBounds(400,390,400,18);
        l3.add(label1);

        b1 = new JButton("BACK");
        b1.setBounds(620,500,130,25);
        b1.setBackground(new Color(128, 118, 65));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        label2 = new JLabel();
        //label1.setForeground(Color.WHITE);
        label2.setFont(new Font("System",Font.BOLD,12));
        label2.setBounds(400,410,400,16);
        l3.add(label2);

        int balance=0;
        try{
            Connec c = new Connec();
            ResultSet resultSet = c.statement.executeQuery("Select * from bank where pin = '"+pin+"'");

            while(resultSet.next()){
                if(resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else{
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        label2.setText(""+balance);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        //setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transaction(pin);

    }

    public static void main(String[] args) {
        new BalanceEnquiry("");

    }
}
