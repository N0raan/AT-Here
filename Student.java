package Attendance;

public class Student {
	
	private String FirstName;
	private String LastName;
	private String GroupName;
	private String StudentId;
	private int NumbOfAttend;
	MySqlDemo SQL;
	
	public Student(String firstName, String lastName, String groupName, String studentId) {
		super();
		FirstName = firstName;
		LastName = lastName;
		GroupName = groupName;
		StudentId = studentId;
	}
	
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getGroupName() {
		return GroupName;
	}
	public void setGroupName(String groupName) {
		GroupName = groupName;
	}
	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
	public int getNumbOfAttend() {
		return NumbOfAttend;
	}
	public void setNumbOfAttend(int numbOfAttend) {
		NumbOfAttend += numbOfAttend;
	}
	
	public void RetrieveData(String StudentId) {
		SQL.retrieveStudentData(StudentId);
	}

}
