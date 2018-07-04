package project;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Home extends JFrame implements ActionListener
{
	 JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
	 JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
	 JFrame f1,f2,f3,f4,f5;
	 int d1,d2;
	 String s1;
	 
	 static Connection conn;
	 static PreparedStatement pst;	 
	
	Home()
	{		
		setSize(800, 500);
		setLayout(null);
		b1=new JButton("insert_data");
		b1.setBounds(100, 100, 150, 100);
		add(b1);
		
		ImageIcon ii=new ImageIcon("E:\\image\\best.jpg");
		b2=new JButton(ii);
		b2.setBounds(350, 100, 150, 100);
		add(b2);
		
		b3=new JButton("delete_record");
		b3.setBounds(100, 250, 150, 100);
		add(b3);
		
		b4=new JButton("find_data");
		b4.setBounds(350, 250, 150, 100);
		add(b4);
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
				
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
			Object o=e.getSource();
			if(o==b1)
			{
				//JOptionPane.showMessageDialog(this, "Hello viru");
				f1=new JFrame("insert data");
				f1.setSize(500, 600);
				f1.setLocation(400,0);
				f1.setLayout(null);
				
				JLabel l1=new JLabel("Employee Id:");
				l1.setBounds(50, 100, 100, 30);
				f1.add(l1);
				tf1=new JTextField();
				tf1.setBounds(150, 100, 150, 30);
				f1.add(tf1);
				
				JLabel l2=new JLabel("Employee Name:");
				l2.setBounds(50, 150, 100,30);
				f1.add(l2);
				tf2=new JTextField();
				tf2.setBounds(150, 150, 150, 30);
				f1.add(tf2);
				
				JLabel l3=new JLabel("Employee Salary:");
				l3.setBounds(50, 200, 100, 30);
				f1.add(l3);
				tf3=new JTextField();
				tf3.setBounds(150, 200, 150, 30);
				f1.add(tf3);
										
				b5=new JButton("Add data");
				b5.setBounds(170, 270, 100, 35);
				f1.add(b5);
				
				b5.addActionListener(this);
								 
				f1.setVisible(true);				
			}
			else if(o==b5)
			{
				try
				{
				pst=conn.prepareStatement("insert into Employee23 values(?,?,?)");
				int tf1Data=Integer.parseInt(tf1.getText());
				String tf2Data=tf2.getText();
				int tf3Data=Integer.parseInt(tf3.getText());
				pst.setInt(1, tf1Data);
				pst.setString(2, tf2Data);
				pst.setInt(3, tf3Data);
				int r=pst.executeUpdate();
				JOptionPane.showMessageDialog(this, "Your data is Successfully inserted....");
				f1.setVisible(false);
				
				}
				catch(SQLException e1)
				{
					System.out.println("Exception is :"+e1);
				}
			}
			else if(o==b2)
			{
				f5=new JFrame("update data");
				f5.setSize(500, 600);
				f5.setLocation(400,0);
				f5.setLayout(null);
				
				JLabel l22=new JLabel("Id  ");
				l22.setBounds(50, 100, 100, 35);
				f5.add(l22);
				
				tf6=new JTextField();
				tf6.setBounds(150, 100, 200, 35);
				f5.add(tf6);
				
				JLabel l21=new JLabel("Name");
				l21.setBounds(50, 200, 100, 35);
				f5.add(l21);
				
				tf7=new JTextField();
				tf7.setBounds(150, 200, 200, 35);
				f5.add(tf7);
				
				b9=new JButton("Update...");
				b9.setBounds(80, 250, 100, 35);
				f5.add(b9);
				
				b9.addActionListener(this);
				
				JLabel l23=new JLabel("Salary...");
				l23.setBounds(50, 350, 100, 35);
				f5.add(l23);				
				tf8=new JTextField();
				tf8.setBounds(150, 400, 200, 35);
				f5.add(tf8);
				
				b10=new JButton("Update...");
				b10.setBounds(80, 450, 100, 35);
				f5.add(b10);
				b10.addActionListener(this);
				f5.setVisible(true);
				
				
			}
			else if(o==b9)
			{
				try
				{
				pst=conn.prepareStatement("update Employee23 set name=? where id=?");
				pst.setString(1, tf7.getText());
				pst.setInt(2, Integer.parseInt(tf6.getText()));
				pst.executeUpdate();
					
				JOptionPane.showMessageDialog(this, "Successfully Updated.....");
				f5.setVisible(false);
				}
				catch(SQLException e5)
				{
					System.out.println(e5);
				}
			}
			else if(o==b10)
			{
				try
				{
				pst=conn.prepareStatement("update Employee23 set salary=? where id=?");
				pst.setString(1, tf8.getText());
				pst.setInt(2, Integer.parseInt(tf6.getText()));
				pst.executeUpdate();
					
				JOptionPane.showMessageDialog(this, "Successfully Updated.....");
				f5.setVisible(false);
				}
				catch(SQLException e5)
				{
					System.out.println(e5);
				}
			}
			else if(o==b3)
			{
				f2=new JFrame("insert data");
				f2.setSize(500, 400);
				f2.setLocation(400,0);
				f2.setLayout(null);
								
				JLabel l1=new JLabel("Employee Id:");
				l1.setBounds(50, 100, 80, 30);
				f2.add(l1);
				tf4=new JTextField();
				tf4.setBounds(150, 100, 150, 30);
				f2.add(tf4);
				
				b6=new JButton("Delete");
				b6.setBounds(100, 150, 100, 35);
				f2.add(b6);
								
				b6.addActionListener(this);
				f2.setVisible(true);
			}
			if(o==b6)
			{
				try
				{
					pst=conn.prepareStatement("delete from Employee23 where id=?");
					JOptionPane.showMessageDialog(this, "Hello viru");
					int tf4Data=Integer.parseInt(tf4.getText());
					pst.setInt(1, tf4Data);
					pst.executeQuery();
					
					f2.setVisible(false);
				}
				catch(SQLException e3)
				{
					System.out.println(e3);
				}
				
			}
			if(o==b4) 
			{
				f3=new JFrame("Find Data");
				f3.setSize(500, 400);
				f3.setLocation(400,0);
				f3.setLayout(null);
								
				JLabel l1=new JLabel("Employee Id:");
				l1.setBounds(50, 100, 80, 30);
				f3.add(l1);
				tf5=new JTextField();
				tf5.setBounds(150, 100, 150, 30);
				f3.add(tf5);
				
				b7=new JButton("Search...");
				b7.setBounds(100, 150, 100, 35);
				f3.add(b7);
				
				b7.addActionListener(this);
				f3.setVisible(true);
			}
			if(o==b7)
			{
				try
				{
				pst=conn.prepareStatement("select * from Employee23 where id=?");
				int tf5Data=Integer.parseInt(tf5.getText());
				pst.setInt(1, tf5Data);
				ResultSet rs=pst.executeQuery();
				rs.next();
				s1=rs.getString(2);
				d1=rs.getInt(3);
				f3.setVisible(false);
				
				f4=new JFrame("Show Record");
				f4.setSize(500, 400);
				f4.setLocation(400,0);
				f4.setLayout(null);
				
				JLabel l11=new JLabel("id is    :   "+tf5.getText());
				JLabel l12=new JLabel("Name is  :   "+s1);
				JLabel l13=new JLabel("Salary is:   "+d1);
				l11.setBounds(50, 50, 200, 35);
				l12.setBounds(50, 100, 200, 35);
				l13.setBounds(50, 150, 200, 35);
				f4.add(l11);
				f4.add(l12);
				f4.add(l13);
				f4.setVisible(true);
				
				b8=new JButton("Ok......");
				b8.setBounds(80, 200, 100, 35);
				f4.add(b8);
				
				b8.addActionListener(this);
								
				}
				catch(SQLException e4)
				{
					System.out.println(e4);					
				}
			}
			else if(o==b8)
			{
				f4.setVisible(false);
			}
	}
	
	public static void main(String[] args) throws ClassNotFoundException,SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","virubhai@");
		
		
		Home h= new Home();
		
	}

}
