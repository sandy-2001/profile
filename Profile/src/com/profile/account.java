package com.profile;
import java.util.*;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Date;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.profile.data.*;
public class account extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		String uname=req.getParameter("name");
		String gname =req.getParameter("father");
	    Date date = Date.valueOf(req.getParameter("dob"));
	    String num = req.getParameter("phone");
	    String mail = req.getParameter("mail");
	    String pass = req.getParameter("pass");
	    String pass2 = req.getParameter("pass2");
	if(pass.equals(pass2))
	{
		try {
		    String query = "insert into profile values('"+uname+"', '"+gname+"', '"+date+"', '"+num+"', '"+mail+"', '"+pass+"','"+pass2+"')";

			Connection con = data.Con();
			Statement st = con.createStatement();
			int i=st.executeUpdate(query);
			PrintWriter out = res.getWriter();
			out.println("SUCCESSFULLY CREATED ACCOUNT");
			st.close();
			con.close();
		}
		catch(Exception e )
		{
			System.out.println(e);
		}
	}
	else {
		System.out.println("Something went Wrong");
	}
	}
}
