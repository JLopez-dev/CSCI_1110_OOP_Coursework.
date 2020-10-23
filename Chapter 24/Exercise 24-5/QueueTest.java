/* Author: John Lopez.
 * Date: 10/23/2020.
 */

public class QueueTest {
    public static void main(String[] args) {
        Exercise24_05<String> queue = new Exercise24_05<>();

        queue.enqueue("Tom");
        System.out.println("(1) " + queue);

        queue.enqueue("Susan");
        System.out.println("(2) " + queue);

        queue.enqueue("Kim");
        queue.enqueue("Michael");
        System.out.println("(3) " + queue);

        System.out.println("(4) " + queue.dequeue());
        System.out.println("(5) " + queue.dequeue());
        System.out.println("(6) " + queue);
    }
}

