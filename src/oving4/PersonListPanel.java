package oving4;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class PersonListPanel extends JPanel implements ActionListener, ListSelectionListener {
	
	GridBagConstraints gbc;
	JList list;
	PersonPanel personPanel;
	JButton addButton, deleteButton;
	
	Person editPerson; 
	DefaultListModel model;
	
	public PersonListPanel(){
		
		editPerson = new Person();
		
		
		setBorder(new EmptyBorder(10, 10, 10, 10) );
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.gridx = 0; gbc.gridy = 0;
		list = new JList();
		list.setName("PersonList");
		list.addListSelectionListener(this);
		list.setCellRenderer(new PersonRenderer());
		add(list, gbc);
		
		gbc.gridx = 1; gbc.gridy = 0;
		personPanel = new PersonPanel();
		personPanel.setName("PersonPanel");
		personPanel.setModel(editPerson);
		add(personPanel, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1;
		addButton = new JButton("Add");
		addButton.setName("NewPersonButton");
		addButton.addActionListener(this);
		add(addButton, gbc);
		
		gbc.gridx = 1; gbc.gridy = 1;
		deleteButton = new JButton("Delete");
		deleteButton.setName("DeletePersonButton");
		deleteButton.addActionListener(this);
		add(deleteButton, gbc);
		
		model = new DefaultListModel();
		setModel(model);
		
		Person person = new Person();
		getModel().addElement(person);
		list.setSelectedValue(person, true);
		
	}
	
	public void setModel(DefaultListModel model){
		this.list.setModel(model);
	}
	public DefaultListModel getModel(){
		return (DefaultListModel) this.list.getModel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addButton){
			Person person = new Person();
			getModel().addElement(person);
			list.setSelectedValue(person, true);
		} else if(e.getSource() == deleteButton){
			getModel().removeElement(list.getSelectedValue());
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == list){	
			editPerson = (Person) list.getSelectedValue();
			if(editPerson != null) {
				personPanel.setModel(editPerson);
			//System.out.println("Selected: " + editPerson.toString());
			}
		}	
	}

}
