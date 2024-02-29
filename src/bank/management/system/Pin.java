package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    Pin(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1300,800);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setFont(new Font("System",Font.BOLD,15));
        label1.setBounds(390,385,200,25);
        l3.add(label1);

        JLabel label2 = new JLabel("NEW PIN:");
        label2.setFont(new Font("System",Font.BOLD,14));
        label2.setBounds(390,410,200,25);
        l3.add(label2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(128, 118, 65));
        p1.setForeground(Color.WHITE);
        p1.setBounds(530,410,150,20);
        p1.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(p1);

        JLabel label3 = new JLabel("Re-Enter NEW PIN:");
        label3.setFont(new Font("System",Font.BOLD,14));
        label3.setBounds(390,430,200,25);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(128, 118, 65));
        p2.setForeground(Color.WHITE);
        p2.setBounds(530,435,150,20);
        p2.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(p2);



        b1 = new JButton("CHANGE");
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


        setSize(1550,1080);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered pin doesnot match");
                return;
            }
            if (e.getSource()==b1){
                if (p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New Pin");
                    return;
                }
                if (p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New Pin");
                    return;
                }
                Connec c = new Connec();
                String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signupthree set pin = '"+pin1+"' where pin = '"+pin+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new Transaction(pin);

            }else if (e.getSource()==b2){
                new Transaction(pin);
                setVisible(false);

            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Pin("");

    }
}
