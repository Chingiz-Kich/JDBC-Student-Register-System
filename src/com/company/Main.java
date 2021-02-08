package com.company;

import com.company.controllers.StudentController;
import com.company.repositories.IStudentRepository;
import com.company.repositories.StudentRepository;
import com.company.data.IDB;
import com.company.data.PostgresDB;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();                                      // give concrete objects
        IStudentRepository repo = new StudentRepository(db);            // provide information from Database
        StudentController controller = new StudentController(repo);     // controller provide users to interact with database
        Application app = new Application(controller);                  // application is created by using repository
        app.start();                                                    // Running my application

    }
}