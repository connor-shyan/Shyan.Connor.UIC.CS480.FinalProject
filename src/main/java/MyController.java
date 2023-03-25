

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MyController implements Initializable {
	
	@FXML
	private BorderPane pane, pane2;
    
    @FXML
    private Button btn1, btn2;
    
    @FXML
    private TextField txt1, txt2;
    
    private static String textEntered;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
        
	}
	
	// Function to set the text when loading different FXML files
	public void setText() {
		
		// TextField 1 still contains the string the user entered
		txt1.setText(textEntered);
		
		// TextField 2 changes to show the string user entered in TextField 1
		txt2.setText(textEntered + " :from the center text field!");
	}
	
	// EventHandler method for button 1
	public void btn1Method(ActionEvent e) throws IOException {
		
		// Storing text entered in TextField 1
		textEntered = txt1.getText();
		
		// Loading the new FXML file which would disable button 1 and show text in TextField 2
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Myfxml2.fxml"));
		Parent pane2 = loader.load();
		
		// Getting MyController object and setting text in TextFields
		MyController myctr = loader.getController();
		myctr.setText();
		
		// Getting CSS style sheet
		pane2.getStylesheets().add("/styles/style1.css");
		
		// Getting scene from pane and setting new root as pane2
		pane.getScene().setRoot(pane2);
	}
	
	// EventHandler method for button 2
	public void btn2Method(ActionEvent e) throws IOException {
		
		// Checking if we have the second FXML file loaded (pane2 is root)
		if (pane2 != null) {
			
			// Loading the first FXML file which would reset the application
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Myfxml.fxml"));
			Parent pane = loader.load();
			
			// Getting CSS style sheet
			pane.getStylesheets().add("/styles/style1.css");
			
			// Getting scene from pane2 and setting new root as pane
			pane2.getScene().setRoot(pane);
			
		// We have the first FXML file loaded (pane is root)
		} else {
			// Just clearing TextField1
			txt1.clear();
		}
	}

}
