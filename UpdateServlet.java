package Attendance;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/Attendance"; // Replace "mydatabase" with your database name
    private String username = "root"; // Replace with your MySQL username
    private String password = "P@$$w0rd"; // Replace with your MySQL password


    public UpdateServlet() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		        int Attend = Integer.parseInt(request.getParameter("Attend"));
		        int StudentId = Integer.parseInt(request.getParameter("StudentId"));
		        int CourseId = Integer.parseInt(request.getParameter("CourseId"));

		        try {
		            PreparedStatement statement = connection
		                    .prepareStatement("UPDATE attend SET NumberofAttend = NumberofAttend + ? WHERE StudentId = ? AND CourseId = ?");
		            statement.setInt(1, Attend);
		            statement.setInt(2, StudentId);
		            statement.setInt(3, CourseId);
		            statement.executeUpdate();
		            response.getWriter().println("Attendance updated successfully");
		        } catch (SQLException e) {
		            e.printStackTrace();
		            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while updating attendance");
		        }
		    }
		
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

	}


