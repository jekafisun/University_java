package com.epam.yevhen_fisun.java.lesson_6.objects;

public class Curriculum {
    private String nameCurriculum;
    private Course[] coursesInCurriculum;
    private int sumDuration;

    public Curriculum(String nameCurriculum, Course... courses) {
        this.nameCurriculum = nameCurriculum;
        this.sumDuration = 0;
        int i = courses.length;
        this.coursesInCurriculum=new Course[i];
        for (int j = 0; j < i; j++) {
            this.coursesInCurriculum[j] = new Course(courses[j].getCourseName(),courses[j].getCourseDuration());
            this.sumDuration += courses[j].getCourseDuration();
        }
    }

    public String getNameCurriculum() {
        return nameCurriculum;
    }

    public void setNameCurriculum(String nameCurriculum) {
        this.nameCurriculum = nameCurriculum;
    }

    public Course[] getCourseInCurriculum() {
        return coursesInCurriculum;
    }

    public int getSumDuration() {
        return sumDuration;
    }
}
