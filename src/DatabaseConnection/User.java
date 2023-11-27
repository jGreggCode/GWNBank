package DatabaseConnection;

/**
 *
 * @author jGreggCode (https://github.com/jGreggCode)
 */
public class User {
    private String accountNumber;
    private String accountPassword;
    

    // Constructor
    public User(String accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.accountPassword = password;
    }
    
    public User() {
        
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return accountPassword;
    }

    public void setPassword(String password) {
        this.accountPassword = password;
    }
}
