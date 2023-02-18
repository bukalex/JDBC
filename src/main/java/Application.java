import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "Olga2703";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {
            statement.setInt(1, 6);
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                String age = resultSet.getString("age");
                String cityID = resultSet.getString("city_id");

                System.out.println("first_name: " + firstName);
                System.out.println("last_name: " + lastName);
                System.out.println("gender: " + gender);
                System.out.println("age: " + age);
                System.out.println("city_id: " + cityID);
            }
        }
    }
}
