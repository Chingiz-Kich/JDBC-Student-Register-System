package com.company.controllers;

import com.company.entities.Student;
import com.company.repositories.IStudentRepository;

import java.util.List;

/* This class is connecting link between users input and database system
* each method from this class connect Student Repository and Application class
*  all input from 'Application' class go through methods of this class to
* Student Repository, and changes are executed in the database */

public class StudentController {
    private final IStudentRepository repo;

    /* Controllers take a reference from outside */

    public StudentController(IStudentRepository repo) {
        this.repo = repo;
    }

    /* Then I create all API */

    public String createStudent(String name, int age, String hometown) {
        Student student = new Student(name, age, hometown);

        boolean created = repo.createStudent(student);

        return (created ? " Student was created!" : "Student creation was failed!");
    }

    public String getStudent(int id) {
        Student student = repo.getStudent(id);

        return (student == null ? "Student was not found!" : student.toString());
    }

    public void updateStudent(int id, String name, int age, String hometown) {
        repo.updateStudent(id, name, age, hometown);
        System.out.println("Updated!");
    }

    public void deleteStudent(int id) {
        repo.deleteStudent(id);
        System.out.println("Deleted!");
    }

    public String getAllStudents() {
        List<Student> students = repo.getAllStudents();

        return students.toString();
    }
}
