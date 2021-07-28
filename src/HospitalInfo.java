//import java.util.regex.Pattern;
//import java.util.regex.Matcher;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class HospitalInfo extends JFrame implements ActionListener
{
      JFrame jf;
      Font f;
      JLabel l1,l2,l3,l4,l5,l7,l6;
      JTextField t1,t2,t3,t4,t5,t6,t7;
      JButton b1,b2,b3;
      String state[]={"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
      Connection conn;
  	PreparedStatement ps;
  	Statement stmt;
  	ResultSet rs;
  	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);


      HospitalInfo()
      {
        jf=new JFrame();
        f=new Font("Skia",Font.BOLD,25);
        jf.setLayout(null);

        l1 = new JLabel("Hospital Details");
        l1.setFont(new Font("Skia",Font.BOLD,25));
        l1.setForeground(Color.white);
        l1.setBounds(350,30,400,40);
        jf.add(l1);

        /*l2 = new JLabel("Hospital Id*");
        l2.setBounds(150,100,200,25);
        jf.add(l2);

        t1 = new JTextField("Hospital Id",20);
        t1.setBounds(250,100,100,25);
        t1.setToolTipText("Enter Donor Id");
        jf.add(t1);*/

        l3 = new JLabel("Hospital Name*");
        l3.setBounds(150,80,250,50);
        jf.add(l3);

        t2 = new JTextField("Hospital Name",20);
        t2.setBounds(250,100,200,25);
        t2.setToolTipText("Enter Hospital Name");
        jf.add(t2);

        l3=new JLabel("Address*");
        l3.setBounds(150,140,200,25);
        jf.add(l3);

        t3=new JTextField("Address",20);
        t3.setBounds(250,140,180,50);
        t3.setToolTipText("Enter Address");
        jf.add(t3);

        l4= new JLabel("Phno*");
		l4.setBounds(150,200,200,25);
		jf.add(l4);

		t4 = new JTextField("Phno",20);
		t4.setBounds(250,200,100,25);
		t4.setToolTipText("Enter Phone No");
		jf.add(t4);

		l5 = new JLabel("B_Quantity*");
		l5.setBounds(150,230,250,50);
		jf.add(l5);

		t5 = new JTextField("Quantity",20);
		t5.setBounds(250,240,200,25);
		t5.setToolTipText("Enter Quantity");
		jf.add(t5);


		l6= new JLabel("Purchase Date*");
		l6.setBounds(150,295,200,25);
		jf.add(l6);

		t6 = new JTextField("Purchase Date",20);
		t6.setBounds(250,295,100,25);
		t6.setToolTipText("Enter Purchase Date");
		jf.add(t6);

		l7 = new JLabel("Price*");
		l7.setBounds(150,320,250,50);
		jf.add(l7);

		t7 = new JTextField("Price",20);
		t7.setBounds(250,330,200,25);
		t7.setToolTipText("Enter Price");
		jf.add(t7);

		 scrlPane.setBounds(0,450,900,600);
         jf.add(scrlPane);
         tabGrid.setFont(new Font ("Times New Roman",0,15));

           model.addColumn("H_ID");
           model.addColumn("H_NAME");
           model.addColumn("H_ADDRESS");
           model.addColumn("H_PHONENO");
           model.addColumn("QUANTITY");
           model.addColumn("P_DATE");
           model.addColumn("PRICE");
           
		b1 = new JButton("All");
		b1.setBounds(250,400,110,35);
		b1.setToolTipText("Click To All");
		jf.add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("Add");
		b2.setBounds(400,400,110,35);
		b2.setToolTipText("Click To ADD");
		jf.add(b2);
		b2.addActionListener(this);

		b3 = new JButton("Clear");
		b3.setBounds(550,400,110,35);
		b3.setToolTipText("Click To Clear");
		jf.add(b3);
		b3.addActionListener(this);

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
              rs = stmt.executeQuery("SELECT * from hospital" );
              while(rs.next())
              {
                 	model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
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
		         //String mob = t6.getText();
				 //Pattern p=Pattern.compile("[_a-z_A-Z_0-9]+[0-9]*@[a-zA-Z0-9]+.[a-zA-Z0-9]+");
		        

		         if(((t2.getText()).equals(""))||((t3.getText()).equals(""))||((t4.getText()).equals(""))||((t5.getText()).equals(""))||((t6.getText()).equals(""))||((t7.getText()).equals("")))
		         {
		             JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
				  }
		         else
		         {
		              try
		              {
		                  Class.forName("com.mysql.jdbc.Driver");
		                  conn = DriverManager.getConnection("jdbc:mysql://localhost/Blood_Donation","root","root1234");
		                  System.out.println("Connected to database.");
		                  stmt = conn.createStatement();
		                  ps=conn.prepareStatement("insert into hospital(HName,HAdd,HPhno,Qty,PDate,Price) values(?,?,?,?,?,?)");
		                  ps.setString(1,t2.getText());
		                  ps.setString(2,t3.getText());
		                  ps.setString(3,t4.getText());
		                  ps.setString(4,t5.getText());
		                  ps.setString(5,t6.getText());
		                  ps.setString(6,t7.getText());
		                  ps.executeUpdate();

		                  int reply=JOptionPane.showConfirmDialog(null,"Hospital Details added successfully.Do you want add more Hospitals?","Added",JOptionPane.YES_NO_OPTION);
		                  if (reply == JOptionPane.YES_OPTION)
		                  {
		                    jf.setVisible(false);
		                    new NewDonor();
		                  }
		                  else if (reply == JOptionPane.NO_OPTION)
		                  {
		                    jf.setVisible(false);
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
		           {
		             //t1.setText("");
		             t2.setText("");
		             t3.setText("");
		             t4.setText("");
		             t5.setText("");
		             t6.setText("");
		             t7.setText("");
         }

      }

      public static void main(String args[])
      {
        new HospitalInfo();
      }
}
