package Module3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Assessment1
{
	JFrame frame;
	private JLabel lbl1,lbl2,lbl3,lbl4,lbl5;
	private JTextField tf1,tf2,tf3,tf4,tf5;
	private JButton btninsert,btnupdate,btndelete,btnsearch;
	
	private Connection connection;
	
	
	public Assessment1()
	{
		frame = new JFrame("My Swing Example");
		
		lbl1 = new JLabel("ID");
		lbl1.setBounds(50, 30, 200, 12);
		
		tf1 = new JTextField();
		tf1.setBounds(200, 30, 200, 20);
		
		lbl2 = new JLabel("FIRST NAME");
		lbl2.setBounds(50, 60, 200, 12);
		
		tf2 = new JTextField();
		tf2.setBounds(200, 60, 200, 20);
		
		lbl3 = new JLabel("LAST NAME");
		lbl3.setBounds(50, 90, 200, 12);
		
		tf3 = new JTextField();
		tf3.setBounds(200, 90, 200, 20);
		
		lbl4 = new JLabel("EMAIL");
		lbl4.setBounds(50, 120, 200, 12);
		
		tf4 = new JTextField();
		tf4.setBounds(200, 120, 200, 20);
		
		lbl5 = new JLabel("MOBILE");
		lbl5.setBounds(50, 150, 200, 12);
		
		tf5 = new JTextField();
		tf5.setBounds(200, 150, 200, 20);
		
		btninsert = new JButton("INSERT");
		btninsert.setBounds(50, 200, 150, 20);
		
		btnsearch = new JButton("SEARCH");
		btnsearch.setBounds(250, 200, 150, 20);
		
		btnupdate = new JButton("UPDATE");
		btnupdate.setBounds(50, 230, 150, 20);
		
		btndelete = new JButton("DELETE");
		btndelete.setBounds(250, 230, 150, 20);
		
		
		frame.add(lbl1);
		frame.add(lbl2);
		frame.add(lbl3);
		frame.add(lbl4);
		frame.add(lbl5);
		frame.add(tf1);
		frame.add(tf2);
		frame.add(tf3);
		frame.add(tf4);
		frame.add(tf5);
		frame.add(btninsert);
		frame.add(btnsearch);
		frame.add(btnupdate);
		frame.add(btndelete);
		frame.setSize(500, 400);
		frame.setLayout(null);
		frame.setVisible(true);
		 
		btninsert.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				insertdata();				
			}
		});	
		
		btnupdate.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				updatedata();
			}
		});
		
		btnsearch.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				searchdata();
			}
		});
		
		btndelete.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				deletedata();
			}
		});
		
		connectdatabase();
	}
	
	private void connectdatabase()
	{
		try 
		{
			
			String db = "studentdb";
			String host = "jdbc:mysql://localhost:3306/";
			String url = host + db;

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,"root","");
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertdata()
	{
		try 
		{
			String fname = tf2.getText().toString();
			String lname = tf3.getText().toString();
			String email = tf4.getText().toString();
			String mobile = tf5.getText().toString();
		
			String sql = "insert into student values (null,'"+fname+"','"+lname+"','"+email+"','"+mobile+"')";
			Statement stmt = connection.createStatement();
			int data = stmt.executeUpdate(sql);
			
			String messageinsert = "Data Insert Successfully..";
			JOptionPane.showMessageDialog(btninsert, messageinsert);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void searchdata()
	{
		try {
            String sql = "SELECT * FROM student WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(tf1.getText()));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                tf2.setText(rs.getString("fname"));
                tf3.setText(rs.getString("lname"));
                tf4.setText(rs.getString("email"));
                tf5.setText(rs.getString("mobile"));   
            }  
            else 
            {
            	String messagesearch = "ID NOT FOUND.....";
    			JOptionPane.showMessageDialog(btninsert, messagesearch);
            }
        } 
		catch (SQLException e)
		{
            e.printStackTrace();
        }
	}
	
	public void updatedata()
	{
		try 
		{
			String sql = "update student set fname = ?,lname = ?,email = ?,mobile = ? where id = ?";
			
			PreparedStatement pstmt= connection.prepareStatement(sql);
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, tf2.getText());
			pstmt.setString(2, tf3.getText());
			pstmt.setString(3, tf4.getText());
			pstmt.setString(4, tf5.getText());
			pstmt.setInt(5, Integer.parseInt(tf1.getText()));
			pstmt.executeUpdate();
			
			String messageupdate = "Data Update Successfully..";
			JOptionPane.showMessageDialog(btninsert, messageupdate);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void deletedata()
	{
		try 
		{
			String sql = "delete from student where id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(tf1.getText()));
			pstmt.executeUpdate();
			
			String messagedelete = "Data Insert Successfully..";
			JOptionPane.showMessageDialog(btninsert, messagedelete);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) 
	{
		new Assessment1();
	}
}
