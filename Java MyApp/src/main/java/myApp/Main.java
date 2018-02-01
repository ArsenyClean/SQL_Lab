package myApp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "rout";

    public static void main (String [] args) throws IOException, SQLException {


        System.out.println("Для создания таблицы (с полями: ФИО, Возраст, Пол) нажмите: 1 " +
                "\nДля добавления пользователя нажмите: 2" +
                "\nДля просмотра пользователей нажмите:  3" +
                "\nДля создания псевдопользователей нажмите: 4" +
                "\nДля вывода всех мужчин с фамилией, начинающейся на F, нажмите: 5" +
                "\nДля удаления таблицы нажмите: 7");

        int flag = 10;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        flag = Integer.parseInt(input.readLine());

        while (flag != 0){
            switch (flag){
                case 1:{
                    myApp1 myapp1 = new myApp1();
                    myapp1.createTable(URL, USERNAME, PASSWORD );
                    break;
                }
                case 2:{
                    myApp2 myapp2 = new myApp2();
                    myapp2.createUser(URL, USERNAME, PASSWORD);
                    break;
                }
                case 3: {
                    myApp3 myapp3 = new myApp3();
                    myapp3.showTable(URL, USERNAME, PASSWORD);
                    break;
                }
                case 4: {
                    myApp4 myapp4 = new myApp4();
                    myapp4.createUsers(URL, USERNAME, PASSWORD);
                    break;
                }
                case 5:{
                    long start = System.currentTimeMillis();
                    myApp5 myapp5 = new myApp5();
                    myapp5.createUser(URL, USERNAME, PASSWORD);
                    long end = System.currentTimeMillis() - start;
                    System.out.println("Время выполнения поиска составило: " + end + " миллисекунд\n");
                    break;
                }
                case 6:{

                    break;
                }
                case 7:{
                    myApp7 myapp7 = new myApp7();
                    myapp7.dropTable(URL, USERNAME, PASSWORD);
                    break;
                }
                case 8:{

                    break;
                }

            }
            System.out.println("Для создания таблицы (с полями: ФИО, Возраст, Пол) нажмите: 1 " +
                    "\nДля добавления пользователя нажмите: 2" +
                    "\nДля просмотра пользователей нажмите:  3" +
                    "\nДля создания псевдопользователей нажмите: 4" +
                    "\nДля вывода всех мужчин с фамилией, начинающейся на F, нажмите: 5" +
                    "\nДля удаления таблицы нажмите: 7");
            flag = Integer.parseInt(input.readLine());
        }

    }

}
