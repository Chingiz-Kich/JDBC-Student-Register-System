package com.company.data;

import com.company.data.IDB;

import java.sql.*;

public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        /* Here I connect my Java file with Postgres SQL file */
        String connectionUrl = "jdbc:postgresql://localhost:5432/student";
        try {
            // Here I load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "postgres");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
