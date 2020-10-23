/*	Author: John Lopez.
 *	Date: 10/21/2020.
 */

import java.util.Iterator;
import java.util.ListIterator;

class Exercise24_03 {
	public static void main(String[] args) {
		Integer[] list = {1, 2, 3, 4};
		TwoWayLinkedList<Integer> linkedList = new TwoWayLinkedList<>(list);

		System.out.println(linkedList);
		System.out.println(linkedList.getFirst());
		System.out.println(linkedList.getLast());

		linkedList.addFirst(50);
		System.out.println(linkedList);

		linkedList.addLast(100);
		System.out.println(linkedList);

		linkedList.add(1, 2);
		System.out.println(linkedList);
		linkedList.add(3, 4);
		System.out.println(linkedList);
		linkedList.add(5, 6);
		System.out.println(linkedList);

		System.out.println(linkedList.removeFirst());
		System.out.println(linkedList);

		System.out.println(linkedList.removeLast());
		System.out.println(linkedList);

		System.out.println(linkedList.remove(3));
		System.out.println(linkedList);

		System.out.println(linkedList.contains(1));
		System.out.println(linkedList.contains(2));

		System.out.println(linkedList.size());

		System.out.println(linkedList.get(3));
		System.out.println(linkedList.get(4));
		System.out.println(linkedList.get(5));

		linkedList.addFirst(100);
		System.out.println(linkedList);

		System.out.println(linkedList.indexOf(100));
		System.out.println(linkedList.lastIndexOf(100));
		System.out.println(linkedList.indexOf(2));

		linkedList.set(2, 4);
		System.out.println(linkedList);

		Iterator<Integer> inter = linkedList.iterator();
		while (inter.hasNext()) {
			System.out.print(inter.next() + " ");
		}
		System.out.println();

		ListIterator<Integer> listInter = linkedList.listIterator();
		System.out.println(listInter.nextIndex());
		int count = 0;
		while (listInter.hasNext() && count < 4) {
			System.out.print(listInter.nextIndex() + ": " + listInter.next() + " ");
			count++;
		}
		System.out.println();

		while (listInter.hasPrevious()) {
			System.out.print(listInter.previousIndex() + ": " +
					listInter.previous() + " ");
		}
		System.out.println();

		System.out.println(listInter.nextIndex());
		System.out.println(listInter.previousIndex());

		linkedList.clear();
		System.out.println(linkedList);
	}
}