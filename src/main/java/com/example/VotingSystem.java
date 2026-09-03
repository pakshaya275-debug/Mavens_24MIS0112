package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Voter {
    private String name;
    private int age;
    private String citizenship;
    private String voterId;
    private boolean isIdValid;

    public Voter(String name, int age, String citizenship, String voterId, boolean isIdValid) {
        this.name = name;
        this.age = age;
        this.citizenship = citizenship;
        this.voterId = voterId;
        this.isIdValid = isIdValid;
    }

    public void checkEligibility() {
        System.out.println("\n--- Evaluation for " + name + " ---");
        List<String> reasons = new ArrayList<>();

        if (age < 18) {
            reasons.add("Underage (Age must be at least 18)");
        }
        if (!"Indian".equalsIgnoreCase(citizenship)) {
            reasons.add("Not a citizen (Must be an Indian citizen)");
        }
        if (!isIdValid) {
            reasons.add("Invalid Voter ID status");
        }

        if (reasons.isEmpty()) {
            System.out.println("Status: ELIGIBLE TO VOTE");
        } else {
            System.out.println("Status: NOT ELIGIBLE");
            System.out.println("Reasons:");
            for (String reason : reasons) {
                System.out.println(" - " + reason);
            }
        }
    }
}

public class VotingSystem {
    public static void main(String[] args) {
        // If Jenkins passes automated data through args
        if (args.length >= 5) {
            System.out.println("Running in automated mode...");
            String name = args[0];
            int age = Integer.parseInt(args[1]);
            String citizenship = args[2];
            String voterId = args[3];
            boolean isIdValid = Boolean.parseBoolean(args[4]);

            Voter voter = new Voter(name, age, citizenship, voterId, isIdValid);
            voter.checkEligibility();
            return; 
        }

        // Fallback for manual testing in VS Code
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Citizenship: ");
        String citizenship = scanner.nextLine();
        System.out.print("Enter Voter ID: ");
        String voterId = scanner.nextLine();
        System.out.print("Is ID Valid? (true/false): ");
        boolean isIdValid = scanner.nextBoolean();

        Voter voter = new Voter(name, age, citizenship, voterId, isIdValid);
        voter.checkEligibility();
        scanner.close();
    }
}
