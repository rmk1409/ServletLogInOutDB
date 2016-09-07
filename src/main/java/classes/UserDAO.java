package classes;

import java.sql.*;

/**
 * Created by Roma on 07.09.2016.
 */
public class UserDAO {
    public static Connection getConnection() {
        Connection result = null;

        try {
            Class.forName("org.postgresql.Driver");
            result = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean validateLoginData(String userLogin, String userPassword) {
        boolean result = false;

        Connection connection = null;
        try {
            connection = UserDAO.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM login_app WHERE login = ? AND password = ?");

            statement.setString(1, userLogin);
            statement.setString(2, userPassword);

            result = statement.executeQuery().next();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static boolean validateRegisterData(String login) {
        boolean result = false;

        Connection connection = null;
        try {
            connection = UserDAO.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM login_app WHERE login = ?");

            statement.setString(1, login);

            result = !statement.executeQuery().next();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static boolean addUser(User user) {
        boolean result = false;

        Connection connection = null;
        try {
            connection = UserDAO.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO login_app (login, password, info_1, info_2, info_3) VALUES (?,?,?,?,?)");

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getCitizenship());
            statement.setString(4, user.getInterests());
            statement.setString(5, user.getMoreInterests());

            result = statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static User getUser(String login) {
        User result = null;

        Connection connection = null;
        try {
            connection = UserDAO.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM login_app where login = ?");

            statement.setString(1, login);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            result = new User(resultSet.getInt("id"), resultSet.getString("login")
                    , resultSet.getString("password"), resultSet.getString("info_1")
                    , resultSet.getString("info_2"), resultSet.getString("info_3"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
