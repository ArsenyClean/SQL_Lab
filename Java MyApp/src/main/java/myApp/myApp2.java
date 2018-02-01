package myApp;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class myApp2 {

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

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите ФИО ");
            String FIO = input.readLine();
            System.out.println("Введите Год ");
            int Year = Integer.parseInt(input.readLine());
            System.out.println("Введите Месяц ");
            int Mounth = Integer.parseInt(input.readLine());
            System.out.println("Введите День ");
            int Day = Integer.parseInt(input.readLine());

            System.out.println("Введите Пол (M-муж,N-жен): ");
            String Male = input.readLine();

            String query = "insert into someusers(FIO, Year, Male) values ('"+ FIO + "','"+ Year +"-"+Mounth+"-"+ Day +"','"+ Male +"');";
            statement.execute(query);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
