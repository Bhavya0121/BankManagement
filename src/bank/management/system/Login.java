package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel label1, label2,label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1, button2,button3;

    Login(){
        super("Bank Management System");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Bank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(120,80, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250,5,100,100);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.jpg"));
        Image ii2 = ii1.getImage().getScaledInstance(120,80, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(450,250,100,100);
        add(iimage);

        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("AvantGarde",Font.BOLD,38));
        label1.setBounds(150,125,450,40);
        add(label1);

        label2 = new JLabel("Card No.:");
        label2.setFont(new Font("Ralway",Font.BOLD,20));
        label2.setForeground(Color.BLACK);
        label2.setBounds(100,170,375,30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(205,170,230,30);
        textField2.setFont(new Font("Arial",Font.BOLD,14));
        add(textField2);

        label3 = new JLabel("PIN:");
        label3.setFont(new Font("Ralway",Font.BOLD,20));
        label3.setForeground(Color.BLACK);
        label3.setBounds(100,210,375,30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(205,205,230,30);
        passwordField3.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordField3);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial",Font.BOLD,14));
        button1.setForeground(Color.BLACK);
        button1.setBounds(200,250,100,30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setForeground(Color.BLACK);
        button2.setBounds(330,250,100,30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setForeground(Color.BLACK);
        button3.setBounds(200,300,230,30);
        button3.addActionListener(this);
        add(button3);



        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/Background.jpg"));
        Image iii2 = iii1.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);

        setLayout(null);
        setSize(600,400);
        setLocation(400,200);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == button1){
                Connec c = new Connec();
                String cardno = textField2.getText();
                String pin = passwordField3.getText();
                String q = "select * from login where card_number = '"+cardno+"' and pin = '"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if(resultSet.next()){
                    setVisible(false);
                    new Transaction(pin);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }

            }else if(e.getSource() == button2){
                textField2.setText("");
                passwordField3.setText("");

            }else if(e.getSource() == button3){
                new Signup();
                setVisible(false);

            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Login();

    }
}
