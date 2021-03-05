package com.profile;
import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import com.profile.data;
 public class Check extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		String email1= req.getParameter("email");
		String  pass1=req.getParameter("pass");
		PrintWriter out = res.getWriter();
		String query ="Select * from profile where email='"+email1+"' and pass= '"+pass1+"' " ;
		Connection Kon = null;
		try{
			Kon=data.Con();
		
			
		 Statement st = Kon.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next())
			out.println("LOGGED IN SUCCESSFULLY");
			else 
				out.println("SOMETHING WENT WRONG!!");
			st.close();
			Kon.close();
		}
		catch(Exception e)
		{
			out.println("Something went wrong!! Check Again");
		}
		
		

		
	}
}
