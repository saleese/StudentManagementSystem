package student;

import java.util.Scanner;

public class HighSchoolStudent extends TeenageStudent {
	
	public HighSchoolStudent(StudentKind kind) {
		super(kind);
	}
	

	public void getUserInput(Scanner input) {
		setStudentID(input);
		setStudentName(input);
		setStudentEmailwithYN(input);
		setStudentPhone(input);
	}

}
