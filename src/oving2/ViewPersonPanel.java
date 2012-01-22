package oving2;

import javax.swing.JFrame;

public class ViewPersonPanel {

	private static JFrame frame;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		frame = new JFrame();
		PersonPanel panel = new PersonPanel();
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
	}

}
