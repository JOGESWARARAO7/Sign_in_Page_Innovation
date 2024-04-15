package InnovationGroup;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sign_page")
public class Sign_page extends HttpServlet {
	public String url="jdbc:mysql://localhost:3306/techa-52?user=root&password=12345";
	private static final long serialVersionUID = 1L;
    
    public Sign_page() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String phno=request.getParameter("phno");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String gmail=request.getParameter("email");
		String password=request.getParameter("pw");
		String dob=request.getParameter("dob");
		String adress=request.getParameter("tarea");
		String city=request.getParameter("city");
		String pincode=request.getParameter("pincode");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			PreparedStatement stmt=con.prepareStatement("insert into inovation_restarant.sign_in values(?,?,?,?,?,?,?,?,?)");  
			stmt.setString(1,phno); 
			stmt.setString(2,fname);  
			stmt.setString(3,lname);
			stmt.setString(4,gmail);
			stmt.setString(5,password);
			stmt.setString(6,dob);
			stmt.setString(7,adress);
			stmt.setString(8,city);
			stmt.setString(9,pincode);
			int i=stmt.executeUpdate();  
			 response.sendRedirect("sucess.html");
			con.close();  
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
