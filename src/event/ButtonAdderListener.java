package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.WindowFrame;

public class ButtonAdderListener implements ActionListener {

	WindowFrame frame;
	
	public ButtonAdderListener(	WindowFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(frame.getStudentadder());
		frame.revalidate();
		frame.repaint();
	}

}
