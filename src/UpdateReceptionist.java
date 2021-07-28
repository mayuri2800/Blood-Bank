import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;

public class UpdateReceptionist extends JFrame implements ActionListener
{
      JFrame jf;
      Font f;
      JComboBox cb1;
      String s;
      JLabel l1,l2,l3,l4,l5,l6;
      JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
      JButton b1,b2,b3;
      String state[]={"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
      Connection conn;
      PreparedStatement ps;
      Statement stmt;
      ResultSet rs;


      UpdateReceptionist()
      {
        jf=new JFrame();
        f=new Font("Skia",Font.BOLD,25);
        jf.setLayout(null);

        l1 = new JLabel("Update Receptionist");
        l1.setFont(new Font("Skia",Font.BOLD,25));
        l1.setForeground(Color.white);
        l1.setBounds(300,30,400,40);
        jf.add(l1);

        l2 = new JLabel("Receptionist Id*");
        l2.setBounds(50,100,200,25);
        jf.add(l2);

              t1 = new JTextField("Receptionist Id",20);
              t1.setBounds(250,100,100,25);
              t1.setToolTipText("Enter Receptionist Id");
              jf.add(t1);

        l3 = new JLabel("Receptionist Name*");
        l3.setBounds(50,140,200,25);
        jf.add(l3);

              t2 = new JTextField("Receptionist Name",20);
              t2.setBounds(250,140,250,25);
              t2.setToolTipText("Enter Receptionist Name");
              jf.add(t2);

        l4 = new JLabel("Receptionist Address");
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

              t9 = new JTextField(20);
              t9.setBounds(377,255,150,25);
              jf.add(t9);

              cb1 = new JComboBox(state);
              cb1.setBounds(377,230,150,25);
              jf.add(cb1);
              cb1.addActionListener(new ActionListener()
              {
                public void actionPerformed(ActionEvent ae)
                {
                  s = (String)cb1.getSelectedItem();
                  t9.setText(s);
                }
              });


              t6 = new JTextField("Pin Code",20);
              t6.setBounds(250,255,123,25);
              t6.setToolTipText("Pin Code");
              jf.add(t6);


        l5 = new JLabel("Phone No");
        l5.setBounds(50,335,200,25);
        jf.add(l5);

              t7 = new JTextField("Phone No",30);
              t7.setBounds(250,335,123,25);
              t7.setToolTipText("Phone No");
              jf.add(t7);

        l6 = new JLabel("Email Id");
        l6.setBounds(50,375,200,25);
        jf.add(l6);

              t8 = new JTextField("Email Id",30);
              t8.setBounds(250,375,123,25);
              t8.setToolTipText("Email Id");
              jf.add(t8);

        b1 = new JButton("Show");
        b1.setBounds(150,455,110,35);
        b1.setToolTipText("Click To Show All Details");
        jf.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Update");
        b2.setBounds(300,455,110,35);
        b2.setToolTipText("Click To Update");
        jf.add(b2);
        b2.addActionListener(this);

        b3 = new JButton("Clear");
        b3.setBounds(450,455,110,35);
        b3.setToolTipText("Click To Submit");
        jf.add(b3);
        b3.addActionListener(this);

        jf.setTitle("Update Receptionist");
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
              JOptionPane.showMessageDialog(this,"Please enter receptionist id or name !","Warning!!!",JOptionPane.WARNING_MESSAGE);
          }
          else
	        {//fetch
	           try
	           {
               int foundrec = 0;
               Class.forName("com.mysql.jdbc.Driver");
               conn = DriverManager.getConnection("jdbc:mysql://localhost/Blood_Donation","root","root1234");
               ps=conn.prepareStatement("select * from receptionist where RId='"+t1.getText()+"' or RName='"+t2.getText()+"'");
               rs=ps.executeQuery();
               while(rs.next())
         	     {
                 t1.setText(rs.getString(1));
                 t2.setText(rs.getString(2));
       	         t3.setText(rs.getString(3));
       	         t4.setText(rs.getString(4));
       		       t5.setText(rs.getString(5));
                 t9.setText(rs.getString(6));
                 t6.setText(rs.getString(7));
                 t7.setText(rs.getString(8));
                 t8.setText(rs.getString(9));
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
  		        JOptionPane.showMessageDialog(this,"Please enter receptionist id or name !","Warning!!!",JOptionPane.ERROR_MESSAGE);
  	      }
          else if(((t2.getText()).equals(""))||((t3.getText()).equals(""))||((t4.getText()).equals(""))||((t5.getText()).equals(""))||((t8.getText()).equals(""))||((t6.getText()).equals(""))||((t7.getText()).equals(""))||((t8.getText()).equals("")))
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
              String str1="UPDATE receptionist SET RId='"+t1.getText()+"',RName='"+t2.getText()+"',RBHF='"+t3.getText()+"',RLand='"+t4.getText()+"',RCity='"+t5.getText()+"',RState='"+t9.getText()+"',RPincode='"+t6.getText()+"',RPhno='"+t7.getText()+"',REmail='"+t8.getText()+"' where RId='"+t1.getText()+"' or RName='"+t2.getText()+"' ";
              stmt.executeUpdate(str1);
              JOptionPane.showMessageDialog(null, "Record is updated");
              t1.setText("");
        	    t2.setText("");
        		  t3.setText("");
        	    t4.setText("");
            	t5.setText("");
              t9.setText("");
              t6.setText("");
              t7.setText("");
              t8.setText("");
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
                t9.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
         }
      }

      public static void main(String args[])
      {
        new UpdateReceptionist();
      }
}
