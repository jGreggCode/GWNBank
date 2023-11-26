package Utilities;

// Imports
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author jGreggCode (https://github.com/jGreggCode)
 */
public class UtilMethods {

    public ImageIcon imageResize(ImageIcon img, int width, int heigth) {
        Image imgToResize = img.getImage();
        Image imgResizing = imgToResize.getScaledInstance(width, heigth, Image.SCALE_SMOOTH);
        ImageIcon imgResized = new ImageIcon(imgResizing);
        return imgResized;
    }
    
}
