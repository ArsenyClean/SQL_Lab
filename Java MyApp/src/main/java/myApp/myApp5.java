package myApp;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.IOException;
import java.sql.*;
import java.util.Date;

public class myApp5 {

    public void myApp5() {

    }
    public void createUser(String url, String username, String password) throws IOException {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM someusers WHERE Male='M' AND FIO LIKE 'F%'";
            ResultSet res = statement.executeQuery(query);

            System.out.println("----------------------------------------------------------");
            System.out.println("|   ФИО               |        Дата      |Пол(M-муж,N-жен|");
            System.out.println("----------------------------------------------------------");
            while ( res.next()){
                String FIO = res.getString(1);
                Date date = res.getDate(2);
                String Male = res.getString(3);
                System.out.println("| " + FIO +  "   |    " + date + "   |   " + Male + " |");
            }

            System.out.println("-------------------------------------------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
