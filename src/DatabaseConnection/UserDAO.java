package DatabaseConnection;

/**
 *
 * @author jGreggCode (https://github.com/jGreggCode)
 */

// Imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Data access object
public class UserDAO {
    
    Connection connection = null;
    
    // Validations
    public boolean isDuplicateAccountNumber(String accountNumber) {
        try {
            connection = DatabaseManager.getConnection();

            String query = "SELECT COUNT(*) FROM users WHERE accountNumber = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, accountNumber);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        System.out.println("SYSTEM LOG: When creating a new user, the generated account number has a duplicate. Generating again...");
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection);
        }
        return false;
    }
    
    public String getPasswordHashByUsername(String accountNumber) {
        try {
            connection = DatabaseManager.getConnection();

            String query = "SELECT accountPassword FROM users WHERE accountNumber = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, accountNumber);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("accountPassword");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection);
        }   
        
        return null;
    }
    
    public void getAllByUsername(String accountNumber) {
        try {
            connection = DatabaseManager.getConnection();

            String query = "SELECT `accountNumber`, `firstName`, `middleName`, `lastName`, `email`, `phoneNumber`, `birthdate`, `tin`, `primaryID`, `primaryIDNO`, `balance`  FROM users WHERE accountNumber = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, accountNumber);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Map ResultSet to User object
                        UserInstance userData = UserInstance.getInstance();
                        String accNo = resultSet.getString(1);
                        String firstName = resultSet.getString(2);
                        String middleName = resultSet.getString(3);
                        String lastName = resultSet.getString(4);
                        String email = resultSet.getString(5);
                        String phoneNumber = resultSet.getString(6);
                        String birthdate = resultSet.getString(7);
                        String tin = resultSet.getString(8);
                        String primaryID = resultSet.getString(9);
                        String primaryIDNO = resultSet.getString(10);
                        double balance = resultSet.getDouble(11);
                        
                        // Store User Information
                        userData.setUserInstance(accNo, firstName, middleName, lastName, email, phoneNumber, birthdate, tin, primaryID, primaryIDNO, balance);

                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection);
        }
    }
    
    // -------------------
    public User getUserByUsernameAndPassword(String accountNumber, String accountPassword) {
        

        try {
            connection = DatabaseManager.getConnection();

            String query = "SELECT * FROM users WHERE accountNumber = ? AND accountPassword = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, accountNumber);
                
                
                preparedStatement.setString(2, accountPassword);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Map ResultSet to User object
                        User user = new User();
                        user.setAccountNumber(resultSet.getString("accountNumber"));
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
    
    public void insert(String accountNumber, 
            String accountPassword, 
            String firstName, 
            String middleName, 
            String lastName, 
            String fullName, 
            String email, 
            String phoneNumber, 
            String birthdate, 
            String tin, 
            String primaryID, 
            String primaryIDNO, 
            double balance) {
        
        try {
            connection = DatabaseManager.getConnection();

            String query = "INSERT INTO users (accountNumber, accountPassword, firstName, middleName, lastName, fullName, email, phoneNumber, birthdate, tin, primaryID, primaryIDNO, balance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, accountNumber);
                preparedStatement.setString(2, accountPassword);
                preparedStatement.setString(3, firstName);
                preparedStatement.setString(4, middleName);
                preparedStatement.setString(5, lastName);
                preparedStatement.setString(6, fullName);
                preparedStatement.setString(7, email);
                preparedStatement.setString(8, phoneNumber);
                preparedStatement.setString(9, birthdate);
                preparedStatement.setString(10, tin);
                preparedStatement.setString(11, primaryID);
                preparedStatement.setString(12, primaryIDNO);
                preparedStatement.setDouble(13, balance);
                preparedStatement.executeUpdate();
            }
        }   catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection);
        }
    }
}