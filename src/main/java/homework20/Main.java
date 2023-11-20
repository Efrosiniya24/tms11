package homework20;

import java.sql.*;

public class Main {
//    Задача 1:
//    Реализовать CRUD операции для модели из вашего будущего проекта(или для User)


    //задание не запускается
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/User", "root", "1111");
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS user(id INT PRIMARY KEY , username VARCHAR(100) , phoneNumber VARCHAR(20))");

        User user1 = new User(1, "dasfg", "+27528343");
        User user2 = new User(2, "ergfdas", "+34637832");
        User user3 = new User(3, "zdfbsdase", "+354657654");

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (id, username, phoneNumber) VALUES (?, ?, ?)");
        preparedStatement.setInt(1, user1.getId());
        preparedStatement.setString(2, user1.getName());
        preparedStatement.setString(3, user1.getPhoneNumber());
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement("INSERT INTO user (id, username, phoneNumber) VALUES (?, ?, ?)");
        preparedStatement.setInt(1, user2.getId());
        preparedStatement.setString(2, user2.getName());
        preparedStatement.setString(3, user2.getPhoneNumber());
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement("INSERT INTO user (id, username, phoneNumber) VALUES (?, ?, ?)");
        preparedStatement.setInt(1, user3.getId());
        preparedStatement.setString(2, user3.getName());
        preparedStatement.setString(3, user3.getPhoneNumber());
        preparedStatement.executeUpdate();

        ResultSet rs = statement.executeQuery("SELECT * from user");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("username") + " " + rs.getString("phoneNumber"));
        }

        preparedStatement = connection.prepareStatement("UPDATE user SET username = ? WHERE id = ?");
        preparedStatement.setString(1, "NEEEEEEW1");
        preparedStatement.executeUpdate();

        rs = statement.executeQuery("SELECT * from user");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("username") + " " + rs.getString("phoneNumber"));
        }

        preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id = ?");
        preparedStatement.setString(1, "9");

        rs = statement.executeQuery("SELECT * from user");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("username") + " " + rs.getString("phoneNumber"));
        }
    }
}
