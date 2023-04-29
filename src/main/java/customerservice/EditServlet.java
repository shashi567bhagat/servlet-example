package customerservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

@WebServlet("/EditServlet")
public class EditServlet  extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("id")) ;
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
	
		
		Connection con=null;
		Statement st=null;
		String select=("select * from save_employee WHERE emp_id = "+empId);
	    Emp emp=new Emp();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","Shashi75874@");
			 st=con.createStatement();
			 ResultSet rs= st.executeQuery(select);
			
		
			 
			 while(rs.next())
			 {				 
				 out.print("<!DOCTYPE html>\r\n"
				 		+ "<html>\r\n"
				 		+ "<head>\r\n"
				 		+ "<meta charset=\"ISO-8859-1\">\r\n"
				 		+ "<title>update</title>\r\n"
				 		+ "</head>\r\n"
				 		+ "<body>\r\n"
				 		+ "\r\n"
				 		+ "    <h1>Update Employee</h1>\r\n"
				 		+ "<form action='update' method='post'>\r\n"
				 		+ "    <table>\r\n"
				 		+ "<tr>\r\n"
				 		+ "<td>\r\n"
				 		+ "    <input type='hidden' name='id' value='"+rs.getInt("emp_id")+"' />\r\n"
				 		+ "</td>\r\n"
				 		+ "\r\n"
				 		+ "</tr>\r\n"
				 		+ "   \r\n"
				 		+ "<tr>\r\n"
				 		+ "<td>Name</td>\r\n"
				 		+ "<td> \r\n"
				 		+ "    <input type='text' name='name' value='"+rs.getString("emp_name")+"' />\r\n"
				 		+ "</td>\r\n"
				 		+ "\r\n"
				 		+ "</tr>\r\n"
				 		+ "\r\n"
				 		+ "<tr>\r\n"
				 		+ "<td>Password</td>\r\n"
				 		+ "<td>\r\n"
				 		+ "    <input type='password' name='password' value='"+rs.getString("emp_pass")+"' />\r\n"
				 		+ "</td>\r\n"
				 		+ "\r\n"
				 		+ "</tr>\r\n"
				 		+ "\r\n"
				 		+ "<tr>\r\n"
				 		+ "    <td>Email</td>\r\n"
				 		+ "    <td><input type='email' name='email' value='"+rs.getString("emp_email")+"' /></td>\r\n"
				 		+ "</tr>\r\n"
				 		+ "\r\n"
				 		+ "\r\n"
				 		+ "<tr>\r\n"
				 		+ "<td>\r\n"
				 		+ "    country\r\n"
				 		+ "</td>\r\n"
				 		+ "<td>\r\n"
				 		+ "    <input type='text' name='country' value='"+rs.getString("emp_country")+"' />\r\n"
				 		+ "</td>\r\n"
				 		+ "</tr>\r\n"
				 		+ "\r\n"
				 		+ "<tr>\r\n"
				 		+ "  <td>\r\n"
				 		+ "    <input type='submit' value='Edit & Save ' />\r\n"
				 		+ "  </td>  \r\n"
				 		+ "</tr>\r\n"
				 		+ "\r\n"
				 		+ "\r\n"
				 		+ "</table>\r\n"
				 		+ "</form>\r\n"
				 		+ "</body>\r\n"
				 		+ "</html>");
					 
			 }
				
			con.close();	 
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
