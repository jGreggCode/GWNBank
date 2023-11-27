package Backend;

import java.security.SecureRandom;

/**
 *
 * @author jGreggCode (https://github.com/jGreggCode)
 */
public class Generate {
    
    // Define the characters allowed in the verification code
    private static final String CHARACTERS = "0123456789";
    private final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private final String DIGITS = "0123456789";

    private final String ALL_CHARACTERS = UPPER_CASE + LOWER_CASE + DIGITS;

    private static final int ACCOUNT_NUMBER_LENGTH = 12;
    
    SecureRandom random;
    
    // Generate random account number
    public String generateAccountNumber() {
        random = new SecureRandom();
        StringBuilder sb = new StringBuilder(ACCOUNT_NUMBER_LENGTH);
        for (int i = 0; i < ACCOUNT_NUMBER_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }
    
    // Generate Random Verification Code or OTP
    public String generateVerificationCode() {
        random = new SecureRandom();
        StringBuilder sb = new StringBuilder(5);
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(ALL_CHARACTERS.length());
            sb.append(ALL_CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }
    
    /* 
    * DOES: Generate random password
    * @parameter length - Length of password
    */
    public String generateRandomPassword(int length) {
        random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALL_CHARACTERS.length());
            sb.append(ALL_CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }
}
