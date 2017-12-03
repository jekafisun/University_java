package com.epam.yevhen_fisun.java.lesson_6;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Demo {
    public static final int START_TIME_HOUR = 9 ;
    public static final int END_TIME_HOUR = 18;

    public static void main(String[] args) {
        Calendar current = new GregorianCalendar();
        AppLogic.startApp(current);
    }
}
