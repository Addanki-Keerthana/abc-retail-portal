package com.abc.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
  // Docker Compose DB host is "mysql" (service name)
  private static final String URL =
      "jdbc:mysql://mysql:3306/retaildb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
  private static final String USER = "root";
  private static final String PASS = "rootpassword";

  public static Connection getConnection() throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");
    return DriverManager.getConnection(URL, USER, PASS);
  }
}