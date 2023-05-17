package Attendance;

public class Attend {
	
	MySqlDemo SQL;
	int NumberofAttend;
	Course c1;
	Student s1;
	
	public Attend(Student Student1,Course Course1,MySqlDemo SS) {
		
		//this.c1.setCourseId(Course1.getCourseId());
		this.c1= Course1;
		this.s1=Student1;
		this.SQL=SS;
		}
	
	
	
		void AddAttend(int Attend) {
		if (Attend > 0) {
			NumberofAttend += Attend; 
		}
		else { System.out.print("Enter correct number..");}
		
		SQL.AddAttendance(Attend, s1, c1);
		
		System.out.print("Student :" + s1.getFirstName() + "is stored as attended");
		}



	

}
	
