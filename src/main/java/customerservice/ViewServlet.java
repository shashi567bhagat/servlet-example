package customerservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;


/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4901000777515947907L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post view");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection con = null;

		Statement st = null;
		
		
		System.out.println("-------------------------mysql connection started-----------------------");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root","Shashi75874@");

			st = con.createStatement();

			String select = "select * from save_employee";

			ResultSet rs = st.executeQuery(select);
			
			
			
		
			Emp emp = new Emp();

			
			
			
			out.println("<a href='index.html'>Add New Employee</a>");
			out.println("<h1>Employees List</h1>");
			
			
			
			out.print("<table border='1' width='100%'");
			out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
			
			
			while (rs.next()) {
			
				emp.setId(rs.getInt("emp_id"));
				emp.setName(rs.getString("emp_name"));
				emp.setPassword(rs.getString("emp_pass"));
				emp.setEmail(rs.getString("emp_email"));
				emp.setCountry(rs.getString("emp_country"));
				//list.add(emp1);
				
				
				

				out.print("<tr><td>" + emp.getId() + "</td><td>" + emp.getName() + "</td><td>" +emp.getPassword() + "</td><td>" + emp.getEmail() + "</td><td>" + emp.getCountry() + "</td><td><a href='EditServlet?id=" + emp.getId() + "'>edit</a></td>"
						+ "  <td><a href='DeleteServlet?id=" + emp.getId() + "'>delete</a></td></tr>");
			
			}
			
		
			
			out.print("</table>");
			

			con.close();
		}		
			catch (Exception e)
			{
				
			System.out.println(e);
			
		   }
	
		out.close();
		

	}
	
}


