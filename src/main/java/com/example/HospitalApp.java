package com.example;

import java.util.Scanner;

public class HospitalApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.println("     Hospital Patient Billing CLI        ");
        System.out.println("=========================================");

        PatientBill bill = new PatientBill("PAT-501", "Jyoshna Chintha", 150.0, 350.0);

        boolean running = true;
        while (running) {
            System.out.println("\nPatient: " + bill.getPatientName() + " (" + bill.getPatientId() + ")");
            System.out.println("1. View Total Bill Statement");
            System.out.println("2. Apply Insurance Coverage (20%)");
            System.out.println("3. Exit");
            System.out.print("Select an option (1-3): ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.printf("Consultation: $%.2f | Medicines: $%.2f | Total: $%.2f%n",
                            bill.getConsultationFee(), bill.getMedicineCost(), bill.calculateSubtotal());
                    break;
                case "2":
                    System.out.printf("Net Payable with 20%% Insurance: $%.2f%n", bill.calculateNetBill(20.0));
                    break;
                case "3":
                    System.out.println("Exiting Hospital Billing System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
