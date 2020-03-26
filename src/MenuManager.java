import java.util.Scanner;

public class MenuManager {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StudentManager studentManager = new StudentManager(input);
		
		int num = -1;
		while (num != 5) {
			System.out.println("*** Student Management System Menu ***");
			System.out.println(" 1. Add Student");
			System.out.println(" 2. Delete Student");
			System.out.println(" 3. Edit Student");
			System.out.println(" 4. View Student");
			System.out.println(" 5. Exit");
			System.out.println("Select one number between 1 - 6:");
			num = input.nextInt();
			if (num == 1) {
				studentManager.addStudent();
			}
			else if (num == 2) {
				studentManager.deleteStudent();
			}
			else if (num == 3) {
				studentManager.editStudent();
			}
			else if (num == 4) {
				studentManager.viewStudent();
			}
			else {
				continue;
			}
		}
	}
}
