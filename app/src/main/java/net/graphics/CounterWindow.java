package net.graphics;

import javax.swing.*;
import java.awt.*;

public class CounterWindow extends JPanel{
    JFrame frame;
    Font font;
    String counter1, counter2, counter3, important;
    public CounterWindow() {
        counter1 = "";
        counter2 = "";
        counter3 = "";
        important = "";

        frame = new JFrame("Counter Window");
        frame.add(this);
        frame.setSize(550, 250);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public void updateCounters(int p1, int p2, int p3, int vip) {
        counter1 = String.valueOf(p1);
        counter2 = String.valueOf(p2);
        counter3 = String.valueOf(p3);
        important = String.valueOf(vip);

        repaint();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        font = g.getFont().deriveFont(g.getFont().getSize() * 1.4f);
        g.setFont(font);
        // font settings
        Graphics2D graphics = (Graphics2D) g;
        // headlines
        graphics.drawString("Counter 1", 10, 20);
        graphics.drawString("Counter 2", 100, 20);
        graphics.drawString("Counter 3", 200, 20);
        graphics.drawString("Priority Lane", 300, 20);
        // priority numbers
        graphics.drawString(counter1, 10, 40);
        graphics.drawString(counter2, 100, 40);
        graphics.drawString(counter3, 200, 40);
        graphics.drawString(important, 300, 40);
    }
}
