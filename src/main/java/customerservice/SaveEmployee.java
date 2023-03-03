package customerservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;
@WebServlet("/SaveServlet")
public class SaveEmployee extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String name = req.getParameter("name");

		String password = req.getParameter("password");

		String email = req.getParameter("email");

		String country = req.getParameter("country");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root","Shashi75874@");

			String insert = ("insert into save_employee (`emp_name`,`emp_pass`,`emp_email`,`emp_country`) VALUES('"+name+"','" +password+"','"+email+"','" +country+"')");                    
			java.sql.Statement st = con.createStatement();
			int rs = st.executeUpdate(insert);

			 System.out.println(rs);
			if (rs > 0) {
				out.print("Data save");
				
				
			} else 
			{
				out.print("Failed");
			}

		} catch (Exception e)
		{
			System.out.println(e);
		}

	}
}
