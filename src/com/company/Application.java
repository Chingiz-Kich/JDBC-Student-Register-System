package com.company;

import com.company.controllers.StudentController;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Finally I create class Application which connect people who use this application
* I import my StudentContoller class to connect my users with PostgreSQL database to get all information
            through typing the correct number
* while (true) infinite loop. It means, my program will work till somebody press button zero(0)
* Through Scanner.scanner users can input numbers from 1-5 to work with my database
* All methods in this class should be void
*/

public class Application {
    private final StudentController controller;
    private final Scanner scanner;

    public Application(StudentController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all students");
            System.out.println("2. Get student by id");
            System.out.println("3. Create student");
            System.out.println("4. Update student");
            System.out.println("5. Delete student");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-5): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllStudentsMenu();
                } else if (option == 2) {
                    getStudentByIdMenu();
                } else if (option == 3) {
                    createStudentMenu();
                } else if (option == 4 ){
                    updateStudentByMenu();
                } else if (option == 5) {
                    deleteStudentByMenu();
                } else {
                    break;
                }
            } catch (InputMismatchException a) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }

    public void getAllStudentsMenu() {
        String response = controller.getAllStudents();
        System.out.println(response);
    }

    public void getStudentByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getStudent(id);
        System.out.println(response);
    }

    public void updateStudentByMenu() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter age");
        int age = scanner.nextInt();
        System.out.println("Please enter hometown");
        String hometown = scanner.next();

        controller.updateStudent(id, name, age, hometown);
    }

    public void deleteStudentByMenu() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();

        controller.deleteStudent(id);
    }

    public void createStudentMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter age");
        int age = scanner.nextInt();
        System.out.println("Please enter hometown");
        String hometown = scanner.next();

        String response = controller.createStudent(name, age, hometown);
        System.out.println(response);
    }
}
