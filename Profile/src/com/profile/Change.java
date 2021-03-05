package com.profile;

import java.io.PrintWriter;
import java.sql.Connection;
import com.profile.data;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Change extends HttpServlet {
              public void service(HttpServletRequest req, HttpServletResponse res)
              {
            	 
            	  String mail =req.getParameter("mail");
            	  Date dob =Date.valueOf(req.getParameter("dob"));
            	  String pass1=req.getParameter("pass1");
            	  String pass2 =req.getParameter("pass2");
            	  try {
            		  PrintWriter out =  res.getWriter();
            		  if(pass1.equals(pass2)) {
                		  //out.println("yes");
            			  Connection con = data.Con();
            			  String query1 = "select * from profile where email ='"+mail+"' and dob ='"+dob+"'"; 
            			  String query2 = " update profile set pass ='"+pass1+"', dpass='"+pass2+"' where email='"+mail+"'";
            			  Statement st = con.createStatement();
            			  ResultSet rs = st.executeQuery(query1);
            			  if(rs.next())
            			  {
            				  st.executeUpdate(query2);
            				  out.println("UPDATED");
            			  }
            			  st.close();
            			  con.close();
                	  }
                	  else {
                		  out.println("NO");
                	  }
            	  }
            	  catch(Exception e)
            	  {
            		 e.printStackTrace();
            	  }
            	  
            	  
              }
}