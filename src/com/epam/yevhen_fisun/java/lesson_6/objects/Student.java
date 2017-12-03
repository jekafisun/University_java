package com.epam.yevhen_fisun.java.lesson_6.objects;

import com.epam.yevhen_fisun.java.lesson_6.processing.Time;

import java.util.Calendar;

public class Student {
    private String studentsName;
    private Curriculum studentsCurriculum;
    private Calendar startDate;
    private Calendar endDate;

    public Student(String studentsName, Curriculum studentsCurriculum, Calendar startDate) {
        this.studentsName = studentsName;
        this.studentsCurriculum = studentsCurriculum;
        this.startDate = Time.getStartDate(startDate);
        this.endDate = Time.getEndDate(startDate, studentsCurriculum);
    }

    public String getStudentsName() {
        return studentsName;
    }

    public void setStudentsName(String studentsName) {
        this.studentsName = studentsName;
    }

    public Curriculum getStudentsCurriculum() {
        return studentsCurriculum;
    }

    public void setStudentsCurriculum(Curriculum studentsCurriculum) {
        this.studentsCurriculum = studentsCurriculum;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }
    @Override
    public String toString(){
        return "Student - "+studentsName+", curriculum - "+studentsCurriculum.getNameCurriculum();
    }
}
