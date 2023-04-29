
package customerservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

@WebServlet("/save")

public class Customerinfo extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("hello world");

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		HashMap<String, String> hm = new HashMap<>();
	
		String Username = req.getParameter("username");
		String Password = req.getParameter("password");

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "Shashi75874@");

			st = con.createStatement();

			String select = "select cusName,cusPassword from customer_details";
			
			rs = st.executeQuery(select);

			while (rs.next()) 
			{
				hm.put(rs.getString(1), rs.getString(2));
			}

			System.out.println(hm);

		

	
		if (hm.get(Username).equals(Password)) {
			// HttpSession session=req.getSession(true);
			// session.setAttribute("Username","name");

			out.print("Login Successfully");
			RequestDispatcher rd = req.getRequestDispatcher("home.html");
			rd.forward(req, res);

		}

		else {
			out.print("Invalid Userid & Password ,  Try Again !!");
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
		}

		con.close();
	}
     	catch (Exception e) 
		{
			System.out.println(e);
		}

		
	}
}


