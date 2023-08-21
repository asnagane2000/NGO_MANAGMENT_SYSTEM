package NGOS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/nlogin")
@MultipartConfig
public class login extends HttpServlet{
	public static	Connection con=null;
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ngo1","root","sql@123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email=req.getParameter("nemail");

		String pass=req.getParameter("npass");
		PreparedStatement ps=null;
		PrintWriter pw=resp.getWriter();
		String q="select * from ngos where nemail=? and npass=?";
		RequestDispatcher rd=req.getRequestDispatcher("/Displayfileforadmin.jsp");
		ResultSet rs=null;
		try {
			ps=con.prepareStatement(q);
			
			ps.setString(1,email);
		
			ps.setString(2,pass);
			
			rs=ps.executeQuery();
			if(rs.next())
			{
				pw.print("<h1> welcome  "+rs.getString("nname")+" </h1>");
				
				rd.include(req, resp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
