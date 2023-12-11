// Window Implementations shall be here
package net.graphics;
import net.core.Counter;
import net.core.PriorityQueue;
import net.core.Queue;
import org.checkerframework.checker.units.qual.C;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private JButton autoAddPriorityButton, addPriorityButton, servePriorityButton;
    private  JComboBox<String> counterChoices;
    private PriorityQueue priorityQueue;
    private CounterWindow counterWindow;

    public Window(int width, int height) {
        counterWindow = new CounterWindow();
        // priority queue
        priorityQueue = new PriorityQueue();

        // auto add
        autoAddPriorityButton = new JButton("Auto Add Priority");
        autoAddPriorityButton.setBounds(new Rectangle(10, 10, 120, 30));
        autoAddPriorityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                priorityQueue.autoAddPriority();
                updateCounterWindow();
            }
        });

        // add Priority
        addPriorityButton = new JButton("Add Priority");
        addPriorityButton.setBounds(new Rectangle(10, 40, 120, 30));
        addPriorityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switch(counterChoices.getSelectedIndex()) {
                    case 0:
                        priorityQueue.addPriority(Counter.COUNTER1);
                        break;
                    case 1:
                        priorityQueue.addPriority(Counter.COUNTER2);
                        break;
                    case 2:
                        priorityQueue.addPriority(Counter.COUNTER3);
                        break;
                    case 3:
                        priorityQueue.addPriority(Counter.PRIORITY);
                        break;
                }
                updateCounterWindow();
            }
        });

        // combo box choice for serve
        counterChoices = new JComboBox<>(new String[]{"Counter 1", "Counter 2", "Counter 3", "Priority Lane"});

        // serve priority
        servePriorityButton = new JButton("Serve Counter");
        servePriorityButton.setBounds(new Rectangle(10, 80, 120, 30));
        servePriorityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switch(counterChoices.getSelectedIndex()) {
                    case 0:
                        priorityQueue.serveCounter(Counter.COUNTER1);
                        break;
                    case 1:
                        priorityQueue.serveCounter(Counter.COUNTER2);
                        break;
                    case 2:
                        priorityQueue.serveCounter(Counter.COUNTER3);
                        break;
                    case 3:
                        priorityQueue.serveCounter(Counter.PRIORITY);
                        break;
                }
                updateCounterWindow();
            }
        });

        // adding components in order
        add(counterChoices);
        add(autoAddPriorityButton);
        add(addPriorityButton);
        add(servePriorityButton);


        setSize(width, height);
        setResizable(false);
        setLayout(new FlowLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void updateCounterWindow() {
        int p1 = 0, p2 = 0, p3 = 0, vip = 0;
        if(!priorityQueue.getCounter(Counter.COUNTER1).isEmpty()) {
            p1 = priorityQueue.getCounter(Counter.COUNTER1).poll();
        }
        if(!priorityQueue.getCounter(Counter.COUNTER2).isEmpty()) {
            p2 = priorityQueue.getCounter(Counter.COUNTER2).poll();
        }
        if(!priorityQueue.getCounter(Counter.COUNTER3).isEmpty()) {
            p3 = priorityQueue.getCounter(Counter.COUNTER3).poll();
        }
        if(!priorityQueue.getCounter(Counter.PRIORITY).isEmpty()) {
            vip = priorityQueue.getCounter(Counter.PRIORITY).poll();
        }

        counterWindow.updateCounters(p1, p2, p3, vip);
    }
}
