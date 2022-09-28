 * @author khushipatel
 * Project 3 Water Bank GUI
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class WaterBankGUI extends Application {
	WaterBank wb = new WaterBank(); 

	//Instance Variables
	TextField waterAmt;
	TextField dgAmt;
	Label label1;
	Label label2 ;
	Label label3;
	Label label4;
	BorderPane pane;
	Button waterAmtButton;
	Button dgAmtButton;

	/**
	   * The required JavaFX start method
	   * @param primaryStage the primary stage for this application
	   * @see javafx.application.Application
	   */
	public void start(Stage primaryStage) {
	
		// type code for two buttons 
		//use a border layout and add the components
		waterAmtButton = new Button("Enter");
		EventHandler<ActionEvent> handlerOne = new ButtonClickHandlerOne();
		waterAmtButton.setOnAction(handlerOne);
		
		dgAmtButton = new Button("Enter");
		EventHandler<ActionEvent> handlerTwo = new ButtonClickHandlerTwo();
		dgAmtButton.setOnAction(handlerTwo);
		
		pane = new BorderPane();
		
		interaction();
		//set the background color to white
		pane.setStyle("-fx-background-color: white;");

		//create the scene with the layout object
		Scene scene = new Scene(pane);

		//and show the application 
		primaryStage.setTitle("Water Bank");

		//set this as the scene of the primary stage
		//and show the application 
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * @param interaction method to take inputs with no return
	 */
	private void interaction() {
		//components in this GUI are 5 labels
		//text fields
		waterAmt = new TextField();
		dgAmt = new TextField();
		Label label1 = new Label("Your daily goal is: " + wb.dailyGoal);
		Label label2 = new Label("Remaining " + wb.reportRemaining()) ;
		Label label3 = new Label("Record water: ");
		Label label4 = new Label("New day: ");
		VBox vb = new VBox();
		vb.getChildren().addAll(label1, label2, label3, waterAmt, waterAmtButton, label4, dgAmt, dgAmtButton);
		pane.setLeft(vb);
		

	}
	/**
	 * 
	 * @author khushipatel
	 *both private classes are created to call a button taking an event and handler
	 *@see waterAmtButton and dgAmtButton variables
	 */
	//create two private classes to handle your two button
	private class ButtonClickHandlerOne implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			int waterTrack = wb.waterIntake;
			wb.waterIntake = Integer.parseInt(waterAmt.getText());
			wb.waterIntake += waterTrack;
			wb.reportRemaining();
			interaction();
		}
	}

	private class ButtonClickHandlerTwo implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			wb.dailyGoal = Integer.parseInt(dgAmt.getText());
			interaction();
		}
	}	


	//main 
	/** 
	 * Launches the application
	 * @param args Arguments (none req)
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
