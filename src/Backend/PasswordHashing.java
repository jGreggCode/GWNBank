package Backend;

/**
 *
 * @author jGreggCode (https://github.com/jGreggCode)
 */
import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashing {

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean checkPassword(String candidate, String hashed) {
        return BCrypt.checkpw(candidate, hashed);
    }
}
