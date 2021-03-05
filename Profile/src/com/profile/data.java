package com.profile;
import java.sql.*;
//import java.sql.Driver;


public class data {
	
	public static  Connection Con() throws Exception
	{
		String url ="jdbc:mysql://localhost:3306/xyz";
		String uname ="root";
		String pass ="Sandy#01";
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection(url,uname,pass);
		
		return con;
	}
	
}
