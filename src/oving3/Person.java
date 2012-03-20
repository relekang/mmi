package oving3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class Person {
	
	public static final String NAME_PROPERTY = "name";
	public static final String DATE_OF_BIRTH_PROPERTY = "dateofbirth";
	public static final String GENDER_PROPERTY = "gender";
	public static final String HEIGHT_PROPERTY = "height";
	public static final String EMAIL_PROPERTY = "email";
	
	private String name;
	private String dateOfBirth;
	private Gender gender;
	private String email;
	private int height;
	private PropertyChangeSupport pcs;

	public Person(){
		pcs = new PropertyChangeSupport(this);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public Person(String name){
		setName(name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		pcs.firePropertyChange(NAME_PROPERTY, oldValue, this.name);
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		String oldValue = this.dateOfBirth;
		this.dateOfBirth = dateOfBirth;
		pcs.firePropertyChange(DATE_OF_BIRTH_PROPERTY, oldValue, this.dateOfBirth);
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		Gender oldValue = this.gender;
		this.gender = gender;
		pcs.firePropertyChange(GENDER_PROPERTY, oldValue, this.gender);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		String oldValue = this.email;
		this.email = email;
		pcs.firePropertyChange(EMAIL_PROPERTY, oldValue, this.email);
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		int oldValue = this.height;
		this.height = height;
		pcs.firePropertyChange(HEIGHT_PROPERTY, oldValue, this.height);
	}
	
}