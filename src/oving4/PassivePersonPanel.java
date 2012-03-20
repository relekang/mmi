package oving4;

import java.beans.PropertyChangeEvent;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PassivePersonPanel extends PersonPanel {
	
	JTextField genderField;
	JTextField heightField;
	
	public PassivePersonPanel(){
		super();
		this.genderField = new JTextField(20);
		this.heightField = new JTextField(20);
		
		this.nameField.setEditable(false);
		this.birthdayField.setEditable(false);
		this.emailField.setEditable(false);
		this.genderField.setEditable(false);
		this.heightField.setEditable(false);
		
		this.remove(genderComboBox);
		this.remove(heightSlider);
		
		gbc.gridx = 1;gbc.gridy = 3;
		gbc.gridwidth = 2;
		this.add(genderField, gbc);
		
		gbc.gridx = 1;gbc.gridy = 4;
		gbc.gridwidth = 2;
		this.add(heightField, gbc);
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if (e.getPropertyName() == Person.NAME_PROPERTY) {
			nameField.setText(model.getName());
		} else if (e.getPropertyName() == Person.DATE_OF_BIRTH_PROPERTY) {
			birthdayField.setText(model.getDateOfBirth());
		} else if (e.getPropertyName() == Person.GENDER_PROPERTY) {
			genderField.setText(model.getGender().toString());
		} else if (e.getPropertyName() == Person.HEIGHT_PROPERTY) {
			heightField.setText(Integer.toString(model.getHeight()));
		} else if (e.getPropertyName() == Person.EMAIL_PROPERTY) {
			emailField.setText(model.getEmail());
		}
	}
	
}
