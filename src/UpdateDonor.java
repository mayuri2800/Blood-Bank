import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;

public class UpdateDonor extends JFrame implements ActionListener
{
      JFrame jf;
      JComboBox cb3,cb2,cb1;
      String g,bgroup,s;
      Font f;
      JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
      JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
      JButton b1,b2,b3;
      String state[]={"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
      String BGroup[]={"A+","A-","B+","B-","O+","O-","AB+","AB-"};
      String gender[]={"Female","Male"};
      Connection conn;
      PreparedStatement ps;
    	Statement stmt;
      ResultSet rs;

      UpdateDonor()
      {
        jf=new JFrame();
        f=new Font("Skia",Font.BOLD,25);
        jf.setLayout(null);

        l1 = new JLabel("Update Donor");
        l1.setFont(new Font("Skia",Font.BOLD,25));
        l1.setForeground(Color.white);
        l1.setBounds(375,30,400,40);
        jf.add(l1);

        l2 = new JLabel("Donor Id*");
        l2.setBounds(50,100,200,25);
        jf.add(l2);

              t1 = new JTextField("Donor Id",20);
              t1.setBounds(250,100,100,25);
              t1.setToolTipText("Enter Donor Id");
              jf.add(t1);

        l3 = new JLabel("Donor Name*");
        l3.setBounds(50,140,200,25);
        jf.add(l3);

              t2 = new JTextField("Donor Name",20);
              t2.setBounds(250,140,250,25);
              t2.setToolTipText("Enter Donor Name");
              jf.add(t2);

        l4 = new JLabel("Donor Address*");
        l4.setBounds(50,180,200,25);
        jf.add(l4);

              t3 = new JTextField("Building no/Flat no/House no",20);
              t3.setBounds(250,180,250,25);
              t3.setToolTipText("Building no/Flat no/House no");
              jf.add(t3);

              t4 = new JTextField("Landmark",20);
              t4.setBounds(250,205,250,25);
              t4.setToolTipText("Landmark");
              jf.add(t4);

              t5 = new JTextField("City",20);
              t5.setBounds(250,230,123,25);
              t5.setToolTipText("City");
              jf.add(t5);

              t12 = new JTextField(20);
        	    t12.setBounds(377,255,150,25);
        	    jf.add(t12);

              cb1 = new JComboBox(state);
              cb1.setBounds(377,230,150,25);
              jf.add(cb1);
              cb1.addActionListener(new ActionListener()
              {
                public void actionPerformed(ActionEvent ae)
                {
                  s = (String)cb1.getSelectedItem();
                  t12.setText(s);
                }
              });

              t6 = new JTextField("Pin Code",20);
              t6.setBounds(250,255,123,25);
              t6.setToolTipText("Pin Code");
              jf.add(t6);

        l5 = new JLabel("Blood Group*");
        l5.setBounds(50,295,200,25);
        jf.add(l5);

        t13 = new JTextField(20);
        t13.setBounds(377,295,150,25);
        jf.add(t13);

        cb2 = new JComboBox(BGroup);
        cb2.setBounds(250,295,123,25);
        jf.add(cb2);
        cb2.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent ae)
          {
            bgroup = (String)cb2.getSelectedItem();
            t13.setText(bgroup);
          }
        });

        l6 = new JLabel("Phone No*");
        l6.setBounds(50,335,200,25);
        jf.add(l6);

              t7 = new JTextField("Phone No",30);
              t7.setBounds(250,335,123,25);
              t7.setToolTipText("Phone No");
              jf.add(t7);

        l7 = new JLabel("Email Id*");
        l7.setBounds(50,375,200,25);
        jf.add(l7);

              t8 = new JTextField("Email Id",30);
              t8.setBounds(250,375,123,25);
              t8.setToolTipText("Email Id");
              jf.add(t8);

        l8 = new JLabel("Last You Donated");
        l8.setBounds(550,100,150,25);
        jf.add(l8);

              t9 = new JTextField("dd-mm-yyyy");
              t9.setBounds(700,100,150,25);
              t9.setToolTipText("dd-mm-yyyy");
              jf.add(t9);

        l9 = new JLabel("Height*");
        l9.setBounds(550,140,150,25);
        jf.add(l9);

              t10 = new JTextField("Height");
              t10.setBounds(650,140,150,25);
              t10.setToolTipText("Height");
              jf.add(t10);

        l10 = new JLabel("Weight*");
        l10.setBounds(550,180,150,25);
        jf.add(l10);

              t11 = new JTextField("Weight");
              t11.setBounds(650,180,150,25);
              t11.setToolTipText("Weight");
              jf.add(t11);

        l11 = new JLabel("Gender*");
        l11.setBounds(550,220,150,25);
        jf.add(l11);

        t14 = new JTextField(20);
        t14.setBounds(650,245,150,25);
        jf.add(t14);

        cb3 = new JComboBox(gender);
        cb3.setBounds(650,220,123,25);
        jf.add(cb3);
        cb3.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent ae)
          {
            g = (String)cb3.getSelectedItem();
            t14.setText(g);
          }
        });

        b1 = new JButton("Show");
        b1.setBounds(250,455,110,35);
        b1.setToolTipText("Click To Show All Details");
        jf.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Update");
        b2.setBounds(400,455,110,35);
        b2.setToolTipText("Click To Update");
        jf.add(b2);
        b2.addActionListener(this);

        b3 = new JButton("Clear");
        b3.setBounds(550,455,110,35);
        b3.setToolTipText("Click To Submit");
        jf.add(b3);
        b3.addActionListener(this);

        jf.setTitle("Update Donor");
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
          if(((t1.getText()).equals(""))&&((t2.getText()).equals("")))
          {
              JOptionPane.showMessageDialog(this,"Please enter donor id or name !","Warning!!!",JOptionPane.WARNING_MESSAGE);
          }
          else
	        {//fetch
	           try
	           {
               int foundrec = 0;
               Class.forName("com.mysql.jdbc.Driver");
               conn = DriverManager.getConnection("jdbc:mysql://localhost/Blood_Donation","root","root1234");
               ps=conn.prepareStatement("select * from donor where DId='"+t1.getText()+"' or DName='"+t2.getText()+"'");
               rs=ps.executeQuery();
               while(rs.next())
         	     {
                 t1.setText(rs.getString(1));
                 t2.setText(rs.getString(2));
       	         t3.setText(rs.getString(3));
       	         t4.setText(rs.getString(4));
       		       t5.setText(rs.getString(5));
                 t12.setText(rs.getString(6));
                 t6.setText(rs.getString(7));
                 t13.setText(rs.getString(8));
                 t7.setText(rs.getString(9));
                 t8.setText(rs.getString(10));
                 t9.setText(rs.getString(11));
                 t10.setText(rs.getString(12));
                 t11.setText(rs.getString(13));
                 t14.setText(rs.getString(14));
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
        {//update
          String email=t8.getText();
          Pattern p=Pattern.compile("[_a-z_A-Z_0-9]*[0-9]*@[a-zA-Z0-9]*.[a-zA-Z0-9]*");
          Matcher m=p.matcher(email);
          boolean matchFound=m.matches();

          if(((t1.getText()).equals(""))&&((t2.getText()).equals("")))
  	      {
  		        JOptionPane.showMessageDialog(this,"Please enter donor id or name !","Warning!!!",JOptionPane.ERROR_MESSAGE);
  	      }
          else if(((t2.getText()).equals(""))||((t3.getText()).equals(""))||((t4.getText()).equals(""))||((t5.getText()).equals(""))||((cb1.getSelectedItem()).equals(""))||((t6.getText()).equals(""))||((cb2.getSelectedItem()).equals(""))||((t7.getText()).equals(""))||((t8.getText()).equals(""))||((t10.getText()).equals(""))||((t11.getText()).equals(""))||((cb3.getSelectedItem()).equals("")))
	        {
		          JOptionPane.showMessageDialog(this,"Detail are Missing !","Warning!!!",JOptionPane.ERROR_MESSAGE);
	        }
          else if(!matchFound)
	        {
	       	  JOptionPane.showMessageDialog(this,"Invalid email id!","Warning!!!",JOptionPane.WARNING_MESSAGE);
	       	}
          else
          {
            try
            {
              Class.forName("com.mysql.jdbc.Driver");
              conn = DriverManager.getConnection("jdbc:mysql://localhost/Blood_Donation","root","root1234");
      		    System.out.println("Connected to database.");
          	  stmt=conn.createStatement();
              String str1="UPDATE donor SET DId='"+t1.getText()+"',DName='"+t2.getText()+"',DBHF='"+t3.getText()+"',DLand='"+t4.getText()+"',DCity='"+t5.getText()+"',DState='"+t12.getText()+"',DPincode='"+t6.getText()+"',DBG='"+t13.getText()+"',DPhno='"+t7.getText()+"',DEmail='"+t8.getText()+"',DLast='"+t9.getText()+"',DHeight='"+t10.getText()+"',DWeight='"+t11.getText()+"',DGender='"+t14.getText()+"' where DId='"+t1.getText()+"' or DName='"+t2.getText()+"' ";
              stmt.executeUpdate(str1);
              JOptionPane.showMessageDialog(null, "Record is updated");
              t1.setText("");
        	    t2.setText("");
        		  t3.setText("");
        	    t4.setText("");
            	t5.setText("");
              t12.setText("");
              t6.setText("");
              t13.setText("");
              t7.setText("");
              t8.setText("");
              t9.setText("");
              t10.setText("");
              t11.setText("");
              t14.setText("");
            	conn.close();
            }
            catch(Exception e)
        	  {
        	   	 System.out.println(e);
        	     JOptionPane.showMessageDialog(null,"Error:"+e);
        	  }
          }
        }
        else if(ae.getSource()==b3)
        {//clear
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t12.setText("");
                t6.setText("");
                t13.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
                t10.setText("");
                t11.setText("");
                t14.setText("");
         }
      }

      public static void main(String args[])
      {
        new UpdateDonor();
      }
}
