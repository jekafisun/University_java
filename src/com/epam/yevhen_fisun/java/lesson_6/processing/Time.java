package com.epam.yevhen_fisun.java.lesson_6.processing;

import com.epam.yevhen_fisun.java.lesson_6.Demo;
import com.epam.yevhen_fisun.java.lesson_6.objects.Curriculum;
import com.epam.yevhen_fisun.java.lesson_6.objects.Student;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Time {
    static public Calendar getEndDate(Calendar startDate, Curriculum curriculum) {

        int amountWorkHours = curriculum.getSumDuration();
        int currentHour = 0;
        Calendar tmpDate = (Calendar) startDate.clone();

        while (!(amountWorkHours == 0)) {

            tmpDate.add(Calendar.HOUR, 1);
            currentHour = tmpDate.get(Calendar.HOUR_OF_DAY);

            if ((currentHour > Demo.START_TIME_HOUR) && (currentHour <= Demo.END_TIME_HOUR)) {
                amountWorkHours--;
            }
        }
        return tmpDate;
    }

    static public Calendar getStartDate(Calendar startDate) {

        Calendar tmpDate = (Calendar) startDate.clone();
        int currentHour = tmpDate.get(Calendar.HOUR_OF_DAY);

        while ((currentHour < Demo.START_TIME_HOUR) || (currentHour >= Demo.END_TIME_HOUR)) {

            tmpDate.add(Calendar.HOUR, 1);
            currentHour = tmpDate.get(Calendar.HOUR_OF_DAY);
        }
        return tmpDate;
    }

    static public int getDiffWorkTimeInHours(Student student, Calendar currentTime) {

        Calendar tmpDate1 = new GregorianCalendar();
        Calendar tmpDate2 = new GregorianCalendar();

        if (timeProgrammPassed(student, currentTime)) {
            tmpDate1 = (Calendar) student.getEndDate().clone();
            tmpDate2 = (Calendar) currentTime.clone();
        } else {
            tmpDate1 = (Calendar) currentTime.clone();
            tmpDate2 = (Calendar) student.getEndDate().clone();
        }

        int workHoursBetween = 0;
        int currentHour = 0;

        while (tmpDate1.before(tmpDate2)) {

            tmpDate1.add(Calendar.HOUR, 1);
            currentHour = tmpDate1.get(Calendar.HOUR_OF_DAY);

            if ((currentHour > Demo.START_TIME_HOUR) && (currentHour <= Demo.END_TIME_HOUR)) {
                workHoursBetween++;
            }
        }
        return workHoursBetween;
    }

    static public boolean timeProgrammPassed(Student student, Calendar currentTime) {

        boolean timeProgrammPased = false;

        long endDateStudentMS = student.getEndDate().getTimeInMillis();
        long currentDateMS = currentTime.getTimeInMillis();

        if (currentDateMS > endDateStudentMS) {
            timeProgrammPased = true;
        }
        return timeProgrammPased;
    }
}
