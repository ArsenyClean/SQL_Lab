package myApp;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.IOException;
import java.sql.*;
import java.time.Period;
import java.util.Date;

public class myApp3 {

    public void showTable(String url, String username, String password) throws IOException {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            Date datee = new Date();
            System.out.println(datee);
            String query = "SELECT * FROM someusers ORDER BY FIO, Year;";
            ResultSet res = statement.executeQuery(query);

            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("|   ФИО               |        Дата      |Пол(M-муж,N-жен| Количество полных лет |");
            System.out.println("---------------------------------------------------------------------------------");
            while ( res.next()){
                String FIO = res.getString(1);
                Date date = res.getDate(2);
                String Male = res.getString(3);
                double period =  (datee.getTime() - date.getTime())/ ( 24 * 60 * 60 * 1000 * 365.25);
                System.out.println("| " + FIO +  "   |    " + date + "   | " + Male + " | " + (int) period + " |");
            }

            System.out.println("---------------------------------------------------------------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
