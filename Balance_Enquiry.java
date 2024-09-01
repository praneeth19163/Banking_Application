
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;


public class Balance_Enquiry extends JFrame implements ActionListener {
   JTextField t;
   JLabel l;
   String str1;
   JButton b;
Balance_Enquiry(String str){
   str1=str;
   setTitle("BALANCE ENQUIRY");
    setVisible(true);
    setSize(500,500);
    setLayout(new FlowLayout(FlowLayout.CENTER));
    t=new JTextField(20);
    l=new JLabel("Balance in Bank : ");
    add(l);
    add(t);
    b=new JButton("Home");
    add(b);
    b.addActionListener(this);
    try {
         Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","970151");
            PreparedStatement st=con.prepareStatement("select balance from balance where mobile_number=?");
            st.setString(1,str1);
          ResultSet rs=st.executeQuery();
          String get_balance="";
          while(rs.next()) {
             get_balance=rs.getString(1);
          }
          t.setText(get_balance);
          con.close();
          }
    catch(Exception a) {
       a.printStackTrace();
    }

    
}

@Override
public void actionPerformed(ActionEvent e) {
new Banking_Application(str1);
dispose();
   
}
}
