package oving4;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

public class ViewPersonListPanel {

	static JFrame frame;
	
	public static void main(String[] args) {
		frame = new JFrame();
		PersonListPanel listPanel = new PersonListPanel();
		listPanel.setModel(new DefaultListModel());
		frame.add(listPanel);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		
		
	}

}
