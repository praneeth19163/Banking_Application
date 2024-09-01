import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

public class Banking_Application extends JFrame implements ActionListener {
   JPanel p1,p2,p3;
   JLabel l,l1,l2;
     String str1;
     JButton b1,b2,b3,b4;
   Banking_Application(String str){
      str1=str;
      setSize(500,500);
      setVisible(true);
      setTitle("BANKING");
      setLayout(new GridLayout(3,1));
      p1=new JPanel(new GridLayout(2,1));
      p2=new JPanel(new FlowLayout());
      p3=new JPanel(new FlowLayout());
      l=new JLabel("                      BANKING DETAILS");
      add(l);
      p1.add(l);
      p1.setBackground(Color.LIGHT_GRAY);
      l.setForeground(Color.MAGENTA);
      add(p1);
      Font f=new Font("verdana",Font.BOLD,60);
      l.setFont(f);
      l1=new JLabel("WELCOME       ");
      Font f1=new Font("Verdana",Font.ITALIC,20);
      Font f2=new Font("verdana",Font.BOLD,40);
      l1.setFont(f1);
      p2.add(l1);
      p1.add(p2);
      try {
         Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","970151");
            PreparedStatement st=con.prepareStatement("select name from bank where mobile_number=?");
            st.setString(1,str1);
              ResultSet rs=st.executeQuery();
              String get_name="";
              while(rs.next()) {
                 get_name=rs.getString(1);
              }
              l2=new JLabel(get_name.toUpperCase());
              l2.setFont(f2);
              l2.setForeground(Color.gray);
              p2.add(l2);
              p2.setBackground(Color.orange);
              con.close();
              
      }
      catch(Exception e){
         e.printStackTrace();
      }
      
      b1=new JButton("Customer Details");
      b2=new JButton("Balance Enquiry");
      b3=new JButton("Withdraw");
      b4=new JButton("Deposit");
      p3.add(b1);
      p3.add(b2);
      p3.add(b3);
      p3.add(b4);
     add(p3);
     b2.addActionListener(this);
     b3.addActionListener(this);
     b4.addActionListener(this);
     p3.setBackground(Color.cyan);
      
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      String str=e.getActionCommand();
      if(str.equals("Balance Enquiry")) {
      new Balance_Enquiry(str1);
      dispose();
   }
      else if(str.equals("Withdraw")) {
         new Withdraw(str1);
         dispose();
      }
      else if(str.equals("Deposit")) {
         new Deposit(str1);
      }
}}
