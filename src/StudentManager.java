import java.util.ArrayList;
import java.util.Scanner;

import student.ElementarySchoolStudent;
import student.HighSchoolStudent;
import student.Student;
import student.StudentKind;

public class StudentManager {
	ArrayList<Student> students = new ArrayList<Student>();
	Scanner input;
	StudentManager(Scanner input) {
		this.input = input;
	}
	
	public void addStudent() {
		int kind = 0;
		Student student;
		while (kind != 1 && kind != 2) {
			System.out.println("1 for University");
			System.out.println("2 for High School");
			System.out.println("3 for Elementary School");
			System.out.print("Select num 1, 2, or 3 for Student Kind:");
			kind = input.nextInt();
			if (kind == 1) {
				student = new Student(StudentKind.University);
				student.getUserInput(input);
				students.add(student);
				break;
			}
			else if (kind == 2) {
				student = new HighSchoolStudent(StudentKind.HighSchool);
				student.getUserInput(input);
				students.add(student);
				break;
			}
			else if (kind == 3) {
				student = new ElementarySchoolStudent(StudentKind.ElementarySchool);
				student.getUserInput(input);
				students.add(student);
				break;
			}
			else {
				System.out.print("Select num for Student Kind between 1 and 2:");
			}
		}
	}
	
	public void deleteStudent() {
		System.out.print("Student ID:");
		int studentId = input.nextInt();
		int index = -1;
		for (int i = 0; i<students.size(); i++) {
			if (students.get(i).getId() == studentId) {
				index = i;
				break;
			}			
		}
		
		if (index >= 0) {
			students.remove(index);
			System.out.println("the student " + studentId + "is deleted");	
		}
		else {
			System.out.println("the student has not been registered");
			return;
		}
	}
	
	public void editStudent() {
		System.out.print("Student ID:");
		int studentId = input.nextInt();
		for (int i = 0; i<students.size(); i++) {
			Student student = students.get(i);
			if (student.getId() == studentId) {
				int num = -1;
				while (num != 5) {
					System.out.println("** Student Info Edit Menu **");
					System.out.println(" 1. Edit Id");
					System.out.println(" 2. Edit Name");
					System.out.println(" 3. Edit Email");
					System.out.println(" 4. View Phone");
					System.out.println(" 5. Exit");
					System.out.println("Select one number between 1 - 6:");
					num = input.nextInt();
					if (num == 1) {
						System.out.print("Student ID:");
						int id = input.nextInt();
						student.setId(id);
					}
					else if (num == 2) {
						System.out.print("Student name:");
						String name = input.next();
						student.setName(name);
					}
					else if (num == 3) {
						System.out.print("Email address:");
						String email = input.next();
						student.setEmail(email);
					}
					else if (num == 4) {
						System.out.print("Phone number:");
						String phone = input.next();
						student.setPhone(phone);
					}
					else {
						continue;
					} // if
				} // while
				break;
			} // if
		} // for
	}
	
	public void viewStudents() {
//		System.out.print("Student ID:");
//		int studentId = input.nextInt();
		System.out.println("# of registered students:" + students.size());
		for (int i = 0; i<students.size(); i++) {
			students.get(i).printInfo();
		}
	}

}
