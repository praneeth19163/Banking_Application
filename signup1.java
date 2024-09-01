import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class signup1 extends JFrame implements ActionListener {
   JPanel p1,p2,p3;
   JLabel l,l1,l2,l3,l4,l5,l6,l7;
   JTextField t1,t2,t4;
   JPasswordField t3;

   JTextArea t5;
   JButton b1,b2;
   signup1(){
      setSize(400,800);
      setVisible(true);
      setTitle("REGISTRATION");
      setLayout(new GridLayout(3,1));
      p1=new JPanel(new FlowLayout());
      p2=new JPanel(new GridLayout(5,2,20,20));
      p3=new JPanel(new FlowLayout(FlowLayout.CENTER));
      l=new JLabel("REGISTRATION FORM");
      add(l);
      p1.add(l);
      add(p1);Font f=new Font("verdana",Font.BOLD,60);
      Font f1=new Font("Verdana",Font.BOLD,20);
      l.setFont(f);
      l.setForeground(Color.ORANGE);
      l1=new JLabel("          NAME:");
      t1=new JTextField(20);
      p2.add(l1);
      p2.add(t1);
      l2=new JLabel("          MOBILE_NUMBER:");
      t2=new JTextField(20);
      p2.add(l2);
      p2.add(t2);
      l3=new JLabel("          CREATE PASSWORD:");
      t3=new JPasswordField(20);
      t3.setEchoChar('*');
      //t3=new JTextField(20);
      
      p2.add(l3);
      p2.add(t3);
      l4=new JLabel("          CONFIRM PASSWORD:");
      t4=new JTextField(20);
      p2.add(l4);
      p2.add(t4);
      l5=new JLabel("          ADDRESS:");
      t5=new JTextArea();
      p2.add(l5);
      p2.add(t5);
      l1.setFont(f1);
      l2.setFont(f1);
      l3.setFont(f1);
      l4.setFont(f1);
      l5.setFont(f1);
      add(p2);
      b1=new JButton("SUBMIT");
      b1.addActionListener(this);
      b2=new JButton("GO TO LOGIN PAGE");
      b2.addActionListener(this);
      p3.add(b1);
      
      p3.add(b2);
      add(p3);

   }

   
   @SuppressWarnings("deprecation")
   @Override
   public void actionPerformed(ActionEvent e) {
   String str=e.getActionCommand();
   if(str.equals("SUBMIT")) {
      if((t3.getText()).equals(t4.getText())) {
         if(t1.getText().equals("")||t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||t5.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "please fill the form");
            return;
         }
           try {
              Class.forName("com.mysql.jdbc.Driver");
              Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","970151");
              PreparedStatement ps=con.prepareStatement("insert into bank values(?,?,?,?)");
              ps.setString(1, t1.getText());
              ps.setString(2,t2.getText());
              ps.setString(3,t4.getText());
              ps.setString(4,t5.getText());
              ps.executeUpdate();
              PreparedStatement ps1=con.prepareStatement("insert into balance(mobile_number) values(?)");
              ps1.setString(1,t2.getText());
              ps1.executeUpdate();
              con.close();
              JOptionPane.showMessageDialog(null,"Registration Successfull - GO TO LOGIN PAGE","Registration Successfull",JOptionPane.PLAIN_MESSAGE);
           }catch(Exception a) {
              a.printStackTrace();
           }
           finally {
              t1.setText(" ");
              t2.setText(" ");
              t4.setText(" ");
              t5.setText(" ");
              t3.setText(" ");
           }
      }
      else {
         JOptionPane.showMessageDialog(null,"create password and confirm password didnot matched","Registration unsuccessfull",JOptionPane.ERROR_MESSAGE);
      }
   }
   else {
      new Login();
      dispose();
   }
      
   }
   

}

