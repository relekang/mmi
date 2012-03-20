package oving4;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


@SuppressWarnings("serial")
public class PersonPanel extends JPanel implements ChangeListener, KeyListener, ItemListener, PropertyChangeListener {
	GridBagConstraints gbc;
	JLabel nameLabel, emailLabel, birthdayLabel, genderLabel, heightLabel;
	JTextField nameField, emailField, birthdayField;
	JComboBox genderComboBox;
	JSlider heightSlider;
	protected Person model = null;

	public PersonPanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10) );
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.ipadx = 2;
		gbc.ipady = 4;
		createLabels();
		createFields();
		setNames();
	}
	
	public void setModel(Person newPerson){
		this.model = newPerson;
		model.addPropertyChangeListener(this);
		nameField.setText(model.getName());
		birthdayField.setText(model.getDateOfBirth());
		genderComboBox.setSelectedItem(model.getGender());
		heightSlider.setValue(model.getHeight());
		emailField.setText(model.getEmail());

	}
	public Person getModel(){
		return this.model;
	}
	
	private void createLabels() {
		gbc.gridx = 0;gbc.gridy = 0;
		nameLabel = new JLabel("Name:   ");
		this.add(nameLabel, gbc);
		
		gbc.gridx = 0;gbc.gridy = 1;
		emailLabel = new JLabel("Email:   ");
		this.add(emailLabel, gbc);

		gbc.gridx = 0;gbc.gridy = 2;
		birthdayLabel = new JLabel("Birthday:");
		this.add(birthdayLabel, gbc);

		gbc.gridx = 0;gbc.gridy = 3;
		genderLabel = new JLabel("Gender: ");
		this.add(genderLabel, gbc);

		gbc.gridx = 0;gbc.gridy = 4;
		heightLabel = new JLabel("Height:  ");
		this.add(heightLabel, gbc);
	}
	
	private void createFields() {
		gbc.gridx = 1;gbc.gridy = 0;
		gbc.gridwidth = 3;
		nameField = new JTextField(20);
		nameField.addKeyListener(this);
		this.add(nameField, gbc);
		
		gbc.gridx = 1;gbc.gridy = 1;
		emailField = new JTextField(20);
		emailField.addKeyListener(this);
		this.add(emailField, gbc);
		
		gbc.gridx = 1;gbc.gridy = 2;
		birthdayField = new JTextField(20);
		birthdayField.addKeyListener(this);
		this.add(birthdayField, gbc);
		
		gbc.gridx = 1;gbc.gridy = 3;
		gbc.gridwidth = 1;
		genderComboBox = new JComboBox(Gender.values());
		genderComboBox.addItemListener(this);
		this.add(genderComboBox, gbc);
		
		gbc.gridx = 1;gbc.gridy = 4;
		gbc.gridwidth = 2;
		heightSlider = new JSlider(120, 220);
		heightSlider.addChangeListener(this);
		heightSlider.setMajorTickSpacing(20);
		heightSlider.setMinorTickSpacing(5);
		heightSlider.setPaintTicks(true);
		heightSlider.setPaintLabels(true);
		this.add(heightSlider, gbc);
	}

	private void setNames() {
		nameField.setName("NamePropertyComponent");
		emailField.setName("EmailPropertyComponent");
		birthdayField.setName("DateOfBirthPropertyComponent");
		genderComboBox.setName("GenderPropertyComponent");
		heightSlider.setName("HeightPropertyComponent");
	}
	

	@Override
	public void stateChanged(ChangeEvent e) {
		if(this.model == null) return;
		this.model.setHeight(heightSlider.getValue());
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(this.model == null) return;
		this.model.setGender((Gender) genderComboBox.getSelectedItem());
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(this.model == null) return;
		this.model.setName(nameField.getText());
		this.model.setEmail(emailField.getText());
		this.model.setDateOfBirth(birthdayField.getText());
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if (e.getPropertyName() == Person.NAME_PROPERTY) {
			nameField.setText(model.getName());
		} else if (e.getPropertyName() == Person.DATE_OF_BIRTH_PROPERTY) {
			birthdayField.setText(model.getDateOfBirth());
		} else if (e.getPropertyName() == Person.GENDER_PROPERTY) {
			genderComboBox.setSelectedItem(model.getGender());
		} else if (e.getPropertyName() == Person.HEIGHT_PROPERTY) {
			heightSlider.setValue(model.getHeight());
		} else if (e.getPropertyName() == Person.EMAIL_PROPERTY) {
			emailField.setText(model.getEmail());
		}
	}


}

