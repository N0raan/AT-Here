package Attendance;
import java.sql.*;

public class MySqlDemo {

    private Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/Attendance"; // Replace "mydatabase" with your database name
    private static String username = "root"; // Replace with your MySQL username
    private static String password = "P@$$w0rd"; // Replace with your MySQL password

    public MySqlDemo() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddAttendance(int Attend, Student S1, Course C1) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Attend SET NumberofAttend = NumberofAttend + ? WHERE StudentId = ? AND CourseId = ?");
            statement.setInt(1, Attend);
            statement.setString(2, S1.getStudentId());
            statement.setString(3, C1.getCourseId());
            statement.executeUpdate();
            System.out.println("Attendance updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    

        public static void retrieveStudentData(String StudentId) {
            Connection conn = null;
            Statement stmt = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");

                conn = DriverManager.getConnection(url, username, password);

                stmt = conn.createStatement();
                String sql = "SELECT * FROM Student WHERE StudentId = '" + StudentId + "'";
                ResultSet rs = stmt.executeQuery(sql);

                while(rs.next()){
                    int StudentId1  = rs.getInt("StudentId");
                    String FirstName = rs.getString("FirstName");
                    String LastName = rs.getString("LastName");
                    String GroupName = rs.getString("GroupName");

                    System.out.print("StudentId: " + StudentId1);
                    System.out.print(", FirstName: " + FirstName);
                    System.out.print(", LasName: " + LastName);
                    System.out.println(", Group: " + GroupName);
                }

                rs.close();
                stmt.close();
                conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(stmt!=null) stmt.close();
                } catch(SQLException se2) {
                }
                try {
                    if(conn!=null) conn.close();
                } catch(SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }








































/*public class MySqlDemo {
	
	private static final String url = "jdbc:mysql://localhost:3306/Attendance";
    private static final String user = "root"; 
    private static final String password = "P@$$w0rd"; 
    private static  Connection conn;

    public MySqlDemo() {
        try {
            conn = DriverManager.getConnection(url, user, password);
         
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	    private String StudentId;
	    private String CourseId;

	    public void AddAttend(int Attend,String StudentId , String CourseId) {

	        
	    	try {
	    		if (conn == null) {
	    			return;
	    		}

	            // Retrieve the current value of the "NumberofAttend" column for the record with the specified ID
	    		statement = connection.createStatement();

	            ResultSet resultSet = statement.statement.executeQuery("SELECT NumberofAttend FROM mytable WHERE StudentId = " + this.StudentId + "AND CourseId =" + this.CourseId);
	            resultSet.next();
	            int currentValue = resultSet.getInt("NumberofAttend");

	            // Increment the attendance by the specified amount
	            int newValue = currentValue + Attend;

	            // Update the "NumberofAttend" column for the record with the new value
	            statement.executeUpdate("UPDATE mytable SET NumberofAttend = " + newValue + " WHERE id = " + this.StudentId + "AND CourseId =" + this.CourseId);
	            System.out.println("Record updated successfully!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	} */




