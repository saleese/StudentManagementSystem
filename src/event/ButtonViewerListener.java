package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import gui.StudentViewer;
import gui.WindowFrame;
import manager.StudentManager;

public class ButtonViewerListener implements ActionListener {

	WindowFrame frame;
	
	public ButtonViewerListener(	WindowFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StudentViewer studentViewer = frame.getStudentviewer();
		StudentManager studentManager = getObject("studentmanager.ser");
		studentViewer.setStudentManager(studentManager);
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(studentViewer);
		frame.revalidate();
		frame.repaint();
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

}
