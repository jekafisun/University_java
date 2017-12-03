package com.epam.yevhen_fisun.java.lesson_6.processing;

import com.epam.yevhen_fisun.java.lesson_6.Demo;
import com.epam.yevhen_fisun.java.lesson_6.objects.Student;

import java.util.Calendar;
import java.util.ResourceBundle;

public class ShortReport {
    public static void printReport(Student[] students, Calendar currentTime) {
        for (Student currentStudent : students) {

            System.out.print(currentStudent.getStudentsName() + " - "
                    + currentStudent.getStudentsCurriculum().getNameCurriculum());

            int workhours = Time.getDiffWorkTimeInHours(currentStudent, currentTime);

            int day = workhours / (Demo.END_TIME_HOUR - Demo.START_TIME_HOUR);
            int hours = workhours % (Demo.END_TIME_HOUR - Demo.START_TIME_HOUR);

            System.out.println(". Time for complete curriculum " + day + " d " + hours + "hrs");

        }


    }

}

