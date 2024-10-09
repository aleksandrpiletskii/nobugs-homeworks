package org.example.homeworks.student;

public class Student implements Printablee {
    private String studentName;
    private int gradeBookNumber;
    private int averageGrade;

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setGradeBookNumber(int gradeBookNumber) {
        this.gradeBookNumber = gradeBookNumber;
    }

    public int getBookAuthor() {
        return this.gradeBookNumber;
    }

    public void setAverageGrade(int averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getAverageGrade() {
        return this.averageGrade;
    }

    @Override
    public void print() {
        System.out.println("Student name is " + this.studentName + ", grade book number is " +
                this.gradeBookNumber + ", average grade is " + this.averageGrade);
    }
}