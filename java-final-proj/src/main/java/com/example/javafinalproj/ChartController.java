package com.example.javafinalproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class ChartController {
    // FXML variables for UI components
    @FXML private Label box1;
    @FXML private Label box2;
    @FXML private Label box3;
    @FXML private Label box4;
    @FXML private Label box5;
    @FXML private Label box6;
    @FXML private Label box7;
    @FXML private Label box8;
    @FXML private Label box9;
    @FXML private Label welcome;
    @FXML private Button button;
    @FXML private ComboBox<String> dropBox;
    @FXML private Label errorMsg2;
    @FXML private Label errorMsg1;
    @FXML private Rectangle rectangle1;
    @FXML private Rectangle rectangle2;
    @FXML private Rectangle rectangle3;
    @FXML private Rectangle rectangle4;
    @FXML private Rectangle rectangle5;
    @FXML private Rectangle rectangle6;
    @FXML private Rectangle rectangle7;
    @FXML private Rectangle rectangle8;
    @FXML private Rectangle rectangle9;
    @FXML private TextField studentNameField;

    // Lists to store chosen colors and available seat rectangles
    private List<String> chosenColours = new ArrayList<>();
    private List<Rectangle> availableSeats = new ArrayList<>();
    // The model responsible for managing seat assignments
    private ChartModel seatingModel;

    // Initialize UI components and event handling
    @FXML
    private void initialize() {
        // Initialize combo box items
        if (dropBox.getItems().isEmpty()) {
            dropBox.getItems().addAll("Red", "Blue", "Green", "Yellow", "Orange", "Pink", "Brown", "Teal", "Magenta", "Cyan", "Indigo");
        }

        // Populate availableSeats list with seat rectangles
        availableSeats.add(rectangle1);
        availableSeats.add(rectangle2);
        availableSeats.add(rectangle3);
        availableSeats.add(rectangle4);
        availableSeats.add(rectangle5);
        availableSeats.add(rectangle6);
        availableSeats.add(rectangle7);
        availableSeats.add(rectangle8);
        availableSeats.add(rectangle9);

        // Create an instance of ChartModel for seat assignment
        seatingModel = new ChartModel(availableSeats);

        // Set action for the button to add a student
        button.setOnAction(this::addStudent);
    }

    // Handle adding a student on button click
    @FXML
    private void addStudent(ActionEvent event) {
        // Clear previous messages
        welcome.setText("");
        errorMsg1.setText("");
        errorMsg2.setText("");

        // Get student name and selected color
        String name = studentNameField.getText().trim();
        String colourSelect = dropBox.getValue();

        // Attempt to add the student to a seat
        String welcomeMessage = seatingModel.addStudent(name, colourSelect);

        // Update UI based on success or failure
        if (welcomeMessage.startsWith("Welcome")) {
            // Update assigned seat label and show welcome message
            Label boxLabel = getBoxLabel(seatingModel.getAssignedSeatIndex());
            boxLabel.setText(name);
            welcome.setText(welcomeMessage);
        } else {
            // Show error messages
            errorMsg1.setText(welcomeMessage);
            errorMsg2.setText(":(");
        }
    }

    // Get the corresponding box label based on seat index
    private Label getBoxLabel(int index) {
        switch (index) {
            case 0:
                return box1;
            case 1:
                return box2;
            case 2:
                return box3;
            case 3:
                return box4;
            case 4:
                return box5;
            case 5:
                return box6;
            case 6:
                return box7;
            case 7:
                return box8;
            case 8:
                return box9;
            default:
                throw new IllegalArgumentException("Invalid box index: " + index);
        }
    }
}

