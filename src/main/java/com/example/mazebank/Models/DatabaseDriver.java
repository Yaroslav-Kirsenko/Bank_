package com.example.mazebank.Models;

import java.sql.*;

public class DatabaseDriver {
    private Connection conn;

    DatabaseDriver(){
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:base.db");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

//    ClientSection

    public ResultSet getClientData(String pAddress, String password) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress='"+pAddress+"'AND Password= '"+password+"';'" );
        }catch (SQLException e){
            e.printStackTrace();
        }
    return resultSet;
    }
}
