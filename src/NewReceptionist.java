import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
/*import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;*/
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class NewReceptionist extends JFrame implements ActionListener
{

      JFrame jf;
      Font f;
      JComboBox cb1;
      String s;
      JLabel l1,l2,l3,l4,l5;
      JTextField t1,t2,t3,t4,t5,t6,t7;
      String state[]={"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
      JButton b1,b2;
      Connection conn;
      PreparedStatement ps;
      Statement stmt;

     NewReceptionist()
      {
          jf=new JFrame();
          f=new Font("Skia",Font.BOLD,25);
          jf.setLayout(null);

          l1 = new JLabel("New Receptionist Form");
          l1.setFont(new Font("Skia",Font.BOLD,25));
          l1.setForeground(Color.white);
          l1.setBounds(300,30,400,40);
          jf.add(l1);

          l2 = new JLabel("Receptionist Name*");
          l2.setBounds(50,100,200,25);
          jf.add(l2);

                t1 = new JTextField("Receptionist Name",20);
                t1.setBounds(250,100,100,25);
                t1.setToolTipText("Enter Receptionist Name");
                jf.add(t1);

          l3 = new JLabel("Receptionist Address*");
          l3.setBounds(50,140,200,25);
          jf.add(l3);

                t2 = new JTextField("Building no/Flat no/House no",20);
                t2.setBounds(250,140,250,25);
                t2.setToolTipText("Building no/Flat no/House no");
                jf.add(t2);

                t3 = new JTextField("Landmark",20);
                t3.setBounds(250,170,250,25);
                t3.setToolTipText("Landmark");
                jf.add(t3);

                t4 = new JTextField("City",20);
                t4.setBounds(250,200,123,25);
                t4.setToolTipText("City");
                jf.add(t4);


                cb1 = new JComboBox(state);
                cb1.setBounds(377,200,150,25);
                jf.add(cb1);
                cb1.addActionListener(new ActionListener()
                {
                  public void actionPerformed(ActionEvent ae)
                  {
                    s = (String)cb1.getSelectedItem();
                  }
                });

                t5 = new JTextField("Pin Code",20);
                t5.setBounds(250,225,123,25);
                t5.setToolTipText("Pin Code");
                jf.add(t5);

          l4 = new JLabel("Phone No*");
          l4.setBounds(50,265,200,25);
          jf.add(l4);

                t6 = new JTextField("Phone No",30);
                t6.setBounds(250,265,123,25);
                t6.setToolTipText("Phone No");
                jf.add(t6);

          l5 = new JLabel("Email Id*");
          l5.setBounds(50,305,200,25);
          jf.add(l5);

                t7 = new JTextField("Email Id",30);
                t7.setBounds(250,305,123,25);
                t7.setToolTipText("Email Id");
                jf.add(t7);

          b1 = new JButton("Submit");
          b1.setBounds(300,400,110,35);
          b1.setToolTipText("Click To Submit");
          jf.add(b1);
          b1.addActionListener(this);

          b2 = new JButton("Clear");
          b2.setBounds(450,400,110,35);
          b2.setToolTipText("Click To Clear ALL TextField");
          jf.add(b2);
          b2.addActionListener(this);

          jf.setTitle("New Receptionist");
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
          String mob = t6.getText();
          String email=t7.getText();
          Pattern p=Pattern.compile("[_a-z_A-Z_0-9]+[0-9]*@[a-zA-Z0-9]+.[a-zA-Z0-9]+");
          Matcher m=p.matcher(email);
          boolean matchFound=m.matches();

          if(((t1.getText()).equals(""))||((t2.getText()).equals(""))||((t3.getText()).equals(""))||((t4.getText()).equals(""))||((t5.getText()).equals(""))||((t6.getText()).equals(""))||((t7.getText()).equals("")))
          {
            JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
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
                stmt = conn.createStatement();
                ps=conn.prepareStatement("insert into receptionist(RName,RBHF,RLand,RCity,RState,RPincode,RPhno,REmail) values(?,?,?,?,?,?,?,?)");
                ps.setString(1,t1.getText());
                ps.setString(2,t2.getText());
                ps.setString(3,t3.getText());
                ps.setString(4,t4.getText());
                ps.setString(5,s);
                ps.setInt(6,Integer.parseInt(t5.getText()));
                ps.setString(7,t6.getText());
                ps.setString(8,t7.getText());
                ps.executeUpdate();

                int reply=JOptionPane.showConfirmDialog(null,"Receptionist added successfully.Do you want add more receptionist?","Added Receptionist",JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION)
                {
                  jf.setVisible(false);
                  new NewReceptionist();
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
         else if(ae.getSource()==b2)
         {
           t1.setText("");
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
         new NewReceptionist();
       }
}
