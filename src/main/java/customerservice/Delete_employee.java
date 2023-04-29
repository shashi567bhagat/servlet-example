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

@WebServlet("/DeleteServlet")
public class Delete_employee extends HttpServlet{

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int empid = Integer.parseInt(request.getParameter("id"));
		PrintWriter out= response.getWriter();
		Connection con = null;
		Statement st=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "Shashi75874@");
			st = con.createStatement();

			String str = "DELETE FROM save_employee WHERE emp_id = " + empid;
	
			int rs = st.executeUpdate(str);
			
			if (rs > 0) {
			
				out.print("Delete data successfully");
			} else {
				System.out.println("not deleted ");
			}
			System.out.println(rs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}	
		
		
		
		
	}
	
	
