package net.core;

public class PriorityQueue {
    Queue<Integer> counter1;
    Queue<Integer> counter2;
    Queue<Integer> counter3;
    Queue<Integer> important;
    int current;
    public PriorityQueue() {
        counter1 = new Queue<>();
        counter2 = new Queue<>();
        counter3 = new Queue<>();
        important = new Queue<>();

        current = 1;
    }

    /**
     * Automatically adds a priority according to the lengths of the three queues.
     */
    public void autoAddPriority() {
        int a = counter1.length();
        int b = counter2.length();
        int c = counter3.length();

        // lowest among three
        if(a < b && a < c)
            counter1.enqueue(current);
        else if(b < a && b < c)
            counter2.enqueue(current);
        else if(c < a && c < b)
            counter3.enqueue(current);
        else if(a > b && a > c && b == c)
            counter2.enqueue(current);
        else
            counter1.enqueue(current);

        // increment
        current++;
    }
    public void addPriority(Counter counter) {
        switch(counter) {
            case COUNTER1:
                counter1.enqueue(current++);
                break;
            case COUNTER2:
                counter2.enqueue(current++);
                break;
            case COUNTER3:
                counter3.enqueue(current++);
                break;
            case PRIORITY:
                important.enqueue(current++);
                break;
        }
    }

    public void addImportantPriority() {
        important.enqueue(current++);
    }
    public void serveCounter(Counter counter) {
        switch(counter) {
            case COUNTER1:
                counter1.dequeue();
                break;
            case COUNTER2:
                counter2.dequeue();
                break;
            case COUNTER3:
                counter3.dequeue();
                break;
            case PRIORITY:
                important.dequeue();
                break;
        }
    }
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Counter 1: ").append(counter1.toString().concat("\n"));
        buffer.append("Counter 2: ").append(counter2.toString().concat("\n"));
        buffer.append("Counter 3: ").append(counter3.toString().concat("\n"));
        buffer.append("Priority Lane: ").append(important.toString().concat("\n"));
        return buffer.toString();
    }
    public Queue<Integer> getCounter(Counter counter) {
        switch(counter) {
            case COUNTER1:
                return counter1;
            case COUNTER2:
                return counter2;
            case COUNTER3:
                return counter3;
            case PRIORITY:
                return important;
            default:
                return null;
        }
    }
}