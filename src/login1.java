import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class InvalidException extends Exception
{
}


class login1 extends JFrame implements ActionListener
{
  JFrame jf;
  JButton b1,b2,b3;
  JLabel l1,l2,l3,l4,l5;
  JTextField t1,t2;
  JPasswordField p1;
  Font f;
  int cnt=0;


  login1()
  {
    jf=new JFrame();
    f=new Font("Skia",Font.BOLD,25);
    jf.setLayout(null);
    jf.setContentPane(new JLabel(new ImageIcon("image//bg.jpeg")));
    //JPanel p=new JPanel();
    //JLabel background=new JLabel(new ImageIcon("image//stethoscope.png"));
    //background.setBounds(600,100,300,150);
    //jf.add(background);
    //background.setLayout(new FlowLayout());

    l1=new JLabel("LOGIN");
    l1.setForeground(Color.white);
    l1.setFont(new Font("Skia",Font.BOLD,30));
    l1.setBounds(400,100,300,40);
    jf.add(l1);

    l4=new JLabel(new ImageIcon("image//login.png"));
    l4.setBounds(250,200,50,25);
    jf.add(l4);

    l2=new JLabel("User Name:");
    l2.setForeground(Color.white);
    l2.setFont(f);
    l2.setBounds(300,200,200,25);
    jf.add(l2);

    t1 = new JTextField(20);
		t1.setBounds(450,200,200,25);
		t1.setToolTipText("Enter Username");
	  jf.add(t1);

    l5=new JLabel(new ImageIcon("image//password.png"));
    l5.setBounds(250,250,50,25);
    jf.add(l5);

    l3=new JLabel("Password:");
    l3.setForeground(Color.white);
    l3.setFont(f);
    l3.setBounds(300,250,200,25);
    jf.add(l3);

    p1=new JPasswordField(20);
    p1.setBounds(450,250,200,25);
    p1.setToolTipText("Enter Password");
    jf.add(p1);

    b1=new JButton("Login");
    b1.setBounds(250,300,100,35);
    jf.add(b1);
    b1.addActionListener(this);

    b2=new JButton("Clear");
    b2.setBounds(400,300,100,35);
    jf.add(b2);
    b2.addActionListener(this);

    b3=new JButton("Exit");
    b3.setBounds(550,300,100,35);
    jf.add(b3);
    b3.addActionListener(this);
    //jf.add(p);
    jf.setTitle("Login");
    jf.setLocation(20,20);
    jf.setSize(900,600);
    jf.setResizable(false);
    jf.getContentPane().setBackground(Color.red);
    //jf.setContentPane(new JLabel(new ImageIcon("image//bg.jpeg")));
    jf.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==b1)
    {
      try
      {
        String urs=t1.getText();
        String pass=new String(p1.getPassword());
        if((urs.compareTo("omkar")==0)&(pass.compareTo("omkar1234")==0))
        {
          JOptionPane.showMessageDialog(null,"Welcome !!! You are valid user !!!","Welcome",JOptionPane.INFORMATION_MESSAGE);
          jf.setVisible(false);
          new mainmenu();
          //mainmenu function call ithe karaych
        }
        else
        {
          throw new InvalidException();
        }
      }
      catch(Exception e1)
      {
        cnt++;
        JOptionPane.showMessageDialog(null,"Sorry !!! You are not valid user !!!","Warning",JOptionPane.ERROR_MESSAGE);
        t1.setText("");
        p1.setText("");
        if(cnt==3)
        {
          JOptionPane.showMessageDialog(null,"Sorry !!! Your 3 attempts are over !!!","warning",JOptionPane.ERROR_MESSAGE);
          System.exit(0);
        }
      }
    }
    else if(ae.getSource()==b2)
    {
      t1.setText("");
      p1.setText("");
    }
    else if(ae.getSource()==b3)
    {
      System.exit(0);
    }
  }

  public static void main(String args[])
  {
    new login1();
  }
}
