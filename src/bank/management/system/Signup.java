package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JRadioButton r1,r2,m1,m2,m3;
    JButton next;

    JTextField textName ,textFname, textEmail,textAdd, textCity,textPin,textState;
    JDateChooser dateChooser;

    Random ran = new Random();

    Long first4 = (ran.nextLong() % 9000L)+ 1000L;

    String first = " " + Math.abs(first4);
    Signup(){
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Bank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO."+ first);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Ralway",Font.BOLD,22));
        label2.setBounds(330,70,600,30);
        add(label2);

        JLabel label3 = new JLabel(("Personal Details"));
        label3.setFont(new Font("Ralway",Font.BOLD,22));
        label3.setBounds(290,95,600,30);
        add(label3);

        JLabel labelName= new JLabel("Name :");
        labelName.setFont(new Font("Ralway",Font.BOLD,20));
        labelName.setBounds(100,170,80,20);
        add(labelName);

        textName= new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD,14));
        textName.setBounds(300,170,350,25);
        add(textName);

        JLabel labelFname= new JLabel("Father's Name :");
        labelFname.setFont(new Font("Ralway",Font.BOLD,20));
        labelFname.setBounds(100,210,200,20);
        add(labelFname);

        textFname= new JTextField();
        textFname.setFont(new Font("Raleway",Font.BOLD,14));
        textFname.setBounds(300,210,400,25);
        add(textFname);

        JLabel DOB= new JLabel("Date of Birth :");
        DOB.setFont(new Font("Ralway",Font.BOLD,20));
        DOB.setBounds(100,290,200,25);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,290,400,25);
        add(dateChooser);

        JLabel labelG = new JLabel("Gender :");
        labelG.setFont(new Font("Ralway",Font.BOLD,20));
        labelG.setBounds(100,250,200,25);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(300,250,60,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(new Color(222,255,228));
        r2.setBounds(450,250,90,30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel labelEmail = new JLabel("Email address :");
        labelEmail.setFont(new Font("Raleway",Font.BOLD,20));
        labelEmail.setBounds(100,330,200,25);
        add(labelEmail);

        textEmail= new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD,14));
        textEmail.setBounds(300,330,400,25);
        add(textEmail);

        JLabel labelMs = new JLabel("Marital Status :");
        labelMs.setFont(new Font("Raleway",Font.BOLD,20));
        labelMs .setBounds(100,370,200,25);
        add(labelMs);

        m1 = new JRadioButton("Married");
        m1.setFont(new Font("Raleway",Font.BOLD,14));
        m1.setBackground(new Color(222,255,228));
        m1.setBounds(300,370,100,25);
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setFont(new Font("Raleway",Font.BOLD,14));
        m2.setBackground(new Color(222,255,228));
        m2.setBounds(400,370,100,25);
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setFont(new Font("Raleway",Font.BOLD,14));
        m3.setBackground(new Color(222,255,228));
        m3.setBounds(520,370,100,25);
        add(m3);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        buttonGroup1.add(m3);


        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Raleway",Font.BOLD,20));
        labelAdd.setBounds(100,410,200,25);
        add(labelAdd);

        textAdd= new JTextField();
        textAdd.setFont(new Font("Raleway",Font.BOLD,14));
        textAdd.setBounds(300,410,400,25);
        add(textAdd);

        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Raleway",Font.BOLD,20));
        labelCity.setBounds(100,450,200,25);
        add(labelCity);

        textCity= new JTextField();
        textCity.setFont(new Font("Raleway",Font.BOLD,14));
        textCity.setBounds(300,450,400,25);
        add(textCity);

        JLabel labelPin = new JLabel("Pincode :");
        labelPin.setFont(new Font("Raleway",Font.BOLD,20));
        labelPin.setBounds(100,490,200,25);
        add(labelPin);

        textPin= new JTextField();
        textPin.setFont(new Font("Raleway",Font.BOLD,14));
        textPin.setBounds(300,490,400,25);
        add(textPin);

        JLabel labelState = new JLabel("State :");
        labelState.setFont(new Font("Raleway",Font.BOLD,20));
        labelState.setBounds(100,530,200,25);
        add(labelState);

        textState= new JTextField();
        textState.setFont(new Font("Raleway",Font.BOLD,14));
        textState.setBounds(300,530,400,25);
        add(textState);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,570,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setUndecorated(true);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = first;
        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField)dateChooser.getDateEditor()).getText();
        String gender = null;
        if(r1.isSelected()){
            gender ="Male";
        }else if(r2.isSelected()){
            gender= "Female";
        }
        String email = textEmail.getText();
        String marital = null;
        if(m1.isSelected()){
            marital = "Married";
        }else if(m2.isSelected()){
            marital ="Unmarried";
        } else if(m3.isSelected()){
            marital = " Other";
        }
        String address= textAdd.getText();
        String city = textCity.getText();
        String Pincode = textPin.getText();
        String state = textState.getText();

        try{
            if(textName.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the details");
            }else{
                Connec connec1 = new Connec();
                String q = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+Pincode+"','"+state+"')";
                connec1.statement.executeUpdate(q);
                new Signup2(formno);
                setVisible(false);
            }
            }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}