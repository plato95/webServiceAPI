/*
Sourse:
* https://habr.com/ru/sandbox/146588/
* https://javarush.ru/groups/posts/2579-dobavljaem-bd-k-restful-servisu-na-spring-boot-chastjh-1




*/

package DBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public class TestConnection {
    public static final String USER_NAME = "postgres";
    public static final String PASSWORD = "An_19199706";
    public static final String URL = "jdbc:postgresql://localhost:5432/testBD"; // Указывается название БД, а не просто подключение.
    public static Statement statement;
    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void mainStart() throws ClassNotFoundException, SQLException, IOException {
        //Class.forName("com.postgres.cj.jdbc.Driver");

        /*statement.executeUpdate("CREATE TABLE carshop2 (" +
                "id serial primary key, " +
                "name varchar(38) not null, " +
                "name1 varchar (18) not null," +
                "name2 varchar (10) not null)");*/

        //statement.executeUpdate("INSERT INTO carshop2 (name, name1, name2) values ('Patrol', 12, 12)");         // <-ДОБАВЛЕНИЕ ДАННЫХ В ТАБЛИЦУ

        ResultSet resultSet = statement.executeQuery("SELECT * FROM carshop2");      //<- получение данных из таблицы

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " +
                    resultSet.getString(3) + " " +
                    resultSet.getString(4));
        }
    }
}