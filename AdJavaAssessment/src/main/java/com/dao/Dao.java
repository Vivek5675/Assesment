package com.dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import com.model.ProductModel;

public class Dao
{
	public static Connection getconnect()
	{
		Connection con = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adjavaassesment","root","");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
		return con;
		
	}
	
	public static int savedata(ProductModel m)
	{
		int status = 0;
		
		Connection con = Dao.getconnect();
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("insert into product (name,category,model,price,des,image) values (?,?,?,?,?,?)");
			ps.setString(1, m.getName());
			ps.setString(2, m.getCategory());
			ps.setString(3, m.getModel());
			ps.setString(4, m.getPrice());
			ps.setString(5, m.getDes());
			ps.setString(6, m.getImage());
			
		
			status = ps.executeUpdate();
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	
	}
	
	public static List<ProductModel>viewdata()
	{
		Connection con = Dao.getconnect();
		List<ProductModel>list = new ArrayList<ProductModel>();
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from product");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String category = rs.getString(3);
				String model = rs.getString(4);
				String price = rs.getString(5);
				String des = rs.getString(6);
//				String image = rs.getString(7);
				
				byte[] imgData = rs.getBytes(7);
				String encode = Base64.getEncoder().encodeToString(imgData);
				
				ProductModel m = new ProductModel();
				m.setId(id);
				m.setName(name);
				m.setCategory(category);
				m.setModel(model);
				m.setPrice(price);
				m.setDes(des);
				m.setImage(encode);
				
				list.add(m);
			}
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	
	public static int delete(int id)
	{
		Connection con = Dao.getconnect();
		int status = 0;
		try
		{
			PreparedStatement ps = con.prepareStatement("delete from product where id=?");
			ps.setInt(1,id);
			status = ps.executeUpdate();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	public static ProductModel Edit(int id)
	{
		Connection con = Dao.getconnect();
		
		int status = 0;
		ProductModel m = null;
		
		PreparedStatement ps;
		try
		{
			ps = con.prepareStatement("select * from product where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				int id2 = rs.getInt(1);
				String name = rs.getString(2);
				String category = rs.getString(3);
				String model = rs.getString(4);
				String price = rs.getString(5);
				String des = rs.getString(6);
				//String image = rs.getString(7);
				
				byte[] imgData = rs.getBytes(7);
				String encode = Base64.getEncoder().encodeToString(imgData);
				
				m = new ProductModel();
				m.setId(id2);
				m.setName(name);
				m.setCategory(category);
				m.setModel(model);
				m.setPrice(price);
				m.setDes(des);
				m.setImage(encode);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return m;
		
	}
	
	public static int pupdate(ProductModel m)
	{
		Connection con = Dao.getconnect();
		
		int status = 0;
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("update product set name=?,category=?,model=?,price=?,des=?,image=? where id =?");
			ps.setString(1, m.getName());
			ps.setString(2, m.getCategory());
			ps.setString(3, m.getModel());
			ps.setString(4, m.getPrice());
			ps.setString(5, m.getDes());
			ps.setString(6, m.getImage());
			ps.setInt(7, m.getId());
			
			status = ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		return status;
		
	}

}
