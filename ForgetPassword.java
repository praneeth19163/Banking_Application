import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class ForgetPassword extends JFrame implements ActionListener {
   JLabel l1,l2;
   JTextField t1,t2;
   JButton b1;
 ForgetPassword(String str){
    setTitle("UPDATION OF PASSWORD");
    setVisible(true);
    setSize(500,500);
    setLayout(new GridLayout(3,2));
    l1=new JLabel("Username or Mobile_Number :");
    t1=new JTextField(20);
    t1.setText(str);
    add(l1);
    add(t1);
    l2=new JLabel("Create New Password :");
    t2=new JTextField(20);
    add(l2);
    add(t2);
    b1=new JButton("Submit");
    add(b1);
    b1.addActionListener(this);
 }

@Override
public void actionPerformed(ActionEvent e) {
   if(t1.getText().equals("")||t2.getText().equals("")) {
      JOptionPane.showMessageDialog(null, "please fill the form");
      return;
   }
   else {
      try {
         Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","970151");
          PreparedStatement ps=con.prepareStatement("update bank set password=? where mobile_number=?");
          ps.setString(1,t2.getText());
          ps.setString(2,t1.getText());
          ps.executeUpdate();
          con.close();
          new Login();
          dispose();
      }
      catch(Exception a) {
         a.printStackTrace();
      }
   }
   
}
}
