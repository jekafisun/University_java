package com.epam.yevhen_fisun.java.lesson_6;

import com.epam.yevhen_fisun.java.lesson_6.objects.Student;
import com.epam.yevhen_fisun.java.lesson_6.processing.LongReport;
import com.epam.yevhen_fisun.java.lesson_6.processing.ShortReport;
import com.epam.yevhen_fisun.java.lesson_6.processing.SourceData;

import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class AppLogic {
    public static void startApp(Calendar currentTime) {

        Student[] students = SourceData.init(currentTime);

        ShortReport.printReport(students,currentTime);
        LongReport.printReportLong(students,currentTime);

//        switch (arg) {
//
//            case "0":
//                ReportShort.printReportShort(students, currentTime, rbEN);
//
//                break;
//
//            case "1":
//                ReportLong.printReportLong(students, currentTime, rbEN);
//                break;
//
//            case "2":
//                ReportShort.printReportShort(students, currentTime, rbRU);
//                break;
//
//            case "3":
//                ReportLong.printReportLong(students, currentTime, rbRU);
//
//                break;
//
//            default:
//                ReportShort.printReportShort(students, currentTime, rbEN);
//                ReportLong.printReportLong(students, currentTime, rbEN);
//                ReportShort.printReportShort(students, currentTime, rbRU);
//                ReportLong.printReportLong(students, currentTime, rbRU);
//
//        }

    }

}
