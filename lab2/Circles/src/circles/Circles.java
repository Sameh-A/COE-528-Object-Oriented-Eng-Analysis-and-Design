package circles;
/*
Sameh Ahmed 500907041
*/
import java.util.stream.Stream;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Circles extends Application {
   /*All starting variables
    * 
    * 
    * 
    * 
    */
    
   public static final int ROWS = 4;
   public static final int COLS = 5;
   public static final int CELL_SIZE = 100;
   int rowXAxis;
   int columnYAxis;
   VBox root;
   Pane canvas;
   Button starter;
   HBox controls;
   Spinner xButton;
   Spinner yButton;
   Spinner rowButton;
   Spinner columnButton;
   Slider cellSizeSwitch;
   double xRange;
   double yRange;
   double startX;
   double startY;
   TranslateTransition animationTrans;
   ScaleTransition animationScale;
   
   
public void start(Stage primaryStage) {
    /*
    root of nodes
    */
    root = new VBox();
    root.setAlignment(Pos.CENTER);
    /*
    canvas in which the circles will be on
    */
    canvas = new Pane();
    canvas.setPrefSize(900.0,900.0);
    
    starter = new Button("Circles");
    /*
    cell slider 
    */
    cellSizeSwitch = new Slider(0.0, 180.0, 100.0);
    cellSizeSwitch.valueProperty().addListener(object -> startC());
    
    controls = new HBox(10.0);
    controls.setAlignment(Pos.CENTER);
    /*
    Row spinner which changes rows depending on user
    */
    rowButton = new Spinner<>(1, ROWS, 1);
    rowButton.setPrefWidth(75.0);
    rowButton.valueProperty().addListener(object-> startC() );
    /*
    Column spinner which changes rows depending on user
    */
    columnButton = new Spinner<>(1, COLS, 1);
    columnButton.setPrefWidth(75.0);
    columnButton.valueProperty().addListener(object-> startC());
   /*
    X scale button, to change the x scale of the circles
    */
    xButton = new Spinner<>(-3, 3, 0);
    xButton.setPrefWidth(75.0);
    xButton.valueProperty().addListener(object -> startC());
    /*
    Y scale button, to change the y scale of the circles
    */
    yButton = new Spinner<>(-3, 3, 0);
    yButton.setPrefWidth(75.0);
    yButton.valueProperty().addListener(object-> startC());
   /*
    *Labeling of the boxes
    *
    */
   String labelrows = ("rows");
   String labelcolumns = ("Columns");
   String labelX = ("X Scale");
   String labelY = ("Y Scale");
   String labelSize = ("Cell Size");
    
    Label cellLabel = new Label();
    cellLabel.setPrefWidth(70.0);
    cellLabel.textProperty().bind(Bindings.createStringBinding(() -> String.format ("%d",new Object[] { (int)cellSizeSwitch.getValue()}), new Observable[] { cellSizeSwitch.valueProperty() }));
    /*
    uses label method to add node and label it with the respective strings
    */
    controls.getChildren().addAll(new Node[]{
        labelMethod(labelrows, rowButton), 
            labelMethod(labelcolumns, columnButton), 
                labelMethod(labelSize, new HBox(new Node[] { cellSizeSwitch, cellLabel })),
                    labelMethod(labelX, xButton), 
                        labelMethod(labelY, yButton)});
    
  
    addButtonHandler();
    
    
    root.getChildren().addAll(new Node[] { canvas, controls });
  
    
    
    /*
    start up of the program
    */
    
    primaryStage.setTitle("Lab2 #2 Excersise");
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
    canvas.getChildren().clear();
    startC();
  }

    public void addButtonHandler() {
    starter.setOnAction(object -> startC());
  }
   /*
   method to add label as Vbox and assign it
   */
  public VBox labelMethod(String labelButton, Node assignmentButton) {
    VBox name = new VBox(10.0, new Node[] { new Label(labelButton), assignmentButton });
    return name;
  }
  
  /*
  starting method to add the circle matrix and clear the previous one 
  */
  public void startC() {
    canvas.getChildren().clear();
    addMatrix(buildMatrix());
  }
  /*
  creating and building matrix of circles
  */
  public Stream<Circle> generateMatrix() {
    return Stream.<Circle>generate(()-> new Circle(cellSizeSwitch.getValue() / 4.0)).limit(((Integer)columnButton.getValue()));
  }
  
  public Stream<Stream<Circle>> buildMatrix() {
    return Stream.<Stream<Circle>>generate(()-> generateMatrix()).limit(((Integer)rowButton.getValue()));
  }
  /*
  add matrix of circles
  */
 public void addMatrix(Stream<Stream<Circle>> rows) {
    rowXAxis = 0;
    rows.forEach(object -> { addRowOfCircles(object);rowXAxis++;});
  }
  /*
 method to add the circle rows
 */
  public void addRowOfCircles(Stream<Circle> rowAdd) {
    columnYAxis = 0;
    rowAdd.forEach(object -> {addObjectCircle(object);columnYAxis++;});
  }
  /*
  method that creates indivual circles
  also contains animations of each circle
  */
  public void addObjectCircle(Circle objectCircle) {
      /*
      creates circles dynaically with radom colours
      */
      objectCircle.setFill(new Color(Math.random(), Math.random(), Math.random(), 1.0));
      /*
      animation range
      */
      xRange = columnYAxis * cellSizeSwitch.getValue() + cellSizeSwitch.getValue() / 2.0;
      yRange = rowXAxis * cellSizeSwitch.getValue() + cellSizeSwitch.getValue() / 2.0;
      startX= ((Integer)columnButton.getValue()) * cellSizeSwitch.getValue() - cellSizeSwitch.getValue() / 2.0;
      startY= ((Integer)rowButton.getValue()) * cellSizeSwitch.getValue() - cellSizeSwitch.getValue() / 2.0;
      /*
      dynamically centers the starting point
      */
      objectCircle.setCenterX(startX);
      objectCircle.setCenterY(startY);

      canvas.getChildren().add(objectCircle);
      /*
      range for animation transition
      */
      int dynamicRangeX = (int) (xRange - startX);
      int dynamicRangeY = (int) (yRange - startY);
      /*
      transition animation (as circles move)
      */

      animationTrans = new TranslateTransition(Duration.millis(525.0));
      animationTrans.setNode(objectCircle);
      animationTrans.setByX(dynamicRangeX);
      animationTrans.setByY(dynamicRangeY);
      animationTrans.play();

      Boolean reverse =true;
      /*
      dynamic scaling to canvas
      */
      animationScale= new ScaleTransition(Duration.millis(525.0 * Math.random() + 525.0));
      animationScale.setNode(objectCircle);
      animationScale.setByX(((Integer)xButton.getValue()));
      animationScale.setByY(((Integer)yButton.getValue()));
      animationScale.setCycleCount(-1);
      animationScale.setAutoReverse(reverse);
      animationScale.play();
  }
  
  
  public static void main(String[] args) {
    launch(args);
  }
}
