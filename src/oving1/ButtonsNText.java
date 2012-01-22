package oving1;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.xml.soap.Text;

public class ButtonsNText extends JPanel implements ActionListener, KeyListener {
	public JFrame frame;
	public JTextField TextLine;
	public JToggleButton UpperCaseButton, LowerCaseButton;
	public JCheckBox ContinuousButton;
	public ButtonGroup bGroup;
	
	public ButtonsNText(){
		frame = new JFrame();
		buildFrame();
		frame.add(this);
	}
	
	private void buildFrame(){
		bGroup = new ButtonGroup();
		TextLine = new JTextField(30);
		UpperCaseButton = new JToggleButton("Upper case");
		LowerCaseButton = new JToggleButton("Lower case");
		ContinuousButton = new JCheckBox("Continuous?");
		
		setNames();

		UpperCaseButton.addActionListener(this);
		LowerCaseButton.addActionListener(this);
		ContinuousButton.addActionListener(this);
		TextLine.addKeyListener(this);
		
		add(TextLine);
		bGroup.add(UpperCaseButton);
		bGroup.add(LowerCaseButton);
		add(UpperCaseButton);
		add(LowerCaseButton);
		add(ContinuousButton);
	}

	private void setNames() {
		TextLine.setName("TextLine");
		UpperCaseButton.setName("UpperCaseButton");
		LowerCaseButton.setName("LowerCaseButton");
		ContinuousButton.setName("ContinuousButton");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == UpperCaseButton){
			MakeUpperCase();
		} else if(e.getSource() == LowerCaseButton){
			MakeLowerCase();
		} else if(e.getSource() == ContinuousButton){
			TextLine.requestFocus();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			if(UpperCaseButton.isSelected()){
				MakeUpperCase();
			} else if(LowerCaseButton.isSelected()){
				MakeLowerCase();
			}
		} else if(ContinuousButton.isSelected()){
			if(UpperCaseButton.isSelected()){
				MakeUpperCase();
			} else if(LowerCaseButton.isSelected()){
				MakeLowerCase();
			}
		}
		
	}

	private void MakeLowerCase() {
		int pos = TextLine.getCaretPosition();
		TextLine.setText(TextLine.getText().toLowerCase());
//		TextLine.requestFocus();
		TextLine.setCaretPosition(pos);
	}

	private void MakeUpperCase() {
		int pos = TextLine.getCaretPosition();
		TextLine.setText(TextLine.getText().toUpperCase());
//		TextLine.requestFocus();
		TextLine.setCaretPosition(pos);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
