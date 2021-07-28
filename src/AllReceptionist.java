import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AllReceptionist extends JFrame implements ActionListener
{

      JFrame jf;
      Font f;
      JComboBox cb1;
      String s;
      JLabel l1,l2,l3,l4,l5,l6;
      JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
      String state[]={"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
      JButton b1,b2,b3;
      Connection conn;
      PreparedStatement ps;
      Statement stmt;
      ResultSet rs;
      DefaultTableModel model = new DefaultTableModel();
      JTable tabGrid = new JTable(model);
      JScrollPane scrlPane = new JScrollPane(tabGrid);

      AllReceptionist()
      {
          jf=new JFrame();
          f=new Font("Skia",Font.BOLD,25);
          jf.setLayout(null);

          l1 = new JLabel("Receptionist Information");
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

          l4 = new JLabel("Receptionist Address*");
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

      	  l5 = new JLabel("Phone No*");
          l5.setBounds(50,295,200,25);
          jf.add(l5);

                t7 = new JTextField("Phone No",30);
                t7.setBounds(250,295,123,25);
                t7.setToolTipText("Phone No");
                jf.add(t7);

          l6 = new JLabel("Email Id*");
          l6.setBounds(50,335,200,25);
          jf.add(l6);

                t8 = new JTextField("Email Id",30);
                t8.setBounds(250,335,123,25);
                t8.setToolTipText("Email Id");
                jf.add(t8);


          b1 = new JButton("All");
          b1.setBounds(250,415,110,35);
          b1.setToolTipText("Click To All");
          jf.add(b1);
          b1.addActionListener(this);

          b2 = new JButton("Search");
          b2.setBounds(400,415,110,35);
          b2.setToolTipText("Click To Search");
          jf.add(b2);
          b2.addActionListener(this);

          b3 = new JButton("Clear");
          b3.setBounds(550,415,110,35);
          b3.setToolTipText("Click To Clear ALL TextField");
          jf.add(b3);
          b3.addActionListener(this);

          scrlPane.setBounds(0,450,900,600);
          jf.add(scrlPane);
          tabGrid.setFont(new Font ("Times New Roman",0,15));

            model.addColumn("R_ID");
            model.addColumn("R_NAME");
            model.addColumn("R_BHF");
            model.addColumn("R_LAND");
            model.addColumn("R_CITY");
            model.addColumn("R_STATE");
            model.addColumn("R_PINCODE");
            model.addColumn("R_PHONENO");
            model.addColumn("R_EMAILID");

          jf.setTitle("All Receptionist");
          jf.setSize(900,700);
 	        jf.setLocation(20,20);
 	        jf.setResizable(false);
 	        jf.getContentPane().setBackground(Color.red);
 	        jf.setVisible(true);
      }
      public void actionPerformed(ActionEvent ae)
      {
          if(ae.getSource()==b1)
          {//list
       	    int r = 0;
            try
            {
              Class.forName("com.mysql.jdbc.Driver");
              conn = DriverManager.getConnection("jdbc:mysql://localhost/Blood_Donation","root","root1234");
     		      System.out.println("Connected to database.");
     		      stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
              rs = stmt.executeQuery("SELECT * from receptionist" );
              while(rs.next())
              {
                 	model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
              }
              conn.close();
            }
            catch(Exception e)
            {
            	   System.out.println(e);
                JOptionPane.showMessageDialog(null,"Error:"+e);
            }
          }
          if(ae.getSource()==b2)
          {
    	   		if(((t1.getText()).equals(""))&&((t2.getText()).equals("")))
    	        {
    		          JOptionPane.showMessageDialog(this,"Please enter Receptionist id or name !","Warning!!!",JOptionPane.WARNING_MESSAGE);
    	        }
    	        else
    	        {//fetch
    	           try
    	           {
    	              int foundrec = 0;
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/Blood_Donation","root","root1234");
    		            System.out.println("Connected to database.");
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
        new AllReceptionist();
      }
}
