package org.codebreakers;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtils {
    /**
     * Рассчитывает разницу между двумя датами в днях.
     *
     * @param startDate начальная дата
     * @param endDate   конечная дата
     * @return количество дней между датами
     */
    public static long daysBetweenDates(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    /**
     * Проверяет, является ли год високосным.
     *
     * @param year год для проверки
     * @return true, если год високосный, иначе false
     */
    public static boolean isLeapYear(int year) {
        // Ошибка: проверяется только кратность 4
        return year % 4 == 0;

        // Исправленный код:
        // return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * Форматирует дату в строку по заданному шаблону.
     *
     * @param date    дата для форматирования
     * @param pattern шаблон для форматирования (например, "dd/MM/yyyy")
     * @return отформатированная строка даты
     */
    public static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    /**
     * Возвращает ближайший рабочий день (понедельник-пятница) от указанной даты.
     * Если дата выпадает на выходной, возвращает следующий рабочий день.
     *
     * @param date исходная дата
     * @return дата ближайшего рабочего дня
     */
    public static LocalDate getNextWorkingDay(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY) {
            return date.plusDays(2);
        } else if (dayOfWeek == DayOfWeek.SUNDAY) {
            return date.plusDays(1);
        }
        return date;
    }

    /**
     * Добавляет указанное количество рабочих дней (понедельник-пятница) к дате, пропуская выходные.
     *
     * @param date          исходная дата
     * @param workDaysToAdd количество рабочих дней для добавления
     * @return дата с добавленными рабочими днями
     */
    public static LocalDate addWorkingDays(LocalDate date, int workDaysToAdd) {
        LocalDate resultDate = date.plusDays(1);
        int addedDays = 0;

        while (addedDays < workDaysToAdd) {
            resultDate = resultDate.plusDays(1);
            DayOfWeek dayOfWeek = resultDate.getDayOfWeek();
            if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
                addedDays++;
            }
        }
        return resultDate;
    }
}
