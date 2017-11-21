package com.jorphrey.tools;

import java.time.LocalDate;

public class DateChecker {
    private int day, month, year;
    LocalDate now = LocalDate.now();

    public DateChecker(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isDateAccurate() {
        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1) {
            return false;
        } else if (year % 4 != 0 && month == 2 && day > 28) {
            return false;
        } else if (year > now.getYear()) {
            return false;
        } else if ((year == now.getYear()) && (month > now.getMonthValue())) {
            return false;
        } else if ((year == now.getYear()) && (month == now.getMonthValue()) && (day > now.getDayOfMonth())) {
            return false;
        } else if ((month == 9 || month == 6 || month == 4 || month == 11) && day > 30) {
            return false;
        } else if (month == 2 && day > 29) {
            return false;
        }
        return true;
    }

}
