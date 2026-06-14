import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input - Number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Step 2: Initialize variables
        double totalMarks = 0;
        double percentage;

        // Step 3: Take marks for each subject
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks for Subject " + i + " (out of 100): ");
            double marks = scanner.nextDouble();

            // Input validation
            while (marks < 0 || marks > 100) {
                System.out.print("Invalid! Marks should be between 0 and 100. Re-enter: ");
                marks = scanner.nextDouble();
            }

            totalMarks = totalMarks + marks;
        }

        // Step 4: Calculate percentage
        percentage = (double) totalMarks / numSubjects;

        // Step 5: Determine grade 
        String grade;
        
        if (percentage >= 75 && percentage <= 100) {
            grade = "A";
        } else if (percentage >= 65 && percentage < 75) {
            grade = "B";
        } else if (percentage >= 55 && percentage < 65) {
            grade = "C";
        } else if (percentage >= 45 && percentage < 55) {
            grade = "S";
        } else if (percentage >= 35 && percentage < 45) {
            grade = "W";
        } else {
            grade = "F";
        }

        // Step 6: Display results
        System.out.println("\n========== STUDENT GRADE REPORT ==========");
        System.out.printf("Total Marks       : %.2f / %d%n", totalMarks, numSubjects * 100);
        System.out.printf("Average Percentage: %.2f%%%n", percentage);
        System.out.println("Grade Assigned    : " + grade);
        
        // Grade description
        String description;
        switch (grade) {
            case "A": description = "Excellent (75-100)"; break;
            case "B": description = "Very Good (65-75)"; break;
            case "C": description = "Good (55-65)"; break;
            case "S": description = "Satisfactory (45-55)"; break;
            case "W": description = "Weak (35-45)"; break;
            default: description = "Fail (Below 35)";
        }
        System.out.println("Grade Description : " + description);
        
        // Pass/Fail status
        if (grade.equals("F")) {
            System.out.println("Status            : FAIL");
        } else {
            System.out.println("Status            : PASS");
        }
        System.out.println("==========================================");

        scanner.close();
    }
}
