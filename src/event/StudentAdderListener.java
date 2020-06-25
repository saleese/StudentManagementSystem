package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JTextField;

import exception.EmailFormatException;
import manager.StudentManager;
import student.Student;
import student.StudentInput;
import student.StudentKind;
import student.UniversityStudent;

public class StudentAdderListener implements ActionListener {
	JTextField fieldID;
	JTextField fieldName;
	JTextField fieldEmail;
	JTextField fieldPhone;
	
	StudentManager studentManager;

	public StudentAdderListener(
			JTextField fieldID, 
			JTextField fieldName, 
			JTextField fieldEmail,
			JTextField fieldPhone, StudentManager studentManager) {
		this.fieldID = fieldID;
		this.fieldName = fieldName;
		this.fieldEmail = fieldEmail;
		this.fieldPhone = fieldPhone;
		this.studentManager = studentManager;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {	
		StudentInput student = new UniversityStudent(StudentKind.University);
		try {
			student.setId(Integer.parseInt(fieldID.getText()));
			student.setName(fieldName.getName());
			student.setEmail(fieldEmail.getText());
			student.setPhone(fieldPhone.getText());
			studentManager.addStudent(student);
			putObject(studentManager, "studentmanager.ser");
			student.printInfo();
		} catch (EmailFormatException e1) {
			e1.printStackTrace();
		}
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
