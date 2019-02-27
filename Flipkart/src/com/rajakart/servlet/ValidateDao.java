package com.rajakart.servlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ValidateDao {
	
	public boolean validate(String username,String password)  throws SQLException 
	{
		
		Connection con =ConnectionFactory.getConnection();
	
		
			 Statement s=con.createStatement();
	           String sql = "SELECT uname,password FROM rajacart";
	            ResultSet rs = s.executeQuery(sql);
	            System.out.println("Line 22");
				while(rs.next()){
				String dbName= rs.getString("uname");
				String dbpwd = rs.getString("password");
				
            if(username.equals(dbName)&& password.equals(dbpwd))
            {
            	
            	return true;
            }
           
				}
				return false;
				
	
}
	
}


