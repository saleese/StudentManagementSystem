package student;

import java.util.Scanner;

public abstract class TeenageStudent extends Student {
	
	public TeenageStudent(StudentKind kind) {
		super(kind);
	}

	@Override
	public abstract void getUserInput(Scanner input) ;

	@Override
	public void printInfo() {
		String skind = getKindString();
		System.out.println("kind:" + skind + " name:" + name + " id:" + id + " email:" + email + " phone:" + phone);
	}
	
	public void setStudentEmailwithYN(Scanner input) {
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
	}

}
