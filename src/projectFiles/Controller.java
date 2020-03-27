package projectFiles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Creates and manipulates a student list according to input and button
 * presses from the GUI.
 * @author Eliza Nieves
 * @author Raheel Ozair
 */
public class Controller {
	
	//textFields
    @FXML
    private TextField fname;
    
    @FXML
    private TextField lname;
    
    @FXML
    private TextField credits;
    
    @FXML
    private TextField fund;

    @FXML
	private Label fundLabel;
    
    //radioButtons
    @FXML
    private RadioButton inst;
    
    @FXML
    private RadioButton outs;
    
    @FXML
    private RadioButton intr;
    
    //checkBox
    @FXML
    private CheckBox tristate;

    @FXML
    private CheckBox exchange;
    
    //Buttons
    @FXML
    private Button addBtn;
    
    @FXML
    private Button rmvBtn;
    
    @FXML
    private Button printBtn;
    
    //textArea
    @FXML
    private TextArea printed;

    StudentList list = new StudentList();

	/**
	 * Controls checkbox and text field visibility when the instate
	 * radio button is pressed (i.e. disables outstate and exchange checkboxes, while
	 * enabling funding text field).
	 * @param event Button press of the instate radio button.
	 */
	public void instateBtnPress(ActionEvent event){
		fund.setDisable(false);
		fundLabel.setDisable(false);
		tristate.setDisable(true);
		tristate.setSelected(false);
		exchange.setDisable(true);
		exchange.setSelected(false);
	}
	/**
	 * Controls checkbox and text field visibility when the outstate
	 * radio button is pressed (i.e. disables exchange checkbox, while
	 * enabling tristate checkbox).
	 * @param event Button press of the outstate radio button.
	 */
	public void outstateBtnPress(ActionEvent event){
		fund.setDisable(true);
		fundLabel.setDisable(true);
		tristate.setDisable(false);
		exchange.setDisable(true);
		exchange.setSelected(false);
		fund.setText("");
	}

	/**
	 * Controls checkbox and text field visibility when the international
	 * radio button is pressed (i.e. disables outstate checkbox, while
	 * enabling exchange checkbox).
	 * @param event Button press of the international radio button.
	 */
	public void intlBtnPress(ActionEvent event){
		fund.setDisable(true);
		fundLabel.setDisable(true);
		tristate.setDisable(true);
		tristate.setSelected(false);
		exchange.setDisable(false);
		fund.setText("");
	}

	/**
	 * Adds a student to the student list upon the button "add" being clicked.
	 * @param event The add button being pressed.
	 */
    public void addBtnPress(ActionEvent event){
    	boolean instantReturn = false;
    	if(fname.getText().isEmpty()) {
    		printed.appendText("Please enter a first name.\n");
    		instantReturn = true;
    	}
    	if(lname.getText().isEmpty()) {
    		printed.appendText("Please enter a last name.\n");
    		instantReturn = true;
    	}
    	if(credits.getText().isEmpty()) {
    		printed.appendText("Please enter the number of credits.\n");
    		instantReturn = true;
    	}
    	if(instantReturn) {
			printed.appendText("\n");
    		return;
    	}
    	
    	int creds;
    	
    	try{
    		creds = Integer.parseInt(credits.getText());
    	}catch(NumberFormatException nfe){
			printed.appendText("Please input a number for credits.\n\n");
			return;
		}

		if(creds <= 0) {
			printed.appendText("Number of credits can not be 0 or less.\n\n");
			return;
		}
    	
    	String first = fname.getText();
    	String last = lname.getText();
		Student temp;
    	
    	if(inst.isSelected()) {
    		int funds;
    		if(fund.getText().isEmpty()) {
    			funds = 0;
    		}else {
    			try {
    				funds = Integer.parseInt(fund.getText());
    			}catch(NumberFormatException nfe) {
    				printed.appendText("Please enter a number for the funds received.\n\n");
    				return;
    			}
    		}

    		temp = new Instate(first,last,creds,funds);
    		
    	}else if(outs.isSelected()) {
    		boolean tri = false;
    		if(tristate.isSelected()) {
    			tri = true;
    		}
			temp = new Outstate(first,last,creds,tri);
    	}else if(intr.isSelected()) {
			if(creds < 9) {
				printed.appendText("International student must have at least 9 credits.\n\n");
				return;
			}
    		boolean exc = false;
    		if(exchange.isSelected()) {
    			exc = true;
    		}
			temp = new International(first,last,creds,exc);
    	}else {
    		printed.appendText("Please select type of student (Instate, Outstate, or International.\n\n");
    		return;
    	}

		boolean preexist = list.contains(temp);
		if(preexist){
			printed.appendText("Student is already present in list.\n\n");
			return;
		}
		list.add(temp);
		printed.appendText(temp.toString() + " tuition due: $" + temp.tuitionDue() + ".\n\n");
    	
    	
    }

	/**
	 * Removes a specified student from the student list upon the
	 * remove button being pressed.
	 * @param event The remove button being clicked.
	 */
	public void rmvBtnPress(ActionEvent event) {
		if(list.len() == 0) {
			printed.appendText("List is empty!\n\n");
			return;
		}
		boolean fieldMissing = false;
		if(fname.getText().isEmpty()) {
			printed.appendText("Please enter a first name.\n");
			fieldMissing = true;
		}
		if(lname.getText().isEmpty()) {
			printed.appendText("Please enter a last name.\n");
			fieldMissing = true;
		}
		if(fieldMissing) {
			printed.appendText("\n");
			return;
		}
    	String f = fname.getText();
    	String l = lname.getText();
    	Instate temp = new Instate(f,l,0,0);
    	if(list.remove(temp)) {
			printed.appendText("Student " + f + " " + l + " was removed.\n\n");
    	}else {
    		printed.appendText("Student " + f + " " + l + " was not found.\n\n");
    	}
    }

	/**
	 * Prints the student list upon the print button being pressed.
	 * @param event The print button being clicked.
	 */
	public void printBtnPress(ActionEvent event) {
		String res = list.toString();
		if(res.isEmpty()) {
			printed.appendText("--\nTeam is currently empty!\n\n");
			return;
		}
		printed.appendText("--\n" + list.toString()+"\n");
	}
}