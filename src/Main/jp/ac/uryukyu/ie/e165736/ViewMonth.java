package jp.ac.uryukyu.ie.e165736;

/**
 * Created by e165736 on 2017/2/6.
 */

import java.util.*;
public class ViewMonth {
        int month;
        int year;

            ViewMonth(final int displayMonth, final int displayYear) {
                month = displayMonth;
                year = displayYear;
            }

            private String checkMonth() {
                String[] months = {
                        "1 月", "2 月", "3 月",
                        "4 月", "5 月", "6 月",
                        "7 月", "8 月", "9 月",
                        "10 月", "11 月", "12 月"
                };
                return months[month];
            }

            private int checkDays() {
                int[] numofDays = {
                        31, 28, 31,
                        30, 31, 30,
                        31, 31, 30,
                        31, 30, 31
                };
                return numofDays[month];
            }

            void printMonth() {
                int initialSpaces = 0;
                try {
/* 月を決める. */
                    String monthName = checkMonth();
                    System.out.println();
                    System.out.println("\t\t\t " + year + " 年 " + monthName);
                    System.out.println();
                } catch (ArrayIndexOutOfBoundsException ae) {
                    System.out.println("範囲が超えました ..........");
                    System.exit(0);
                }
                GregorianCalendar cal = new GregorianCalendar(year, month, 1);
                System.out.println("\t日\t月\t火\t水\t木\t金\t土");
                initialSpaces = cal.get(Calendar.DAY_OF_WEEK) - 1;
/* 日の数を検索. */
                int daysInMonth = checkDays();
/* 閏年の時２月は２９日にする. */
                if (cal.isLeapYear(cal.get(Calendar.YEAR)) && month == 1) {
                    ++daysInMonth;
                }
                for (int ctr = 0; ctr < initialSpaces; ctr++) {
                    System.out.print("\t");
                }
                for (int ctr = 1; ctr <= daysInMonth; ctr++) {
                    if (ctr <= 9) {
                        System.out.print(" ");
                    }
                    System.out.print("\t" + ctr);
                    if ((initialSpaces + ctr) % 7 == 0) {
                        System.out.println();
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }

        class AA {
            protected AA() {
            }

            public static void main(String[] args) {
                int month, year;
                if (args.length == 2) {
                    System.out.println("カレンダーを表示する");
                    System.out.println();
                    int mon = Integer.parseInt(args[0]);
                    month = mon - 1;
                    year = Integer.parseInt(args[1]);
                } else {
                    Calendar today = Calendar.getInstance();
                    month = today.get(Calendar.MONTH);
                    year = today.get(Calendar.YEAR);
                }
                ViewMonth mv = new ViewMonth(month, year);
                mv.printMonth();
            }
        }



