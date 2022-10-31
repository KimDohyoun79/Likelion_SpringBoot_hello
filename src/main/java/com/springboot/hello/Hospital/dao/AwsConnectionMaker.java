package com.springboot.hello.Hospital.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class AwsConnectionMaker implements ConnectionMaker{

    @Override
    public Connection makeConnection() throws SQLException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");
        //DB_HOST=jdbc:mysql://ec2-3-38-186-84.ap-northeast-2.compute.amazonaws.com/likelion-db;DB_USER=root;DB_PASSWORD=12345678
        Connection c = DriverManager.getConnection(dbHost, dbUser, dbPassword);
        return c;
    }
}



