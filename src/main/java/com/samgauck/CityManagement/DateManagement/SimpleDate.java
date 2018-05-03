package com.samgauck.CityManagement.DateManagement;

import static com.samgauck.CityManagement.DateManagement.Month.*;

/**
 * SimpleDate holds a day, month and year. Day and year are ints, while the month is a MonthClass.
 */
public class SimpleDate {
    private int dayOfMonth;
    private int year;
    private MonthClass month;

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int getYear() {
        return year;
    }

    public Month getMonth() {
        return month.getMonth();
    }

    public SimpleDate(int month, int day, int year){
        this.dayOfMonth = day;
        this.year = year;
        this.month = new MonthClass(numberToMonth(month));
    }

    public void setDate(int month, int dayOfMonth, int year) {
        this.dayOfMonth = dayOfMonth;
        this.month = new MonthClass(numberToMonth(month));
        this.year = year;
    }

    /**
     * Takes an int, 1-12 and converts it to a month. Default is JAN.
     * @param n The number of the month.
     * @return The month represented by the number.
     */
    private static Month numberToMonth(int n) {
        switch (n) {
            case 1:
                return JAN;
            case 2:
                return FEB;
            case 3:
                return MAR;
            case 4:
                return APR;
            case 5:
                return MAY;
            case 6:
                return JUN;
            case 7:
                return JUL;
            case 8:
                return AUG;
            case 9:
                return SEP;
            case 10:
                return OCT;
            case 11:
                return NOV;
            case 12:
                return DEC;
            default:
                return JAN;
        }
    }

    /**
     * Inputs a Month and converts it to an int representing that month. Default is 1 (JAN).
     * @param m The month.
     * @return The number of the month.
     */
    private static int monthToNumber(Month m) {
        switch (m) {
            case JAN:
                return 1;
            case FEB:
                return 2;
            case MAR:
                return 3;
            case APR:
                return 4;
            case MAY:
                return 5;
            case JUN:
                return 6;
            case JUL:
                return 7;
            case AUG:
                return 8;
            case SEP:
                return 9;
            case OCT:
                return 10;
            case NOV:
                return 11;
            case DEC:
                return 12;
            default:
                return 1;
        }
    }

    /**
     * Returns a date one day after the inputted date.
     * @param old The original date.
     * @return A new date one day later.
     */
    public static SimpleDate nextDay(SimpleDate old) {
        int m = monthToNumber(old.getMonth());
        int d = old.getDayOfMonth() + 1;
        int y = old.getYear();
        if (old.getDayOfMonth() > old.month.getNumberOfDays()) {
            d = 1;
            m += 1;
            if (m == 13) {
                m = 1;
                y += 1;
            }
        }
        return new SimpleDate(m, d, y);
//        old.dayOfMonth += 1;
//        if (old.getDayOfMonth() > old.month.getNumberOfDays()) {
//            old.dayOfMonth = 1;
//            int newMonth = monthToNumber(old.getMonth()) + 1;
//            int newYear = old.getYear();
//            while (newMonth > 12) {
//                newMonth -= 12;
//                newYear += 1;
//            }
//            old.setDate(newMonth, old.getDayOfMonth(), newYear);
//        }
//        return old;
    }

    public void proceedOneDay() {
        SimpleDate newDate = nextDay(this);
        this.setDate(monthToNumber(newDate.getMonth()), newDate.getDayOfMonth(), newDate.getYear());
    }

    /**
     * Converts a date to a string with format Jan 1, 2017.
     * @return A string formatted Jan 1, 2017.
     */
    @Override
    public String toString() {
        return month + " " + dayOfMonth + ", " + year;
    }
    public String simpleString() {
        StringBuilder s = new StringBuilder();
        s.append(monthToNumber(getMonth())).append("§").append(getDayOfMonth()).append("§").append(getYear());
        return s.toString();
    }
}