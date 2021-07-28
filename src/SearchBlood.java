import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
//import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SearchBlood extends JFrame implements ActionListener
{
  Font f;
  JFrame jf;
  JLabel l1,l2;
  JTextField t1;
  JButton b1,b2;
  Connection conn;
  PreparedStatement ps;
  Statement stmt;
  ResultSet rs;
  DefaultTableModel model = new DefaultTableModel();
  JTable tabGrid = new JTable(model);
  JScrollPane scrlPane = new JScrollPane(tabGrid);

  SearchBlood()
  {
    jf=new JFrame();
    f=new Font("Skia",Font.BOLD,25);
    jf.setLayout(null);

    l1 = new JLabel("Search Blood");
    l1.setFont(new Font("Skia",Font.BOLD,25));
    l1.setForeground(Color.white);
    l1.setBounds(350,30,400,40);
    jf.add(l1);

    l2 = new JLabel("Blood Name*");
    l2.setBounds(325,100,200,30);
    jf.add(l2);

        t1 = new JTextField("Blood Name",20);
        t1.setBounds(425,100,100,25);
        t1.setToolTipText("Enter Blood Name");
        jf.add(t1);

    b1 = new JButton("Show");
    b1.setBounds(300,300,110,35);
    b1.setToolTipText("Click To Show All Details");
    jf.add(b1);
    b1.addActionListener(this);

    b2 = new JButton("Clear");
    b2.setBounds(450,300,110,35);
    b2.setToolTipText("Click To Submit");
    jf.add(b2);
    b2.addActionListener(this);

    scrlPane.setBounds(0,380,900,600);
    jf.add(scrlPane);
    tabGrid.setFont(new Font ("Times New Roman",0,15));

    model.addColumn("D_ID");
    model.addColumn("D_NAME");
    model.addColumn("D_BLOODGRP");
    model.addColumn("D_PHONENO");
    model.addColumn("D_EMAILID");

    jf.setTitle("Search Blood");
    jf.setSize(900,700);
    jf.setLocation(20,20);
    jf.setResizable(false);
    jf.getContentPane().setBackground(Color.red);
    jf.setVisible(true);
  }
  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==b1)
    {
    	int r=0;
      if(((t1.getText()).equals("")))
      {
          JOptionPane.showMessageDialog(this,"Please enter blood name !","Warning!!!",JOptionPane.WARNING_MESSAGE);
      }
      else
      {//fetch
         try
         {
           int foundrec = 0;
           Class.forName("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection("jdbc:mysql://localhost/Blood_Donation","root","root1234");
           ps=conn.prepareStatement("select * from donor where DBG='"+t1.getText()+"'");
           rs=ps.executeQuery();
           while(rs.next())
           {
             model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(8),rs.getString(9),rs.getString(10)});

             foundrec = 1;
           }
           if (foundrec == 0)
           {
                JOptionPane.showMessageDialog(null,"Record is not available","Dialog",JOptionPane.WARNING_MESSAGE);
           }
           conn.close();
         }
         catch(Exception e)
         {
              System.out.println(e);
              JOptionPane.showMessageDialog(null,"Error:"+e);
         }
      }
    }
    else if(ae.getSource()==b2)
    {//clear
            t1.setText("");

    }
  }
    public static void main(String args[])
    {
      new SearchBlood();
    }

}
