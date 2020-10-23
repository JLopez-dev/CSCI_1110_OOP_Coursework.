/* Author: John Lopez.
 * Date: 10/23/2020.
 */

public class Exercise24_05<E> {
    private java.util.LinkedList<E> list = new java.util.LinkedList<>();

    public void enqueue(E e) {
        list.addLast(e);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public int getSize() {
        return list.size();
    }

    @Override
    public String toString() {
        return "Queue: " + list.toString();
    }
}
