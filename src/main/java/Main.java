
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	// start()
	@Override
	public void start(Stage primaryStage) {
		 try {
	            // Read file fxml and draw interface.
	            Parent pane = FXMLLoader.load(getClass()
	                    .getResource("/FXML/Myfxml.fxml"));
	            
	            // Setting title of the app
	            primaryStage.setTitle("CS 480 - Final Project");
	            
	            // Creating scene and getting CSS style sheet for it
	            Scene scene = new Scene(pane, 800, 300);
	            scene.getStylesheets().add("/styles/style1.css");
	            
	            // Setting and showing scene
	            primaryStage.setScene(scene);
	            primaryStage.show();
	         
		 } catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
			}
	}
	
	// main()
	public static void main(String[] args) {
		launch(args);
	}
}
