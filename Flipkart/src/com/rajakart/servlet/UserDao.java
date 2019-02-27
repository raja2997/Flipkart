package com.rajakart.servlet;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class UserDao {

	public boolean register(String username1,String rpassword ,String mobile,String email)  throws SQLException 
	{
		    Connection con =ConnectionFactory.getConnection();
		    String sql =   "insert into rajacart values (?,?,?,?)";
			  PreparedStatement pst =   con.prepareStatement(sql);
			  pst.setString(1, username1);
			  pst.setString(2, rpassword);
			  pst.setString(3, mobile);
			  pst.setString(4, email);
			  pst.executeUpdate();
			
		return true;
}
	public boolean insert(String username1) throws SQLException, IOException
	{
		 Connection con =ConnectionFactory.getConnection();
		 File file=new File("C:\\Users\\veeambat\\git\\Flipkart\\Flipkart\\WebContent\\img\\banner1.jpg");
			FileInputStream fis=new FileInputStream(file);
			
			PreparedStatement ps=con.prepareStatement("insert into image (name,image) values(?,?)"); 
			ps.setString(1,username1);
			ps.setBinaryStream(2,fis,(int)file.length());
			ps.executeUpdate();

			ps.close();
			fis.close();
			con.close();
		return true;
		
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(new UserDao().insert("Onkar"));
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
