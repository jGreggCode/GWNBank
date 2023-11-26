package Connection;

/**
 *
 * @author jGreggCode (https://github.com/jGreggCode)
 */

// Imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public User getUserByUsernameAndPassword(String username, String password) {
        Connection connection = null;

        try {
            connection = DatabaseManager.getConnection();

            String query = "SELECT * FROM users WHERE accountNumber = ? AND accountPassword = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Map ResultSet to User object
                        User user = new User();
                        user.setUsername(resultSet.getString("accountNumber"));
                        user.setPassword(resultSet.getString("accountPassword"));
                        // Add other properties as needed

                        return user;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection);
        }

        return null; // User not found
    }
}