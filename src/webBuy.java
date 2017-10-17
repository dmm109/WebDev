import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class webBuy extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Create a border pane
		BorderPane borderPane = new BorderPane();
		
		/*
		 * Center printer option fields
		 */
		
		//This HBox will hold 5 objects
		HBox centerPane = new HBox(10);
		
		//Create the Printer text and text box (object 1)
		Text printer = new Text("Printer: MyPrinter");
		TextArea textField1 = new TextArea();
		
		VBox textBox1 = new VBox();
		textBox1.setPadding(new Insets(0, 0, 10, 10));
		textBox1.setMaxWidth(100);
		textBox1.getChildren().addAll(printer, textField1);
		
		//Check boxes: Image, Text, and Code (object 2)
		CheckBox chbxImage = new CheckBox("Image");
		CheckBox chbxText = new CheckBox("Text");
		CheckBox chbxCode = new CheckBox("Code");
		
		VBox checkBoxes1 = new VBox(10);
		checkBoxes1.setPadding(new Insets(15, 10, 10, 0));
		checkBoxes1.setAlignment(Pos.CENTER_LEFT);
		checkBoxes1.getChildren().addAll(chbxImage, chbxText, chbxCode);
		
		//Text box 2 (object 3)
		TextArea textField2 = new TextArea();

		VBox textBox2 = new VBox();
		textBox2.setPadding(new Insets(15, 0, 10, 10));
		textBox2.setMaxWidth(70);
		textBox2.getChildren().addAll(textField2);
		
		//Radio buttons (object 4)
		final ToggleGroup toggleGroup1 = new ToggleGroup();
		
		RadioButton rbSelection = new RadioButton("Selection");
		rbSelection.setToggleGroup(toggleGroup1);
				
		RadioButton rbAll = new RadioButton("All");
		rbAll.setToggleGroup(toggleGroup1);
		rbAll.setSelected(true);
		
		RadioButton rbApplet = new RadioButton("Applet");
		rbApplet.setToggleGroup(toggleGroup1);

		VBox radioButtons1 = new VBox(10);
		radioButtons1.setPadding(new Insets(15, 10, 10, 0));
		radioButtons1.setAlignment(Pos.CENTER_LEFT);
		radioButtons1.getChildren().addAll(rbSelection, rbAll, rbApplet);
		
		//Text box 3 (object 5)
		TextArea textField3 = new TextArea();

		VBox textBox3 = new VBox();
		textBox3.setPadding(new Insets(15, 0, 10, 10));
		textBox3.setMaxWidth(100);
		textBox3.getChildren().addAll(textField3);
		
		//Add the 5 children objects to the center pane and the 
		//center pane to the border pane
		centerPane.getChildren().addAll(textBox1, checkBoxes1, textBox2, radioButtons1, textBox3);
		borderPane.setCenter(centerPane);
		
		/*
		 * Bottom printer option fields
		 */
		
		//Print Quality & Print to File checkbox
		Text printQuality = new Text("Print Quality:");
		final ComboBox<String> qualityComboBox = new ComboBox<String>();
		qualityComboBox.getItems().addAll(
				"High",
				"Medium",
				"Low"
		);
		CheckBox printToFile = new CheckBox("Print To File");
		
		HBox bottomPane = new HBox(10);
		bottomPane.setPadding(new Insets(0, 20, 10, 20));
		bottomPane.setAlignment(Pos.CENTER);
		bottomPane.getChildren().addAll(printQuality, qualityComboBox, printToFile);
		borderPane.setBottom(bottomPane);
		
		/*
		 * Right printer option fields
		 */
		

		//Four buttons to the right side
		Button btOK = new Button("OK");
		OKHandlerClass handler1 = new OKHandlerClass();
		btOK.setOnAction(handler1);
		btOK.setMaxWidth(Double.MAX_VALUE);
		
		Button btCancel = new Button("Cancel");
		CancelHandlerClass handler2 = new CancelHandlerClass();
		btCancel.setOnAction(handler2);
		btCancel.setMaxWidth(Double.MAX_VALUE);
		
		Button btSetup = new Button("Setup");
		SetupHandlerClass handler3 = new SetupHandlerClass();
		btSetup.setOnAction(handler3);
		btSetup.setMaxWidth(Double.MAX_VALUE);
		
		Button btHelp = new Button("Help");
		HelpHandlerClass handler4 = new HelpHandlerClass();
		btHelp.setOnAction(handler4);
		btHelp.setMaxWidth(Double.MAX_VALUE);
		
		VBox rightPane = new VBox(10);
		rightPane.setPadding(new Insets(0, 20, 10, 20));
		rightPane.setAlignment(Pos.CENTER);
		rightPane.getChildren().addAll(btOK, btCancel, btSetup, btHelp);
		borderPane.setRight(rightPane);
		
		//Set the scene
		Scene scene = new Scene(borderPane);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}	
}

class OKHandlerClass implements EventHandler<ActionEvent> {
	  @Override
	  public void handle(ActionEvent e) {
	    System.out.println("OK button clicked"); 
	  }
}

class CancelHandlerClass implements EventHandler<ActionEvent> {
	  @Override
	  public void handle(ActionEvent e) {
	    System.out.println("Cancel button clicked"); 
	  }
}

class SetupHandlerClass implements EventHandler<ActionEvent> {
	  @Override
	  public void handle(ActionEvent e) {
	    System.out.println("Setup button clicked"); 
	  }
}

class HelpHandlerClass implements EventHandler<ActionEvent> {
	  @Override
	  public void handle(ActionEvent e) {
	    System.out.println("Help button clicked"); 
	  }
}
