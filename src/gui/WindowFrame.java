package gui;

import javax.swing.JFrame;

import manager.StudentManager;

public class WindowFrame extends JFrame {

	StudentManager studentManager;
	
	MenuSelection menuSelection;
	StudentAdder studentadder;
	StudentViewer studentviewer;
	
	public WindowFrame(StudentManager studentManager) {
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My Frame");
		
		this.studentManager = studentManager;
		menuSelection = new MenuSelection(this);
		studentadder = new StudentAdder(this);
		studentviewer = new StudentViewer(this, this.studentManager);

		
		this.add(menuSelection);
		
		this.setVisible(true);
	}
	
	public MenuSelection getMenuSelection() {
		return menuSelection;
	}

	public void setMenuSelection(MenuSelection menuSelection) {
		this.menuSelection = menuSelection;
	}

	public StudentAdder getStudentadder() {
		return studentadder;
	}

	public void setStudentadder(StudentAdder studentadder) {
		this.studentadder = studentadder;
	}

	public StudentViewer getStudentviewer() {
		return studentviewer;
	}

	public void setStudentviewer(StudentViewer studentviewer) {
		this.studentviewer = studentviewer;
	}

}
