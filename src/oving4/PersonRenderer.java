package oving4;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class PersonRenderer implements ListCellRenderer {
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus) {
		ImageIcon icon;
		if(((Person) value).getGender() == Gender.male){
			icon = new ImageIcon(getClass().getResource("male.png"));
		} else {
			icon = new ImageIcon(getClass().getResource("female.png"));
		}
	    JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, hasFocus);
	    renderer.setText(((Person) value).getName() + ((Person) value).getEmail());
	    renderer.setIcon(icon);
	    return renderer;
	  }
}