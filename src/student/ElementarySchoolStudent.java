package student;

import java.util.Scanner;

import exception.EmailFormatException;

public class ElementarySchoolStudent extends TeenageStudent {
	
	protected String parentEmail;
	protected String parentPhone;
	
	public ElementarySchoolStudent(StudentKind kind) {
		super(kind);
	}
		
	public void getUserInput(Scanner input) {
		setStudentID(input);
		setStudentName(input);
		setStudentEmailwithYN(input);
		setParentEmailwithYN(input);
		setStudentPhone(input);
	}
	
	public void setParentEmailwithYN(Scanner input) {
		char answer = 'x';
		while (answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N'){
			System.out.print("Do you have a parent's email address? (Y/N)");
			answer = input.next().charAt(0);
			try {
				if (answer == 'y' || answer == 'Y') {
					setStudentEmail(input);
					break;
				}
				else if (answer == 'n' || answer == 'N') {
					this.setEmail("");
					break;
				}
				else {
				}
			}
			catch(EmailFormatException e) {
				System.out.println("Incorrect Email Format. put the e-mail address that contains @");
			}
		}
	}
	
	public void printInfo() {
		String skind = getKindString();
		System.out.println("kind:" + skind + " name:" + name + " id:" + id + " email:" + email + " phone:" + phone + "parent's email:" + email + "parent's phone:" + phone);
	}
	


}
