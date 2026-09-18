package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatientBillTest {

    private PatientBill bill;

    @BeforeEach
    void setUp() {
        bill = new PatientBill("PAT-501", "Jyoshna Chintha", 200.0, 300.0);
    }

    @Test
    @DisplayName("Should compute accurate subtotal")
    void testSubtotal() {
        assertEquals(500.0, bill.calculateSubtotal(), 0.001);
    }

    @Test
    @DisplayName("Should correctly calculate 20% insurance discount on 500 subtotal")
    void testInsuranceNetBill() {
        // 500 subtotal - 20% (100) = 400 net
        assertEquals(400.0, bill.calculateNetBill(20.0), 0.001);
    }

    @Test
    @DisplayName("Should reject negative fees or medicine costs")
    void testNegativeInputs() {
        assertThrows(IllegalArgumentException.class, () -> new PatientBill("PAT-502", "Alex", -50.0, 100.0));
        assertThrows(IllegalArgumentException.class, () -> new PatientBill("PAT-503", "Sam", 50.0, -100.0));
    }

    @Test
    @DisplayName("Should reject invalid insurance coverage percentage")
    void testInvalidInsurance() {
        assertThrows(IllegalArgumentException.class, () -> bill.calculateNetBill(-10.0));
        assertThrows(IllegalArgumentException.class, () -> bill.calculateNetBill(150.0));
    }
}
