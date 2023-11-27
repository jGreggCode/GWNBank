package ModifiedComponents.ComboBox;

import java.awt.Color;
import javax.swing.JComboBox;

public class ComboBoxSuggestion<E> extends JComboBox<E> {

    public ComboBoxSuggestion() {
        setUI(new ComboSuggestionUI());
        this.setBackground(new Color(240,240,240));
    }
    
}
