package myApp;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.IOException;
import java.sql.*;

public class myApp7 {

    public void dropTable(String url, String username, String password) throws IOException {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String query = "DROP TABLE someusers;";
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
