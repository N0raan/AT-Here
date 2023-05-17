package Attendance;

public class Course {
	
	private String CourseId;
	private String NameCourse;
	private String ProfName;
	
	
	
	public Course(String courseId, String nameCourse, String profName) {
		super();
		CourseId = courseId;
		NameCourse = nameCourse;
		ProfName = profName;
	}
	
	public String getCourseId() {
		return CourseId;
	}
	public void setCourseId(String courseId) {
		CourseId = courseId;
	}
	public String getNameCourse() {
		return NameCourse;
	}
	public void setNameCourse(String nameCourse) {
		NameCourse = nameCourse;
	}
	public String getProfName() {
		return ProfName;
	}
	public void setProfName(String profName) {
		ProfName = profName;
	}
	
	
	
	

}
