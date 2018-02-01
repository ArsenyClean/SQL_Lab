package myApp;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.Random;

public class myApp4 {

    public myApp4(){

    }
    public void createUsers(String url, String username, String password) throws SQLException {

        try
        {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                char randomSym = (char) ('A' + new Random().nextInt(26));
                String FIO = "" + randomSym;
                int randomYear = random.nextInt(46) + 1967;
                int randomMounth = random.nextInt(12) + 1;
                int randomDay = random.nextInt(28) + 1;

                char randomSymb = (char) ('M' + new Random().nextInt(2));
                String Mal = "" + randomSymb;
                String query = "INSERT INTO someusers(FIO, Year, Male) VALUES ('" + FIO + "','" + randomYear + "-" + randomMounth + "-" + randomDay + "','" + Mal + "');";
                statement.execute(query);
            }

            for (int i = 0; i < 100; i++) {
                String FIO = "F";
                int randomYear = random.nextInt(46) + 1967;
                int randomMounth = random.nextInt(12) + 1;
                int randomDay = random.nextInt(28) + 1;

                String Mal = "M" ;
                String query = "INSERT INTO someusers(FIO, Year, Male) VALUES ('" + FIO + "','" + randomYear + "-" + randomMounth + "-" + randomDay + "','" + Mal + "');";
                statement.execute(query);

            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
