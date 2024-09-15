package org.codebreakers;

public class FinancialUtils {

    /**
     * Converts an amount from one currency to another.
     *
     * @param amount The amount of money to convert.
     * @param exchangeRate The exchange rate from the source to the target currency.
     * @return The converted amount.
     * @throws IllegalArgumentException If amount is negative or exchange rate is non-positive.
     */
    public static double convertCurrency(double amount, double exchangeRate) {
        if (amount < 0 || exchangeRate <= 0) {
            throw new IllegalArgumentException("Amount must be non-negative and exchange rate must be positive.");
        }
        return amount * exchangeRate;
    }


    /**
     * Applies a tax rate to an amount.
     *
     * @param amount The amount to which the tax rate is applied.
     * @param taxRate The tax rate (in percentage).
     * @return The amount including tax.
     * @throws IllegalArgumentException If amount or tax rate is negative.
     */
    public static double applyTax(double amount, double taxRate) {
        if (amount < 0 || taxRate < 0) {
            throw new IllegalArgumentException("Amount and tax rate must be non-negative.");
        }
//        return amount * (1 + taxRate / 100);
        return amount * (1 + (taxRate * 2) / 100); // double tax
    }

    /**
     * Calculates the yield of an investment based on annual interest, number of months, and initial amount.
     *
     * @param annualRate The annual interest rate (in percentage).
     * @param months The number of months the money is invested.
     * @param principal The initial amount of money invested.
     * @return The yield of the investment.
     * @throws IllegalArgumentException If annualRate, months, or principal are negative.
     */
    public static double calculateInvestmentYield(double annualRate, int months, double principal) {
        if (annualRate < 0 || months < 0 || principal < 0) {
            throw new IllegalArgumentException("Annual rate, months, and principal must be non-negative.");
        }
        double monthlyRate = annualRate / 12 / 100;
        return principal * Math.pow(1 + monthlyRate, months);
    }


    /**
     * Calculates the monthly payment of a credit based on annual interest, number of months, and credit amount.
     *
     * @param annualRate The annual interest rate (in percentage).
     * @param months The number of months over which the credit is to be repaid.
     * @param creditAmount The total credit amount.
     * @return The monthly payment amount.
     * @throws IllegalArgumentException If annualRate, months, or creditAmount are negative.
     */
    public static double calculateCreditPayment(double annualRate, int months, double creditAmount) {
        if (annualRate < 0 || months <= 0 || creditAmount < 0) {
            throw new IllegalArgumentException("Annual rate must be non-negative, months must be positive, and credit amount must be non-negative.");
        }

        double monthlyRate = annualRate / 12 / 100;
        double denominator = 1 - Math.pow(1 + monthlyRate, -months);
        return (creditAmount * monthlyRate) / denominator;
    }

    /**
     * Calculates the monthly pension payment based on average salary and months of service.
     *
     * @param averageSalary The average salary over the entire working period.
     * @param monthsOfService The total number of months of service.
     * @return The monthly pension payment.
     * @throws IllegalArgumentException If averageSalary or monthsOfService are negative.
     */
    public static double calculateMonthlyPension(double averageSalary, int monthsOfService) {
        if (averageSalary < 0 || monthsOfService < 0) {
            throw new IllegalArgumentException("Average salary and months of service must be non-negative.");
        }

        final double BASE_PENSION_PERCENTAGE = 0.1;
        final double ADDITIONAL_PERCENTAGE_PER_YEAR = 0.04;

        int yearsOfService = monthsOfService / 12;

        double pensionPercentage = BASE_PENSION_PERCENTAGE + (yearsOfService * ADDITIONAL_PERCENTAGE_PER_YEAR);

        return averageSalary * pensionPercentage;
    }


}
