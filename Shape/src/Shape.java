import javafx.application.Application; 
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.Label; 
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; 
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font; 
import javafx.stage.Stage;


public class Shape extends Application{
	//Components to be used for Shape GUI 
			String 		currentShape;	
			Button 		ButtonAdd = new Button();   
			Button 		ButtonSub = new Button(); 
			Button 		Button = new Button();	
			TextField 	TextField = new TextField();   	
			Label 		Label= new Label();   
			VBox 		initialButton = new VBox(10);
			HBox 		addSubButtons = new HBox(10);
			VBox 		root = new VBox(10);  
			VBox 		root1 = new VBox(10);

			@Override    
			public void start(Stage stage)     
			{
			 	// configure a text field for user entry
				 TextField.setMaxWidth(100);
				// configure a label to display a string output
				 Label.setTextFill(Color.GREEN);         
				 Label.setFont(Font.font("Arial", 16));
				// configure a label which will cause the shape to be displayed
				 Button.setText("Type number between 3 and 7 in the box then push me");
				 Button.setFont(Font.font("Arial", 14));
				 ButtonAdd.setText("Add"); 		
				 ButtonAdd.setFont(Font.font("Arial", 14));	        
				 ButtonSub.setText("Subtract"); 
				 ButtonSub.setFont(Font.font("Arial", 14));			
				// configure Components to hold buttons			
				  initialButton.setAlignment(Pos.CENTER);        
				  initialButton.getChildren().addAll( TextField,  Label, 
													 Button);
				   addSubButtons.setAlignment(Pos.CENTER);        
				   addSubButtons.getChildren().addAll(ButtonSub, ButtonAdd);				
				// configure area for shape 			        
				root1.setSpacing(5);         
				root1.setAlignment(Pos.CENTER); 	

				//call the methods that deal with the pressing of the buttons
				inputButton();
				AddButton();
				SubtractButton();	
						
				// configure a VBox to hold our components
				root.setSpacing(5);         
				root.setAlignment(Pos.CENTER); 

				//add the components to the VBox         
				root.getChildren().addAll(initialButton, addSubButtons, root1); 
				
				// create a new scene         
				Scene scene = new Scene(root, 700, 500);  
				stage.setScene(scene); 
				
				//add the scene to the stage, then configure the stage and make it visible        
				stage.setTitle("Shape");         
				stage.show();             
		}  
		
		// Method for creating a 3 sided shape
		public static Polygon Triangle()
		{
			// create a new 3 sided shape
			Polygon Triangle = new Polygon();
			Triangle.getPoints().addAll(new Double[]{
				100.0,70.0,
				100.0,250.0,
				400.0,250.0
			});
			Triangle.setFill(Color.RED);         
			Triangle.setStroke(Color.RED);
			return Triangle;
		}

		// Method for creating a 4 sided shape
		public static Polygon Oblong()
		{
			// create a new 4 sided shape
			Polygon Oblong = new Polygon();
			Oblong.getPoints().addAll(new Double[]{
				100.0,70.0,
				100.0,250.0,
				400.0,250.0,
				400.0,70.0
			});
			Oblong.setFill(Color.BLUE);         
			Oblong.setStroke(Color.BLUE); 
			return Oblong;
		}

		// Method for creating a 5 sided shape
		public static Polygon Pentagon()
		{
			// create a new 5 sided shape
			Polygon Pentagon = new Polygon();
			Pentagon.getPoints().addAll(new Double[]{
				100.0,70.0,
				100.0,200.0,
				250.0,250.0,
				370.0,200.0,
				370.0,70.0
			});
			Pentagon.setFill(Color.RED);         
			Pentagon.setStroke(Color.RED); 
			return Pentagon;
		}

		// Method for creating a 6 sided shape
		public static Polygon Hexagon()
		{
			// create a new 6 sided shape
			Polygon Hexagon = new Polygon();
			Hexagon.getPoints().addAll(new Double[]{
				150.0,50.0,
				350.0,50.0,
				400.0,150.0,
				350.0,250.0,
				150.0,250.0,
				100.0,150.0
			});
			Hexagon.setFill(Color.BLUE);         
			Hexagon.setStroke(Color.BLUE); 
			return Hexagon;
		}

