package Attendance;

public class Main {

	public static void main(String[] args) {
		
		Course Configuration =new Course("103","Configuration","Dr Youssef Senousy");
		Student John =new Student("John","Doe","3","1");
		MySqlDemo SQL = new MySqlDemo();
		
		Attend X = new Attend(John,Configuration,SQL);
		X.AddAttend(1);
		
		John.RetrieveData("1");
	}

}
