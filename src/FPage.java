import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class FPage extends JFrame implements ActionListener
{
	JFrame jf;
	JButton b1,b2;
	JLabel img;
	Font f;

	FPage()
	{
		jf=new JFrame();
		f=new Font("Times New Roman",Font.BOLD,20);
		jf.setLayout(null);

		JLabel img=new JLabel(new ImageIcon("image//front.jpeg"));
		img.setBounds(0,0,1000,500);
		jf.add(img);
		//jf.setContentPane(new JLabel(new ImageIcon("image//front.jpeg")));
		//jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

		b1 = new JButton("ADMIN");
		b1.setBounds(380,400,100,35);
		jf.add(b1);
		b1.addActionListener(this);

		b2 = new JButton("USER");
		b2.setBounds(520,400,100,35);
		jf.add(b2);
		b2.addActionListener(this);
		jf.getContentPane().setBackground(Color.red);
		jf.setSize(1000,500);
		jf.setVisible(true);
		jf.setResizable(false);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			jf.setVisible(false);
			new login1();
		}
		if(ae.getSource()==b2)
		{
			jf.setVisible(false);
			new NewDonor();
		}
	}
	public static void main(String args[])
	{
		new FPage();
	}
}