		// Method for creating a 7 sided shape
		public static Polygon Heptagon()
		{
			// create a new 7 sided shape
			Polygon Heptagon = new Polygon();
			Heptagon.getPoints().addAll(new Double[]{
				200.0,50.0,
				300.0,100.0,
				250.0,175.0,
				175.0,200.0,
				150.0,175.0,
				100.0,100.0,
				50.0,50.0,
			});
			Heptagon.setFill(Color.RED);         
			Heptagon.setStroke(Color.RED); 
			return Heptagon;
		}

		// Method that deals with the input from a user and disaplys a shape
		public void inputButton(){
			  //case statement to draw the shape depending on user input 
			 Button.setOnAction(e -> {
				//This could be use to convert to integer rather than read a string
				//but it does not cover the options if the user inputs a character or a string of characters
				//and does not return an error message 
				// (Integer.parseInt( TextField.getText()))
				switch ( TextField.getText()){
					case "3": 	
						// clear the drawing area					
						root1.getChildren().clear();
						//Show the user what has been input
						 Label.setText("You entered: " + TextField.getText());
						// draw the shape that correspondes to the input number
						root1.getChildren().addAll(Triangle());
						currentShape = "triangle";
						break;
					case "4":
						root1.getChildren().clear();
						 Label.setText("You entered: " + TextField.getText());
						root1.getChildren().addAll(Oblong());
						currentShape = "oblong";
						break; 
					case "5": 
						root1.getChildren().clear();
						 Label.setText("You entered: " + TextField.getText());
						root1.getChildren().addAll(Pentagon());
						currentShape = "pentagon";
						break;
					case "6": 
						root1.getChildren().clear();
						 Label.setText("You entered: " + TextField.getText());
						root1.getChildren().addAll(Hexagon());
						currentShape = "hexagon";
						break;
					case "7": 
						root1.getChildren().clear();
						 Label.setText("You entered: " + TextField.getText());
						root1.getChildren().addAll(Heptagon());
						currentShape = "heptagon";
						break;
					default:
						root1.getChildren().clear();
						 Label.setText("You entered an invalid number. Please try again" );
				};								
			});       
		}

		// Method that deals with the adding of a side to the current shape
		public void AddButton(){
			 ButtonAdd.setOnAction(e -> {
				//If statements to check the current shape and add a side if it is a valid number
				if (currentShape == "triangle"){
					root1.getChildren().clear();
						 Label.setText("You now have 4 sides");
						root1.getChildren().addAll(Oblong());
						currentShape = "oblong";
				}
				else if (currentShape == "oblong"){
					root1.getChildren().clear();
						 Label.setText("You now have 5 sides");
						root1.getChildren().addAll(Pentagon());
						currentShape = "pentagon";
				}
				else if (currentShape == "pentagon"){
					root1.getChildren().clear();
						 Label.setText("You now have 6 sides");
						root1.getChildren().addAll(Hexagon());
						currentShape = "hexagon";
				}
				else if (currentShape == "hexagon"){
					root1.getChildren().clear();
						 Label.setText("You now have 7 sides");
						root1.getChildren().addAll(Heptagon());
						currentShape = "heptagon";
				}
				else if (currentShape == "heptagon"){
						 Label.setText("Error, cannot add any more sides");
				}				
			});
		}

		// Method that deals with the subtracting of a side to the current shape
		public void SubtractButton(){
			 ButtonSub.setOnAction(e -> {
				//If statements to check the current shape and add a side if it is a valid number
				if (currentShape == "triangle"){
						 Label.setText("Error, cannot subtract any more sides");
				}
				else if (currentShape == "oblong"){
					root1.getChildren().clear();
						 Label.setText("You now have 3 sides");
						root1.getChildren().addAll(Triangle());
						currentShape = "triangle";
				}
				else if (currentShape == "pentagon"){
					root1.getChildren().clear();
						 Label.setText("You now have 4 sides");
						root1.getChildren().addAll(Oblong());
						currentShape = "oblong";
				}
				else if (currentShape == "hexagon"){
					root1.getChildren().clear();
						 Label.setText("You now have 5 sides");
						root1.getChildren().addAll(Pentagon());
						currentShape = "pentagon";
				}
				else if (currentShape == "heptagon"){
					root1.getChildren().clear();						
						 Label.setText("You now have 6 sides");
						root1.getChildren().addAll(Hexagon());
						currentShape = "hexagon";
				}			
			});
		}

		public static void main(String[] args)     
		{         
			launch(args);     
		} 
}
