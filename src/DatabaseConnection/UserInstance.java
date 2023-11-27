package DatabaseConnection;

/**
 *
 * @author jGreggCode (https://github.com/jGreggCode)
 */
public class UserInstance {
    // To store user information 
    private static UserInstance instance;

    private int accountID;
    private String accountNumber;
    private String accountPassword;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String birthdate;
    private String tin;
    private String primaryID;
    private String primaryIDNO;
    private double balance;
    
    private UserInstance() {
        
    }
    
    public static UserInstance getInstance() {
        if (instance == null) {
            instance = new UserInstance();
        }
        return instance;
    }
    
    public void setUserInstance(int accountID, String accountNumber, String accountPassword, String firstName, String middleName, String lastName, String fullName, String email, String phoneNumber, String birthdate, String tin, String primaryID, String primaryIDNO, double balance) {
        this.accountID = accountID;
        this.accountNumber = accountNumber;
        this.accountPassword = accountPassword;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
        this.tin = tin;
        this.primaryID = primaryID;
        this.primaryIDNO = primaryIDNO;
        this.balance = balance;
    }
    
    public void setUserInstance(String accountNumber, String firstName, String middleName, String lastName, String email, String phoneNumber, String birthdate, String tin, String primaryID, String primaryIDNO, double balance) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
        this.tin = tin;
        this.primaryID = primaryID;
        this.primaryIDNO = primaryIDNO;
        this.balance = balance;
    }
    
    public int getAccountID() {
        return accountID;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getTin() {
        return tin;
    }

    public String getPrimaryID() {
        return primaryID;
    }

    public String getPrimaryIDNO() {
        return primaryIDNO;
    }

    public double getBalance() {
        return balance;
    }
}
