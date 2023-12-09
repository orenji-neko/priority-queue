// Main
package net.core;

public class App {

    public static void main(String[] args) {
        PriorityQueue priority = new PriorityQueue();

        priority.addPriority();
        priority.addPriority();
        priority.addImportantPriority();
        priority.addPriority();
        priority.addImportantPriority();

        priority.serveCounter(Counter.PRIORITY);
        System.out.println(priority);
    }
}
