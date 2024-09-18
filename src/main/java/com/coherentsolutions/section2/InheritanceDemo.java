package com.coherentsolutions.section2;

public class InheritanceDemo {

    public static void main(String[] args) {
        Student student = new Student();
        student.name = "Alice";
        student.age = 20;
        student.studentID = 1001;

        student.displayStudentInfo();
    }

    static class Person {
        String name;
        int age;

        void displayInfo() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    static class Student extends Person {
        int studentID;

        void displayStudentInfo() {
            displayInfo();
            System.out.println("Student ID: " + studentID);
        }
    }
}
