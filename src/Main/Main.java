package Main;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author jGreggCode (https://github.com/jGreggCode)
 */
public class Main {
    public static void main(String args[]){
        try {
            UIManager.setLookAndFeel(new FlatLightLaf()); // Set FlatLaf light theme
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
}
