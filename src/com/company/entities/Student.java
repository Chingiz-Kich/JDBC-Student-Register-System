package com.company.entities;

/* Standard java class with 2 contructor, getters and setters
* There are all setters will never use in my application */

public class Student {
    private int id;
    private String name;
    private int age;
    private String hometown;

    /* I created simple constructor, methods and getters */

    public Student(int id, String name, int age, String hometown) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hometown = hometown;
    }

    public Student(String name, int age, String hometown) {
        this.name = name;
        this.age = age;
        this.hometown = hometown;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }


    @Override public String toString(){
        return "Student[ id = " + getId() + ", name = " + name + ", age = " + age + ", hometown = " + hometown + "]";
    }
}
