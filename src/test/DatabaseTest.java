import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseManager {
    // Шлях до файлу бази даних SQLite
    private static final String DB_URL = "jdbc:sqlite:db/user_data.db";

    // Метод для встановлення з'єднання з базою даних
    public static Connection connect() {
        Connection conn = null;
        try {
            // Встановлюємо з'єднання
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Підключення до бази даних встановлено.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // Метод для створення таблиці користувачів
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " name TEXT NOT NULL,\n"
                + " email TEXT NOT NULL UNIQUE\n"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            // Виконуємо SQL-запит
            stmt.execute(sql);
            System.out.println("Таблиця створена або вже існує.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Метод для додавання нового користувача
    public static void insertUser(String name, String email) {
        String sql = "INSERT INTO users(name, email) VALUES(?, ?)";

        try (Connection conn = connect();
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            System.out.println("Користувача додано.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Метод для отримання всіх користувачів
    public static void selectAllUsers() {
        String sql = "SELECT * FROM users";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Проходимо по результатах запиту
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
