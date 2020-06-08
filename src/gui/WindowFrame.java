package gui;

import javax.swing.JFrame;

public class WindowFrame extends JFrame {

	MenuSelection menuSelection;
	StudentAdder studentadder;
	StudentViewer studentviewer;
	
	public WindowFrame() {
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My Frame");
		
		menuSelection = new MenuSelection(this);
		studentadder = new StudentAdder(this);
		studentviewer = new StudentViewer(this);
		
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
