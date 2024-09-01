import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class First extends JFrame implements ActionListener {
   JLabel l,l1;
   JButton b1,b2;
   JPanel p1,p2;
First(){
   setSize(500,500);
   setVisible(true);
   setTitle("LOGIN OR REGISTRATION");
   setLayout(new GridLayout(2,1));
   p1=new JPanel(new FlowLayout());
   p2=new JPanel(new GridLayout(3,1));
   l=new JLabel("BANKING APPLICATION");
   add(l);
   p1.add(l);
   add(p1);
   Font f=new Font("verdana",Font.BOLD,60);
   l.setFont(f);
   l1=new JLabel("                         NEW USER->REGISTERATION                 EXISTED USER->LOGIN             ");
   Font f1=new Font("verdana",Font.BOLD,30);
   l1.setFont(f1);
   l1.setForeground(Color.ORANGE);
   p2.add(l1);
   b1=new JButton("Login");
   b1.setBackground(Color.BLUE);
   p2.add(b1);add(p2);
   b1.addActionListener(this);
   b2=new JButton("Registration");
   b2.setBackground(Color.blue);
   p2.add(b2);
   b2.addActionListener(this);
   
}

@Override
public void actionPerformed(ActionEvent e) {
   String str=e.getActionCommand();
   if(str.equals("Login")) {
   new Login();
   dispose();
   }
   else {
      new signup1();
      dispose();
   }
   
}
public static void main(String args[]) {
   new First();

}
}
