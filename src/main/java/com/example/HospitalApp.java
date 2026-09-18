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
            System.out.println("\n-----------------------------------------");
            System.out.println("Patient: " + bill.getPatientName() + " (" + bill.getPatientId() + ")");
            System.out.println("-----------------------------------------");
            System.out.println("1. View Patient Invoice Breakdown");
            System.out.println("2. Calculate Net Invoice with Insurance");
            System.out.println("3. Exit");
            System.out.print("Select an option (1-3): ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.println("\n===== PATIENT INVOICE =====");
                    System.out.println("Patient ID       : " + bill.getPatientId());
                    System.out.println("Patient Name     : " + bill.getPatientName());
                    System.out.printf("Consultation Fee : $%.2f%n", bill.getConsultationFee());
                    System.out.printf("Medicine Cost    : $%.2f%n", bill.getMedicineCost());
                    System.out.printf("Total Subtotal   : $%.2f%n", bill.calculateSubtotal());
                    System.out.println("===========================");
                    break;
                case "2":
                    System.out.print("Enter insurance coverage % (e.g. 20 for 20%): ");
                    try {
                        double coverage = Double.parseDouble(scanner.nextLine());
                        double net = bill.calculateNetBill(coverage);
                        System.out.printf("Net Payable Amount: $%.2f (Coverage: %.1f%%)%n", net, coverage);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "3":
                    System.out.println("Exiting Hospital Billing System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 3.");
            }
        }
        scanner.close();
    }
}
