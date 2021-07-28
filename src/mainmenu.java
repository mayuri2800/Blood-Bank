import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class mainmenu extends JFrame implements ActionListener, Runnable
{
  JFrame jf;
  JMenuBar mbar;
  JMenu m1,m2,m3,m4,m5;
  JMenuItem m1_1,m1_2,m1_3,m1_4,m2_1,m2_2,m2_3,m2_4,m3_1,m3_2,m4_1;
  JLabel l1;
  public mainmenu()
  {
    jf=new JFrame();
    jf.setLayout(null);
    //jf.setContentPane(new JLabel(new ImageIcon("image//front.jpeg")));
    mbar=new JMenuBar();
    jf.setJMenuBar(mbar);

    /*SimpleDateFormat dtf=new SimpleDateFormat("hh:mm:ss aa");
    Date dat=cal.getTime();
    /*String time=dtf.format(now);*/

    //String timeStamp = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

    /*l1.setText(time);
    l1.setBounds(250,200,50,25);
    jf.add(l1);*/

    m1=new JMenu("Donor");
    mbar.add(m1);
    m1_1=new JMenuItem("New Donor");
    m1_1.addActionListener(this);
    m1.add(m1_1);
    m1_2=new JMenuItem("Delete Donor");
    m1_2.addActionListener(this);
    m1.add(m1_2);
    m1_3=new JMenuItem("Update Donor");
    m1_3.addActionListener(this);
    m1.add(m1_3);
    m1_4=new JMenuItem("All Donor");
    m1_4.addActionListener(this);
    m1.add(m1_4);

    m2=new JMenu("Receptionist");
    mbar.add(m2);
    m2_1=new JMenuItem("New Receptionist");
    m2_1.addActionListener(this);
    m2.add(m2_1);
    m2_2=new JMenuItem("Delete Receptionist");
    m2_2.addActionListener(this);
    m2.add(m2_2);
    m2_3=new JMenuItem("Update Receptionist");
    m2_3.addActionListener(this);
    m2.add(m2_3);
    m2_4=new JMenuItem("All Receptionist");
    m2_4.addActionListener(this);
    m2.add(m2_4);

    m3=new JMenu("Blood Info");
    mbar.add(m3);
    m3_1=new JMenuItem("Search Blood");
    m3_1.addActionListener(this);
    m3.add(m3_1);
    m3_2=new JMenuItem("Stock Of Blood");
    m3_2.addActionListener(this);
    m3.add(m3_2);

    m4=new JMenu("Hospital");
    mbar.add(m4);
    m4_1=new JMenuItem("Hospital Info");
    m4_1.addActionListener(this);
    m4.add(m4_1);

    m5=new JMenu("About US");
    m5.addActionListener(this);
    mbar.add(m5);
    
    Thread t1=new Thread(this);
    t1.start();
    
    jf.getContentPane().setBackground(Color.red);
    jf.setTitle("Main Menu");
    jf.setLocation(20,20);
    jf.setSize(900,600);
    jf.setResizable(false);
    jf.setVisible(true);
  }
  public void run()
  {
    synchronized(this)
    {
      while(true)
      {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time=dtf.format(now);
        l1=new JLabel();
        l1.setText(time);			 
        l1.setBounds(740,510,250,25);
        jf.add(l1);
      }
    }
  }
  /*public class Clock extends JFrame implements Runnable
  {
    public void init()
    {
      //initComponents();
      Thread t=new Thread(this);
      t.start();
    }
    public void run()
    {
      while(true)
      {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time=dtf.format(now);
        l1.setText(time);
      }
    }
  }*/
  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==m1_1)
    {
      new NewDonor();
    }
    else if(ae.getSource()==m1_2)
    {
      new DeleteDonor();
    }
    else if(ae.getSource()==m1_3)
    {
      new UpdateDonor();
    }
    else if(ae.getSource()==m1_4)
    {
      new AllDonor();
    }
    else if(ae.getSource()==m2_1)
    {
      new NewReceptionist();
    }
    else if(ae.getSource()==m2_2)
    {
      new DeleteReceptionist();
    }
    else if(ae.getSource()==m2_3)
    {
      new UpdateReceptionist();
    }
    else if(ae.getSource()==m2_4)
    {
      new AllReceptionist();
    }
    else if(ae.getSource()==m3_1)
    {
      new SearchBlood();
    }
    else if(ae.getSource()==m3_2)
    {
      new StockOfBlood();
    }
    else if(ae.getSource()==m4_1)
    {
      new HospitalInfo();
    }
    else if(ae.getSource()==m5)
    {
      new Aboutus();
    }
  }
  public static void main(String[] args)
  {
    new mainmenu();
  }
}
