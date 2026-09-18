package com.example;

public class PatientBill {
    private String patientId;
    private String patientName;
    private double consultationFee;
    private double medicineCost;

    public PatientBill(String patientId, String patientName, double consultationFee, double medicineCost) {
        if (patientId == null || patientId.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient ID cannot be empty.");
        }
        if (patientName == null || patientName.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty.");
        }
        if (consultationFee < 0) {
            throw new IllegalArgumentException("Consultation fee cannot be negative.");
        }
        if (medicineCost < 0) {
            throw new IllegalArgumentException("Medicine cost cannot be negative.");
        }
        this.patientId = patientId;
        this.patientName = patientName;
        this.consultationFee = consultationFee;
        this.medicineCost = medicineCost;
    }

    public String getPatientId() { return patientId; }
    public String getPatientName() { return patientName; }
    public double getConsultationFee() { return consultationFee; }
    public double getMedicineCost() { return medicineCost; }

    public double calculateSubtotal() {
        return this.consultationFee + this.medicineCost;
    }

    public double calculateNetBill(double insuranceCoveragePercentage) {
        if (insuranceCoveragePercentage < 0 || insuranceCoveragePercentage > 100) {
            throw new IllegalArgumentException("Insurance coverage percentage must be between 0 and 100.");
        }
        double discount = calculateSubtotal() * (insuranceCoveragePercentage / 100.0);
        return calculateSubtotal() - discount;
    }
}
