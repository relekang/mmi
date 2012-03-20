package oving3;

import javax.swing.JFrame;

public class ViewPersonPanel {

	private static JFrame frame1;
	private static JFrame frame2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person model = new Person();
		frame1 = new JFrame();
		frame2 = new JFrame();
		PersonPanel panel1 = new PersonPanel();
		PersonPanel panel2 = new PassivePersonPanel();
		panel1.setModel(model);
		panel2.setModel(model);
		frame1.add(panel1);
		frame2.add(panel2);
		frame1.pack();frame2.pack();
		frame1.setVisible(true);
		frame2.setVisible(true);
		
	}
	
	
}
