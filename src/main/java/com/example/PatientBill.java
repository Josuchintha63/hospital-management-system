package com.example;

public class PatientBill {
    private String patientId;
    private String patientName;
    private double consultationFee;
    private double medicineCost;

    public PatientBill(String patientId, String patientName, double consultationFee, double medicineCost) {
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

    // BUG: Missing negative check and formula divides by 10 instead of 100
    public double calculateNetBill(double insuranceCoveragePercentage) {
        double discount = calculateSubtotal() * (insuranceCoveragePercentage / 10.0);
        return calculateSubtotal() - discount;
    }
}
