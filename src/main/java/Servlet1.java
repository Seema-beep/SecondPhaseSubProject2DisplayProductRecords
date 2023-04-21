

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Servlet1() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		out.print("<h1>Display the Record</h1>");
		out.print("<table border='1'><tr><th>Id</th><th>Name</th><th>Description</th><th>Price</th></tr>");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myproduct","root","root");
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from product where id="+id+"");
			while(rs.next())
			{
				out.print("<tr><td>");
				out.print(rs.getInt(1));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(2));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(3));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(4));
				out.print("</td>");
				out.print("</tr>");
				
			}
			
		}catch(Exception p) {
			System.out.println(p);
		}
		out.print("</table>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
