package student;

import java.util.Scanner;

public abstract class Student implements StudentInput {
	protected StudentKind kind = StudentKind.University;
	protected String name;
	protected int id;
	protected String email;
	protected String phone;

	public Student() {
	}
	
	public Student(StudentKind kind) {
		this.kind = kind;
	}

	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public Student(String name, int id, String email, String phone) {
		this.name = name;
		this.id = id;
		this.email = email;
		this.phone = phone;
	}
	
	public Student(StudentKind kind, String name, int id, String email, String phone) {
		this.kind = kind;
		this.name = name;
		this.id = id;
		this.email = email;
		this.phone = phone;
	}
	
	public StudentKind getKind() {
		return kind;
	}

	public void setKind(StudentKind kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public abstract void printInfo();
	
	public void setStudentID(Scanner input) {
		System.out.print("Student ID:");
		int id = input.nextInt();
		this.setId(id);
	}
	
	public void setStudentName(Scanner input) {
		System.out.print("Student name:");
		String name = input.next();
		this.setName(name);
	}
	
	public void setStudentEmail(Scanner input) {
		System.out.print("Email address:");
		String email = input.next();
		this.setEmail(email);
	}
	
	public void setStudentPhone( Scanner input) {
		System.out.print("Phone number:");
		String phone = input.next();
		this.setPhone(phone);
	}
	
	public String getKindString() {
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
		return skind;
	}

}
