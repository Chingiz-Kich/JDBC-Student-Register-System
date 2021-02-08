package com.company.repositories;

import com.company.data.IDB;
import com.company.entities.Student;
import com.company.repositories.IStudentRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;



/*
* Connection con - create connection with my database
* After that I use methods from sql library
* Through "PreparedStatement st = con.prepareStatement" I made all actions with my database -> INSERT, DELETE, UPDATE
    By using SQL command. For example, "UPDATE student SET name=?, age=?, hometown=? WHERE id=?"
    Every question mark(?) will be binded to set interaction between users input and database
* To bind every question mark(?) - I used methods "set" of class "PrepareStatement to get access to my database.
* st.setInt(1,id);
  st.setString(2, name);
  st.setInt(3, age);
  st.setString(4, hometown);
    "execute" method from class PreparedStatement running my command in java in the SQL system.

* If something go wrong, I catch several possible exception in my catch blocks
* Finally I close the connection through method close()
* All of these I have done for every method that I declared in my IStudentRepository interface
 */


public class StudentRepository implements IStudentRepository{
    private final IDB db;

    public StudentRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createStudent(Student student) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO student(name,age,hometown) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, student.getName());
            st.setInt(2, student.getAge());
            st.setString(3, student.getHometown());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Student getStudent(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,age,hometown FROM student WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Student student = new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("hometown"));

                return student;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public void updateStudent(int id, String name, int age, String hometown) {
        Connection con = null;
        try {
            con = db.getConnection();
            PreparedStatement st = con.prepareStatement("UPDATE student SET name=?, age=?, hometown=? WHERE id = ?");

            st.setString(1, name);
            st.setInt(2, age);
            st.setString(3, hometown);
            st.setInt(4, id);
            st.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteStudent(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            PreparedStatement st = con.prepareStatement("DELETE FROM student where id=?");
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }

    @Override
    public List<Student> getAllStudents() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,age,hometown FROM student";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Student> students = new LinkedList<>();
            while (rs.next()) {
                Student student = new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("hometown"));

                students.add(student);
            }

            return students;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
