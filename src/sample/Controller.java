package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;

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
    		return;
    	}
    	
    	int creds;
    	
    	try{
    		creds = Integer.parseInt(credits.getText());
    	}catch(NumberFormatException nfe){
    		printed.appendText("Please input a number for credits.\n");
    		return;
    	}
    	
    	String first = fname.getText();
    	String last = lname.getText();
    	
    	if(inst.isSelected()) {
    		int funds;
    		if(fund.getText().isEmpty()) {
    			funds = 0;
    		}else {
    			try {
    				funds = Integer.parseInt(fund.getText());
    			}catch(NumberFormatException nfe) {
    				printed.appendText("Please enter a number for the funds received.\n");
    				return;
    			}
    		}
    		Instate temp = new Instate(first,last,creds,funds);
    		list.add(temp);
    		printed.appendText("Student " + first + " " + last + " was added.\n");
    		
    	}else if(outs.isSelected()) {
    		boolean tri = false;
    		if(tristate.isSelected()) {
    			tri = true;
    		}
    		Outstate temp = new Outstate(first,last,creds,tri);
    		list.add(temp);
    		printed.appendText("Student " + first + " " + last + " was added.\n");
    	}else if(intr.isSelected()) {
    		boolean exc = false;
    		if(exchange.isSelected()) {
    			exc = true;
    		}
    		International temp = new International(first,last,creds,exc);
    		list.add(temp);
    		printed.appendText("Student " + first + " " + last + " was added.\n");
    		
    	}else {
    		printed.appendText("Please select type of student (Instate, Outstate, or International.\n");
    	}
    	
    	
    }
    
    public void rmvBtnPress(ActionEvent event) {
    	String f = fname.getText();
    	String l = lname.getText();
    	Instate temp = new Instate(f,l,0,0);
    	if(list.remove(temp)) {
    		printed.appendText("Student " + f + " " + l + " was removed.\n");
    	}else {
    		printed.appendText("Student " + f + " " + l + " was not found.\n");
    	}
    }
    public void printBtnPress(ActionEvent event) {
    	printed.appendText("--\n" + list.toString());
    }
}