package com.example.javafinalproj;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChartModel {
    // List to store chosen colors for students
    private List<String> chosenColours = new ArrayList<>();
    // List of available seat rectangles
    private List<Rectangle> availableSeats = new ArrayList<>();
    // Index of the assigned seat
    private int assignedSeatIndex;

    // Constructor to initialize availableSeats list
    public ChartModel(List<Rectangle> availableSeats) {
        this.availableSeats = availableSeats;
    }

    // Method to add a student to a seat with color selection
    public String addStudent(String name, String colourSelect) {
        int totalSeats = availableSeats.size();
        int filledSeats = chosenColours.size();

        // Check if all seats are filled
        if (filledSeats >= totalSeats) {
            return "No more available seats!";
        }

        // Check if the selected color is already in use
        if (chosenColours.contains(colourSelect)) {
            return "This colour is already in use!";
        }

        // Check for valid name input
        if (name.isEmpty()) {
            return "Please enter a name!";
        }

        // Check for valid color selection
        if (colourSelect == null || colourSelect.isEmpty()) {
            return "Please select a valid colour!";
        }

        // Find indices of empty seats
        List<Integer> emptySlotIndices = new ArrayList<>();
        for (int i = 0; i < totalSeats; i++) {
            if (availableSeats.get(i).getFill().equals(Color.WHITE)) {
                emptySlotIndices.add(i);
            }
        }

        // Check if there are available empty seats
        if (emptySlotIndices.isEmpty()) {
            return "No more available seats!";
        }

        // Randomly select an empty seat
        Random random = new Random();
        int randomIndex = random.nextInt(emptySlotIndices.size());
        int emptySlotIndex = emptySlotIndices.get(randomIndex);
        assignedSeatIndex = emptySlotIndex;

        // Assign the selected seat to the student
        availableSeats.get(emptySlotIndex).setFill(Color.web(colourSelect));
        chosenColours.add(colourSelect);

        // Seat assignment successful
        String welcomeMessage = "Welcome " + name + " to seat " + (emptySlotIndex + 1);
        return welcomeMessage;
    }

    // Get the index of the assigned seat
    public int getAssignedSeatIndex() {
        return assignedSeatIndex;
    }
}
