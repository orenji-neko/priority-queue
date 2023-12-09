// Window Implementations shall be here
package net.graphics;
import javax.swing.*;

public class Window extends JFrame {
    public Window(int width, int height) {
        JLabel label = new JLabel();
        label.setText("hello world");
        label.setSize(50, 20);
        add(label);

        setSize(width, height);
        setLayout(null);
        setVisible(true);
    }
}
