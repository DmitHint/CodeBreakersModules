package org.codebreakers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class DateTimeUtilsTest {

    @Test
    void testDaysBetweenDates() {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 1, 10);
        long days = DateTimeUtils.daysBetweenDates(startDate, endDate);
        assertEquals(9, days);
    }

    @Test
    void testIsLeapYear() {
        assertTrue(DateTimeUtils.isLeapYear(2020)); // Високосный
        assertFalse(DateTimeUtils.isLeapYear(1900)); // Не високосный
        assertTrue(DateTimeUtils.isLeapYear(2000)); // Високосный
        assertFalse(DateTimeUtils.isLeapYear(2001)); // Не високосный
    }

    @Test
    void testFormatDate() {
        LocalDate date = LocalDate.of(2023, 1, 1);
        String formattedDate = DateTimeUtils.formatDate(date, "dd/MM/yyyy");
        assertEquals("01/01/2023", formattedDate);
    }

    @Test
    void testGetNextWorkingDay() {
        LocalDate saturday = LocalDate.of(2024, 9, 28); // Суббота
        LocalDate sunday = LocalDate.of(2024, 9, 29);   // Воскресенье
        LocalDate monday = LocalDate.of(2024, 9, 30);   // Понедельник

        assertEquals(monday, DateTimeUtils.getNextWorkingDay(saturday));
        assertEquals(monday, DateTimeUtils.getNextWorkingDay(sunday));
    }

    @Test
    void testAddWorkingDays() {
        LocalDate startDate = LocalDate.of(2024, 9, 26); // Пятница
        LocalDate expectedDate = LocalDate.of(2024, 10, 2); // Среда

        LocalDate resultDate = DateTimeUtils.addWorkingDays(startDate, 3);
        assertEquals(expectedDate, resultDate);
    }
}
