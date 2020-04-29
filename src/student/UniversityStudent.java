package student;

import java.util.Scanner;

public class UniversityStudent extends Student  {
	
	public UniversityStudent(StudentKind kind) {
		super(kind);
	}
	
	public void getUserInput(Scanner input) {
		setStudentID(input);
		setStudentName(input);
		setStudentEmail(input);
		setStudentPhone(input);
	}
	
	public void printInfo() {
		String skind = getKindString();
		System.out.println("kind:" + skind + " name:" + name + " id:" + id + " email:" + email + " phone:" + phone);
	}

}
