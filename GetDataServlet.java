package Attendance;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;

/**
 * Servlet implementation class GetDataServlet
 */
@WebServlet("/GetDataServlet")
public class GetDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	 private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	    private static final String DB_URL = "jdbc:mysql://localhost/Attendace";
	    private static final String USER = "root";
	    private static final String PASS = "P@$$w0rd";
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("rawtypes")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			
			throws ServletException, IOException {

	        // Set response content type
	        response.setContentType("text/html");

	        // Get the student ID parameter from the request
	        String studentId = request.getParameter("studentId");

	        // Create a PrintWriter to write the HTML response
	        PrintWriter out = response.getWriter();
	        out.println("<html><head><title>Student Data</title></head><body>");

	        Connection conn = null;
	        java.sql.Statement stmt = null;
	        try {
	            // Register JDBC driver
	            Class.forName(JDBC_DRIVER);

	            // Open a connection
	            conn = DriverManager.getConnection(DB_URL, USER, PASS);

	            // Execute a query to retrieve the student data
	            stmt = conn.createStatement();
	            String sql = "SELECT * FROM Student WHERE StudentId='" + studentId + "'";
	            ResultSet rs = stmt.executeQuery(sql);

	            // Write the student data to the response
	            if (rs.next()) {
	                int id = rs.getInt("StudentId");
	                String name = rs.getString("StudentName");
	                int age = rs.getInt("Age");
	                String department = rs.getString("Department");

	                out.println("<h2>Student Data:</h2>");
	                out.println("<p>Student ID: " + id + "</p>");
	                out.println("<p>Student Name: " + name + "</p>");
	                out.println("<p>Age: " + age + "</p>");
	                out.println("<p>Department: " + department + "</p>");
	            } else {
	                out.println("<h2>Error:</h2>");
	                out.println("<p>Student with ID " + studentId + " not found.</p>");
	            }

	            // Clean-up environment
	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (SQLException se) {
	            // Handle errors for JDBC
	            se.printStackTrace();
	        } catch (Exception e) {
	            // Handle errors for Class.forName
	            e.printStackTrace();
	        } finally {
	            // Close resources
	            try {
	                if (stmt != null)
	                    stmt.close();
	            } catch (SQLException se2) {
	            }
	            try {
	                if (conn != null)
	                    conn.close();
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }

	        out.println("</body></html>");
	    }
		
		
	}




