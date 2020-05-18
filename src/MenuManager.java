import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import log.EventLogger;

public class MenuManager {
	static EventLogger logger = new EventLogger("log.txt");
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		StudentManager studentManager = getObject("studentmanager.ser");
		if (studentManager == null) {
			studentManager = new StudentManager(input);
		}

		selectMenu(input, studentManager);
		putObject(studentManager, "studentmanager.ser");
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
					logger.log("add a student");
					break;
				case 2:
					studentManager.deleteStudent();
					logger.log("delete a student");
					break;
				case 3:
					studentManager.editStudent();
					logger.log("edit a student");
					break;
				case 4:
					studentManager.viewStudents();
					logger.log("edit a list of student");
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
	
	public static StudentManager getObject(String filename) {
		StudentManager studentManager = null;
		
		
		
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			
			studentManager = (StudentManager) in.readObject();
			
			in.close();
			file.close();
		} catch (FileNotFoundException e) {
			return studentManager;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return studentManager;
	}
	
	public static void putObject(StudentManager studentManager, String filename) {
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(studentManager);
			
			out.close();
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
