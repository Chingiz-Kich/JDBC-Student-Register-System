package com.company.repositories;

import com.company.entities.Student;

import java.util.List;

/* This Interface will help me work with PostgreSQL
* All of these methods related with CRUD */

public interface IStudentRepository {
    boolean createStudent(Student student);     // Just say whether Student (particular student in the parameter created or not
    Student getStudent(int id);                 // return Student which id was written in the parameter (id is Unique)
    void updateStudent(int id, String name, int age, String hometown);              // Update or change the info about Student who id was written in the parameter
    void deleteStudent(int id);              // Delete - equalize student's name, age and hometown, but id is not deleted
    List<Student> getAllStudents();             // return all Students that has our database
}
