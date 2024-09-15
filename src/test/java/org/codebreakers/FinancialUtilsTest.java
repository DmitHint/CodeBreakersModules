package org.codebreakers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FinancialUtilsTest {
    @Test
    public void testConvertCurrency() {
        assertEquals(9000.0, FinancialUtils.convertCurrency(100.0, 90.0));
        assertThrows(IllegalArgumentException.class, () -> FinancialUtils.convertCurrency(-100.0, 2.0));
        assertThrows(IllegalArgumentException.class, () -> FinancialUtils.convertCurrency(100.0, 0.0));
    }

    @Test
    public void testApplyTax() {
        assertEquals(113.0, FinancialUtils.applyTax(100.0, 13.0), 0.01);
        assertEquals(220.0, FinancialUtils.applyTax(200.0, 10.0), 0.01);
        assertThrows(IllegalArgumentException.class, () -> FinancialUtils.applyTax(-100.0, 10.0));
        assertThrows(IllegalArgumentException.class, () -> FinancialUtils.applyTax(100.0, -10.0));
    }

    @Test
    public void testCalculateInvestmentYield() {
        assertEquals(602414.591458, FinancialUtils.calculateInvestmentYield(15.0, 15, 500_000.0), 0.01);
        assertThrows(IllegalArgumentException.class, () -> FinancialUtils.calculateInvestmentYield(-10.0, 6, 1000.0));
        assertThrows(IllegalArgumentException.class, () -> FinancialUtils.calculateInvestmentYield(10.0, -6, 1000.0));
        assertThrows(IllegalArgumentException.class, () -> FinancialUtils.calculateInvestmentYield(10.0, 6, -1000.0));
    }

    @Test
    public void testCalculateCreditPayment() {
        assertEquals(35451.16639, FinancialUtils.calculateCreditPayment(15.0, 9, 300_000.0), 0.01);
        assertThrows(IllegalArgumentException.class, () -> FinancialUtils.calculateCreditPayment(-5.0, 12, 150));
        assertThrows(IllegalArgumentException.class, () -> FinancialUtils.calculateCreditPayment(5.0, 0, 150));
        assertThrows(IllegalArgumentException.class, () -> FinancialUtils.calculateCreditPayment(5.0, 12, -150));
    }

    @Test
    public void testCalculateMonthlyPension() {
        assertEquals(30_000, FinancialUtils.calculateMonthlyPension(100_000, 60), 0.01);
        assertEquals(50_000, FinancialUtils.calculateMonthlyPension(100_000, 120), 0.01);
        assertThrows(IllegalArgumentException.class, () -> FinancialUtils.calculateMonthlyPension(-1000.0, 60));
        assertThrows(IllegalArgumentException.class, () -> FinancialUtils.calculateMonthlyPension(1000.0, -60));
    }
}

