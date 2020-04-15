package student;

import java.util.Scanner;

public class ElementarySchoolStudent extends Student {
	
	protected String parentEmail;
	protected String parentPhone;
	
	public ElementarySchoolStudent(StudentKind kind) {
		super(kind);
	}
	
	public void getUserInput(Scanner input) {
		System.out.print("Student ID:");
		int id = input.nextInt();
		this.setId(id);

		System.out.print("Student name:");
		String name = input.next();
		this.setName(name);

		char answer = 'x';
		while (answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N')
		{
			System.out.print("Do you have an email address? (Y/N)");
			answer = input.next().charAt(0);
			if (answer == 'y' || answer == 'Y') {
				System.out.print("Email address:");
				String email = input.next();
				this.setEmail(email);
				break;
			}
			else if (answer == 'n' || answer == 'N') {
				this.setEmail("");
				break;
			}
			else {
			}
		}
		
		answer = 'x';
		while (answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N')
		{
			System.out.print("Do you have a parent's email address? (Y/N)");
			answer = input.next().charAt(0);
			if (answer == 'y' || answer == 'Y') {
				System.out.print("parent's email address:");
				String email = input.next();
				this.setEmail(email);
				break;
			}
			else if (answer == 'n' || answer == 'N') {
				this.setEmail("");
				break;
			}
			else {
			}
		}

		System.out.print("Phone number:");
		String phone = input.next();
		this.setPhone(phone);
	}
	
	public void printInfo() {
		String skind = "none";
		switch(this.kind) {
		case University:
			skind = "Univ.";
			break;
		case HighSchool:
			skind = "High";
			break;
		case MiddleSchool:
			skind = "Middle";
			break;
		case ElementarySchool:
			skind = "Elementary";
			break;
		default:
		}
		System.out.println("kind:" + skind + " name:" + name + " id:" + id + " email:" + email + " phone:" + phone + "parent's email:" + email + "parent's phone:" + phone);
	}

}
