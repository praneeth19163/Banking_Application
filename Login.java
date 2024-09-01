import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
   JPanel p1,p2,p3;
   JLabel l1,l,l2;
   JButton b,b1;
   
   JTextField t1;
   JPasswordField t2;
   Login(){
      setSize(400,200);
      setVisible(true);
      setTitle("LOGIN");
         setLayout(new GridLayout(3,1));
         p1=new JPanel(new FlowLayout());
       p2=new JPanel(new FlowLayout());
       p3=new JPanel(new GridLayout(2,1));
       l=new JLabel("LOGIN FORM");
       add(l);
       p1.add(l);
       add(p1);
       Font f=new Font("verdana",Font.BOLD,60);
       l.setFont(f);
       l.setForeground(Color.blue);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
       Font f1=new Font("Verdana",Font.BOLD,20);
            l1=new JLabel("Username or Mobile_Number  :  ");
      l2=new JLabel("Password  :  ");
      t1=new JTextField(20);
       t2=new JPasswordField(20);
      
      l1.setFont(f1);
      l2.setFont(f1);
      p2.add(l1);
      p2.add(t1);
      p2.add(l2);
      p2.add(t2);
      
      add(p2);
       b=new JButton("Login");
       b.addActionListener(this);
        b1=new JButton("FORGOT PASSWORD ? CLICK HERE");
        b1.addActionListener(this);
        p3.add(b);
        p3.add(b1);
        add(p3);
      
      
      
   }

   @SuppressWarnings("deprecation")
   @Override
   public void actionPerformed(ActionEvent e) {
      String str=e.getActionCommand();
      if(str.equals("Login")) {
         if(t1.getText().equals("")||t2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "please fill the form");
            return;
         }
         try {
            
               Class.forName("com.mysql.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","970151");
                 Statement st=con.createStatement();
                 String q="select password from bank where mobile_number='"+t1.getText()+"'";
                 ResultSet rs=st.executeQuery(q);
                 String get_password="";
                 while(rs.next()) {
                    get_password=rs.getString(1);
                 }
                 if(get_password.equals(t2.getText())) {
                    JOptionPane.showMessageDialog(null,"LOGIN SUCCESSFULL","LOGIN",JOptionPane.INFORMATION_MESSAGE);
                    new Banking_Application(t1.getText());
                    dispose();
                 }
                 else {
                    JOptionPane.showMessageDialog(null,"USERNAME OR PASSWORD IS INCORRECT","LOGIN",JOptionPane.ERROR_MESSAGE);
                    
                 }
      }
         catch(Exception a) {
            a.printStackTrace();
         }
         finally {
            t1.setText(" ");
            t2.setText(" ");
         }
         
      }
      else {
         new ForgetPassword(t1.getText());
         dispose();
      }
      
   }

}

