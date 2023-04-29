package customerservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Result;

@WebServlet("/update")
public class UpdateButton extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("id"));

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		PrintWriter out = response.getWriter();

	

		Connection con = null;
		Statement st = null;

		String update = "UPDATE save_employee SET  emp_name='" + name + "',emp_pass='" + password + "',emp_email='"
				+ email + "',emp_country='" + country + "' where emp_id=" + empId;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "Shashi75874@");
			st = con.createStatement();
			int rs = st.executeUpdate(update);
			
			
			if (rs > 0)
			{
				out.print("Update successfully");
			} 
			
			else
			{
				out.print("Not Updated");
			}

			con.close();

			
	
		} catch (Exception e) {

			System.out.println(e);
		}

	}
}
