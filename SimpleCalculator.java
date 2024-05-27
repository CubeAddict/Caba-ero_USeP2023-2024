import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create UI components
        TextField number1Field = new TextField();
        TextField number2Field = new TextField();
        Button addButton = new Button("Add");
        Button subtractButton = new Button("Subtract");
        Button multiplyButton = new Button("Multiply");
        Button divideButton = new Button("Divide");
        Label resultLabel = new Label("Result: ");

        // Set up button actions
        addButton.setOnAction(e -> {
            double num1 = getNumberFromTextField(number1Field);
            double num2 = getNumberFromTextField(number2Field);
            double result = num1 + num2;
            resultLabel.setText("Result: " + result);
        });

        subtractButton.setOnAction(e -> {
            double num1 = getNumberFromTextField(number1Field);
            double num2 = getNumberFromTextField(number2Field);
            double result = num1 - num2;
            resultLabel.setText("Result: " + result);
        });

        multiplyButton.setOnAction(e -> {
            double num1 = getNumberFromTextField(number1Field);
            double num2 = getNumberFromTextField(number2Field);
            double result = num1 * num2;
            resultLabel.setText("Result: " + result);
        });

        divideButton.setOnAction(e -> {
            double num1 = getNumberFromTextField(number1Field);
            double num2 = getNumberFromTextField(number2Field);
            if (num2 != 0) {
                double result = num1 / num2;
                resultLabel.setText("Result: " + result);
            } else {
                resultLabel.setText("Error: Division by zero");
            }
        });

        // Set up the layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(new Label("Number 1:"), 0, 0);
        gridPane.add(number1Field, 1, 0);
        gridPane.add(new Label("Number 2:"), 0, 1);
        gridPane.add(number2Field, 1, 1);
        gridPane.add(addButton, 0, 2);
        gridPane.add(subtractButton, 1, 2);
        gridPane.add(multiplyButton, 0, 3);
        gridPane.add(divideButton, 1, 3);
        gridPane.add(resultLabel, 0, 4, 2, 1);

        Scene scene = new Scene(gridPane, 300, 200);

        // Set up the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.show();
    }

    private double getNumberFromTextField(TextField textField) {
        try {
            return Double.parseDouble(textField.getText());
        } catch (NumberFormatException e) {
            return 0;  // Return 0 if input is invalid, you may handle it differently
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
