package org.example.database;

import org.sql2o.Sql2o;

public class Database {
    //DATABASE CONNECTION
    private static final Sql2o connection = new Sql2o (

            "jdbc:postgresql://localhost:5432/wildlife_tracker",
            "postgres",
            "javaDB"
    );

    public static Sql2o getConnection() { return connection; }

}