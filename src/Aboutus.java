import javax.swing.*;
import java.awt.*;

class Aboutus extends JFrame
{
	JFrame jf;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton b1,b2,b3;

	Aboutus()
	{
		jf=new JFrame();

		jf.setLayout(null);

		l1 = new JLabel("Blood Bank Manangement System");
		l1.setFont(new Font("Skia",Font.BOLD,25));
		l1.setBounds(250,30,600,40);l1.setForeground(Color.white);
		jf.add(l1);



		l2 = new JLabel("This System developed by,");
		//l2.setFont(new Font("Times New Roman",Font.BOLD,20));
		l2.setBounds(100,150,600,40);
		jf.add(l2);

		l3 = new JLabel("Ajay Milind Gandhi");
		l3.setFont(new Font("Skia",Font.BOLD,18));
		l3.setBounds(250,200,400,40);l3.setForeground(Color.white);
		jf.add(l3);

		l3 = new JLabel("Mayuri Yashwant Nikam");
		l3.setFont(new Font("Skia",Font.BOLD,18));
		l3.setBounds(450,200,400,40);l3.setForeground(Color.white);
		jf.add(l3);

		l4 = new JLabel("Under the guidance of Mrs.Shubhangi Mathe Madam.");
		l4.setFont(new Font("Skia",Font.BOLD,18));l4.setForeground(Color.white);
		l4.setBounds(225,250,800,40);
		jf.add(l4);

		l5 = new JLabel("In this system we can add details of Donor,Receptionist,Hospital.");
		//l5.setFont(new Font("Times New Roman",Font.BOLD,20));
		l5.setBounds(100,300,800,40);
		jf.add(l5);

		l6 = new JLabel("We can also upadte,delete & search the existing details.");
		//l6.setFont(new Font("Times New Roman",Font.BOLD,20));
		l6.setBounds(100,350,800,40);
		jf.add(l6);

		l7 = new JLabel("It is helpfull for donated blood details and other detail related to blood bank.");
		//l7.setFont(new Font("Times New Roman",Font.BOLD,20));
		l7.setBounds(100,400,800,40);
		jf.add(l7);

        jf.setTitle("About System");
		jf.setSize(900,700);
		jf.setLocation(20,20);
		jf.setResizable(false);
		jf.getContentPane().setBackground(Color.red);
		jf.setVisible(true);

	}

	public static void main(String a[])
	{
          new Aboutus();

	}
}
