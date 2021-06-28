package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {
    String connectionUrl = "jdbc:mysql://localhost:3306/NotePad?serverTimeZone=UTC";
    String user = "root";
    String password = "Honeyzzz7@";


    private Connection connection;

    public DBHandler() {
        try {
            connection = DriverManager.getConnection(connectionUrl, user, password);
        } catch (SQLException e) {
            System.out.println("NotePad is unable to connect to data storage system");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
