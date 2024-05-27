import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class GuessingGame extends Application {

    private int randomNumber;
    private int attempts;

    @Override
    public void start(Stage primaryStage) {
        // Initialize the game
        initializeGame();

        // Create UI components
        Label instructionLabel = new Label("Guess a number between 1 and 100:");
        TextField guessField = new TextField();
        Button guessButton = new Button("Guess");
        Label feedbackLabel = new Label();
        Label attemptsLabel = new Label("Attempts: 0");

        // Set up button action
        guessButton.setOnAction(e -> {
            String guessText = guessField.getText();
            try {
                int guess = Integer.parseInt(guessText);
                attempts++;
                if (guess == randomNumber) {
                    feedbackLabel.setText("Congratulations! You guessed the correct number.");
                } else if (guess < randomNumber) {
                    feedbackLabel.setText("Too low! Try again.");
                } else {
                    feedbackLabel.setText("Too high! Try again.");
                }
                attemptsLabel.setText("Attempts: " + attempts);
            } catch (NumberFormatException ex) {
                feedbackLabel.setText("Please enter a valid number.");
            }
        });

        // Set up the layout
        VBox layout = new VBox(10, instructionLabel, guessField, guessButton, feedbackLabel, attemptsLabel);
        Scene scene = new Scene(layout, 300, 200);

        // Set up the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Guessing Game");
        primaryStage.show();
    }

    private void initializeGame() {
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1; // random number between 1 and 100
        attempts = 0;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
