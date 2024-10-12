package org.example;

import org.example.homeworks.book.Book;
import org.example.homeworks.car.Car;
import org.example.homeworks.clock.Clock;
import org.example.homeworks.student.Student;
import org.example.homeworks.points.Point;
import org.example.task1.BankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        account1.setBalance(1000);
        account1.print();

        Book book = new Book();
        book.setBookName("It");
        book.setBookAuthor("King");
        book.setPublicationDate(1986);
        book.print();

        Student student = new Student();
        student.setStudentName("Alex");
        student.setGradeBookNumber(34);
        student.setAverageGrade(4);
        student.print();

        Point point = new Point();
        point.setX(1);
        point.setY(2);
        point.moveUp();
        point.moveDown();
        point.moveLeft();
        point.moveRight();

        Clock clock = new Clock();
        clock.setHours(2);
        clock.setMinutes(2);
        clock.setSeconds(2);
        clock.readTime();
        clock.tick();

        Car car = new Car();
        car.setCarBrand("Kia");
        car.setCarModel("Spectra");
        car.setCarReleaseDate(2007);
        car.drive(165000);
    }
}
