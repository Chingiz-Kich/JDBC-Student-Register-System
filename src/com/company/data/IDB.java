package com.company.data;

import java.sql.Connection;
import java.sql.SQLException;

/*  Create Interface for my PostgresDB.java file */

public interface IDB {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
