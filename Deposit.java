import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class Deposit extends JFrame implements ActionListener {
   JTextField t;
   JButton b1,b2,b3;
   JLabel l;
   String str1;
   int n;
Deposit(String str){
   str1=str;
   setTitle("BALANCE DEPOSIT");
    setVisible(true);
    setSize(500,500);
    setLayout(new FlowLayout(FlowLayout.CENTER));
   l=new JLabel("Enter The Amount To Deposit : ");
   add(l);
   t=new JTextField(20);
   add(t);
   b1=new JButton("Deposit");
   b2=new JButton("Balance Enquiry");
   b3=new JButton("Home");
   add(b1);
   add(b2);
   add(b3);
   b1.addActionListener(this);
   b2.addActionListener(this);
   b3.addActionListener(this);
   
}

@Override
public void actionPerformed(ActionEvent e) {
   String str=e.getActionCommand();
   if(str.equals("Deposit")) {
      try {
         Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","970151");
            PreparedStatement st=con.prepareStatement("select balance from balance where mobile_number=?");
            st.setString(1,str1);
          ResultSet rs=st.executeQuery();
          int get_balance=0;
          while(rs.next()) {
             get_balance=rs.getInt(1);
          }
          
         n=Integer.parseInt(t.getText());
        
            JOptionPane.showMessageDialog(null,"amount is credited","Deposit Successfull",JOptionPane.PLAIN_MESSAGE);
            PreparedStatement st1=con.prepareStatement("update balance set balance=? where mobile_number=?");
            st1.setInt(1,get_balance+n);
            st1.setString(2, str1);
            st1.executeUpdate();
            t.setText("");
          }
    catch(Exception a) {
       a.printStackTrace();
    }
   }
   else if(str.equals("Balance Enquiry")) {
      new Balance_Enquiry(str1);
      dispose();
   }
   else {
      new Banking_Application(str1);
      dispose();
	}}
}
