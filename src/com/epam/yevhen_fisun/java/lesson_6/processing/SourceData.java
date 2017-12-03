package com.epam.yevhen_fisun.java.lesson_6.processing;

import com.epam.yevhen_fisun.java.lesson_6.objects.Course;
import com.epam.yevhen_fisun.java.lesson_6.objects.Curriculum;
import com.epam.yevhen_fisun.java.lesson_6.objects.Student;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SourceData {
    public static Student[] init(Calendar currentTime) {
        Course[] courses=new Course[]{
                new Course("Java Starter",120),
                new Course("QA Manual",40),
                new Course("QA Automation", 50),
                new Course("Java Essential",10)};

        Curriculum development = new Curriculum("Java Development",courses[0],courses[3]);
        Curriculum qa = new Curriculum("Quality Assurance",courses[1],courses[2]);

        currentTime.set(Calendar.MILLISECOND,0);
        currentTime.set(Calendar.SECOND,0);
        currentTime.set(Calendar.MINUTE,0);
        Calendar studentStartTime1=new GregorianCalendar();
        Calendar studentStartTime2=new GregorianCalendar();
        Calendar studentStartTime3=new GregorianCalendar();

        studentStartTime1=(Calendar) currentTime.clone();
        studentStartTime2=(Calendar) currentTime.clone();
        studentStartTime3=(Calendar) currentTime.clone();
//        studentStartTime1.add(Calendar.DATE);
        Student[] students= new Student[] {
                new Student("Yevhen Fisun",qa,studentStartTime1),
                new Student("Ivan Ivanov",development,studentStartTime2)};
        return students;
    }
}

