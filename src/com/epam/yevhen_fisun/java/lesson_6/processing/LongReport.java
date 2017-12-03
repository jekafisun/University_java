package com.epam.yevhen_fisun.java.lesson_6.processing;

import com.epam.yevhen_fisun.java.lesson_6.Demo;
import com.epam.yevhen_fisun.java.lesson_6.objects.Course;
import com.epam.yevhen_fisun.java.lesson_6.objects.Student;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Formatter;
import java.util.ResourceBundle;

public class LongReport {

    private static int MIN_WIDE_REPORT = 32;
    private static int LENGTH_WORD_CURRENT_DATE = 15;
    private static int LENGTH_HOURSES_COURSE = 4;
    private static int LENGTH_NUMBER_COURSE = 3;

    public static void printReportLong(Student[] students, Calendar currentTime) {

        int wideReport = getWideReport(students);
        String line = getLine(wideReport);

        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);

        for (Student currentStudent : students) {

            int minWideSecondColum = wideReport - LENGTH_WORD_CURRENT_DATE;
            String lineFormater = "%-" + LENGTH_WORD_CURRENT_DATE + "s %" + minWideSecondColum + "s\n";

            fmt.format(line + "\n");

            fmt.format("Current date     "+getDateToString(currentTime)+"\n");

            fmt.format("Start date       "+getDateToString(currentStudent.getStartDate())+"\n");

            fmt.format("Finish date      "+getDateToString(currentStudent.getEndDate())+"\n");

            String tmpString = Demo.START_TIME_HOUR + ":00 - " + Demo.END_TIME_HOUR + ":00";
            fmt.format("Working time         "+tmpString+"\n");

            fmt.format("Student               "+currentStudent.getStudentsName()+"\n");

            fmt.format("Curriculum       "+currentStudent.getStudentsCurriculum().getNameCurriculum()+"\n");
            fmt.format(line + "\n");

            int i = 1;
            lineFormater = "%-" + (wideReport - LENGTH_HOURSES_COURSE - LENGTH_NUMBER_COURSE) + "s %"
                    + LENGTH_HOURSES_COURSE + "s\n";

            for (Course currentCourse : currentStudent.getStudentsCurriculum().getCourseInCurriculum()) {

                fmt.format(i + ". " + lineFormater, currentCourse.getCourseName(), currentCourse.getCourseDuration());
                i++;
            }
            fmt.format(line + "\n");
            fmt.format("Total"+currentStudent.getStudentsCurriculum().getSumDuration() + "\n");

            if (Time.timeProgrammPassed(currentStudent, currentTime)) {
                fmt.format("complete");
            } else {
                fmt.format("not complete");
            }

            int workhours = Time.getDiffWorkTimeInHours(currentStudent, currentTime);

            int day = workhours / (Demo.END_TIME_HOUR - Demo.START_TIME_HOUR);
            int hours = workhours % (Demo.END_TIME_HOUR - Demo.START_TIME_HOUR);

            fmt.format(day + "day" + hours + "hours" + "\n\n");

            System.out.println(sb.toString());

            sb.setLength(0);

        }
        fmt.close();
    }

    private static String getDateToString(Calendar time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String tmp = dateFormat.format(time.getTime());
        return tmp;
    }

    private static int getWideReport(Student[] students) {
        int wideReport = MIN_WIDE_REPORT;
        int tmpWideReport = 0;

        for (Student currentStudent : students) {

            int lengthNameStudent = currentStudent.getStudentsName().length();
            int lengthStudentsCurriculum = currentStudent.getStudentsCurriculum().getNameCurriculum().length();

            if (lengthNameStudent > lengthStudentsCurriculum) {
                tmpWideReport = lengthNameStudent;
            } else {
                tmpWideReport = lengthStudentsCurriculum;
            }

            if ((tmpWideReport + LENGTH_WORD_CURRENT_DATE) > wideReport) {
                wideReport = tmpWideReport + LENGTH_WORD_CURRENT_DATE;
            }
        }
        return wideReport;
    }

    private static String getLine(int wideReport) {

        StringBuilder line = new StringBuilder(wideReport);
        for (int i = 0; i <= wideReport; i++) {
            line.append("-");
        }
        return line.toString();
    }

}
