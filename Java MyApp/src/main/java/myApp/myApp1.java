package myApp;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.io.IOException;
import java.sql.*;

public class myApp1 {

    public void createTable(String url, String username, String password) throws IOException {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String query = "CREATE TABLE someusers (FIO VARCHAR(45), Year DATE, Male VARCHAR(45))";
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
