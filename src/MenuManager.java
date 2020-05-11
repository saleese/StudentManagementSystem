import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManager {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StudentManager studentManager = new StudentManager(input);

		selectMenu(input, studentManager);

	}
	
	public static void selectMenu(Scanner input, StudentManager studentManager) {
		int num = -1;
		while (num != 5) {
			try {
				showMenu();
				num = input.nextInt();
				switch(num) {
				case 1:
					studentManager.addStudent();
					break;
				case 2:
					studentManager.deleteStudent();
					break;
				case 3:
					studentManager.editStudent();
					break;
				case 4:
					studentManager.viewStudents();
					break;
				default:
					continue;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Please put an integer between 1 and 5!");
				if (input.hasNext()) {
					input.next();
				}
				num = -1;
			}
		}
	}
	
	public static void showMenu() {
		System.out.println("*** Student Management System Menu ***");
		System.out.println(" 1. Add Student");
		System.out.println(" 2. Delete Student");
		System.out.println(" 3. Edit Student");
		System.out.println(" 4. View Students");
		System.out.println(" 5. Exit");
		System.out.println("Select one number between 1 - 6:");
	}
}
