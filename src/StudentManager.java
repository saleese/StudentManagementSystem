import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import student.ElementarySchoolStudent;
import student.HighSchoolStudent;
import student.StudentInput;
import student.StudentKind;
import student.UniversityStudent;

public class StudentManager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3685095473703752321L;
	
	ArrayList<StudentInput> students = new ArrayList<StudentInput>();
	transient Scanner input;
	StudentManager(Scanner input) {
		this.input = input;
	}
	
	public void setScanner(Scanner input) {
		this.input = input;
	}

	public void addStudent() {
		int kind = 0;
		StudentInput studentInput;
		while (kind < 1 || kind > 3) {
			try {
				System.out.println("1 for University");
				System.out.println("2 for High School");
				System.out.println("3 for Elementary School");
				System.out.print("Select num 1, 2, or 3 for Student Kind:");
				kind = input.nextInt();
				if (kind == 1) {
					studentInput = new UniversityStudent(StudentKind.University);
					studentInput.getUserInput(input);
					students.add(studentInput);
					break;
				}
				else if (kind == 2) {
					studentInput = new HighSchoolStudent(StudentKind.HighSchool);
					studentInput.getUserInput(input);
					students.add(studentInput);
					break;
				}
				else if (kind == 3) {
					studentInput = new ElementarySchoolStudent(StudentKind.ElementarySchool);
					studentInput.getUserInput(input);
					students.add(studentInput);
					break;
				}
				else {
					System.out.print("Select num for Student Kind between 1 and 2:");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Please put an integer between 1 and 3!");
				if (input.hasNext()) {
					input.next();
				}
				kind = -1;
			}
		}
	}

	public void deleteStudent() {
		System.out.print("Student ID:");
		int studentId = input.nextInt();
		int index = findIndex(studentId);
		removefromStudents(index, studentId);
	}

	public int findIndex(int studentId) {
		int index = -1;
		for (int i = 0; i<students.size(); i++) {
			if (students.get(i).getId() == studentId) {
				index = i;
				break;
			}			
		}
		return index;
	}

	public int removefromStudents(int index, int studentId) {
		if (index >= 0) {
			students.remove(index);
			System.out.println("the student " + studentId + "is deleted");	
			return 1;
		}
		else {
			System.out.println("the student has not been registered");
			return -1;
		}
	}

	public void editStudent() {
		System.out.print("Student ID:");
		int studentId = input.nextInt();
		for (int i = 0; i<students.size(); i++) {
			StudentInput student = students.get(i);
			if (student.getId() == studentId) {
				int num = -1;
				while (num != 5) {
					showEditMenu();
					num = input.nextInt();
					switch(num) {
					case 1:
						student.setStudentID( input);
						break;
					case 2:
						student.setStudentName(input);
						break;
					case 3:
						student.setStudentEmail(input);
						break;
					case 4:
						student.setStudentPhone( input);
						break;
					default:
						continue;
					}
				} // while
				break;
			} // if
		} // for
	}

	public void viewStudents() {
		System.out.println("# of registered students:" + students.size());
		for (int i = 0; i<students.size(); i++) {
			students.get(i).printInfo();
		}
	}



	public void showEditMenu() {
		System.out.println("** Student Info Edit Menu **");
		System.out.println(" 1. Edit Id");
		System.out.println(" 2. Edit Name");
		System.out.println(" 3. Edit Email");
		System.out.println(" 4. View Phone");
		System.out.println(" 5. Exit");
		System.out.println("Select one number between 1 - 6:");
	}

}
