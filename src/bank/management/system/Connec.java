package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connec {
    Connection connection;
    Statement statement;
    public Connec(){
       try{
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","Bhavya1@");
           statement = connection.createStatement();

       }catch (Exception e){
           e.printStackTrace();
       }

    }
}
