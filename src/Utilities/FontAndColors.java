package Utilities;

/**
 *
 * @author jGreggCode (https://github.com/jGreggCode)
 */
import java.awt.Color;

public class FontAndColors {
    
    /*
        General Color:
            Cyan Blue: #f56710
            Bluish Cyan: #45B1E8
            Picton Blue: #7F9EAD
    
            GrapeFruit: #DC381F
            GrapeFruit (Lighter): #EB897A
    
            Dark Orange: #FF8C00
    
        Buttons Color:
            Buttons Color 1: (Lighter) #fb8a02
            Buttons Color 2: (Regular) #f56710
            Buttons Color 2: (Darker) #ec3724
    */
    
    // Main Color = #f8c76c

    private final Color colorText = Color.black;
    private final Color generalColor1 = new Color(0xf56710);
    private final Color generalColor2 = new Color(0x45B1E8);
    
    private final Color btnRColor = new Color(0xf56710);
    private final Color btnLColor = new Color(0xfb8a02);
    private final Color btnDColor = new Color(0xec3724);
    
    private final String fontName = "Poppins";

    // Foreground
    public Color getColorText() {
        return colorText;
    }

    // Colors
    public Color getGeneralColor1() {
        return generalColor1;
    }

    public Color getGeneralColor2() {
        return generalColor2;
    }

    public Color getBtnRColor() {
        return btnRColor;
    }

    public Color getBtnLColor() {
        return btnLColor;
    }

    public Color getBtnDColor() {
        return btnDColor;
    }
    
    // Font
    public String getFontName() {
        return fontName;
    }
}
