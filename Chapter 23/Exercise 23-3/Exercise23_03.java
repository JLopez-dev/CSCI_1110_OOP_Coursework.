/*
Author: John Lopez.
Date: 11/09/2020.
*/

import java.util.Comparator;

public class Exercise23_03 {
  public static <E extends Comparable<E>> void quickSort(E[] list) {
    quickSort(list, 0, list.length - 1);
  }

  public static <E extends Comparable<E>>
  void quickSort(E[] list, int first, int last) {
    if (last > first) {
      int pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, last);
    }
  }

  public static <E extends Comparable<E>>
  int partition(E[] list, int first, int last) {
    E pivot = list[first];
    int low = first + 1;
    int high = last;

    while (high > low) {
      while (low <= high && list[low].compareTo(pivot) <= 0)
        low++;

      while (low <= high && list[high].compareTo(pivot) > 0)
        high--;

      if (high > low) {
        E temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

    while (high > first && list[high].compareTo(pivot) >= 0)
      high--;

    if (pivot.compareTo(list[high]) > 0) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    }
    else {
      return first;
    }
  }

  public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
    quickSort(list, 0, list.length - 1, comparator);
  }

  public static <E> void quickSort(
          E[] list, int first, int last, Comparator<? super E> comparator) {
    if (last > first) {
      int pivotIndex = partition(list, first, last, comparator);
      quickSort(list, first, pivotIndex - 1, comparator);
      quickSort(list, pivotIndex + 1, last, comparator);
    }
  }

  public static <E> int partition(
          E[] list, int first, int last, Comparator<? super E> comparator) {
    E pivot = list[first];
    int low = first + 1;
    int high = last;

    while (high > low) {
      while (low <= high && comparator.compare(list[low], pivot) <= 0)
        low++;

      while (low <= high && comparator.compare(list[high], pivot) > 0)
        high--;

      if (high > low) {
        E temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

    while (high > first && comparator.compare(list[high], pivot) >= 0)
      high--;

    if (comparator.compare(pivot, list[high]) > 0) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    }
    else {
      return first;
    }
  }

  public static void main(String[] args) {
    Integer[] intArray = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    Double[] doubleArray = {3.4, 1.3, -22.1, 14.8, 6.0, 2.3, 12.2};
    Character[] charArray = {'z', 'F', 's', 'C', 'k', 'L'};
    String[] stringArray = {"John", "Carl", "Tim", "Cindy", "Kate"};

    quickSort(intArray);
    quickSort(doubleArray);
    quickSort(charArray);
    quickSort(stringArray);

    printList(intArray);
    printList(doubleArray);
    printList(charArray);
    printList(stringArray);

    GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
            new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
            new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
            new Circle(6.5), new Rectangle(4, 5)};

    quickSort(list, new GeometricObjectComparator());

    printList(list);
  }

  public static void printList(Object[] list) {
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }
    System.out.println();
  }

  public static void printList(GeometricObject[] list) {
    System.out.print("Sorted elements: ");
    for (GeometricObject e: list) {
      System.out.printf("%.2f ", e.getArea());
    }
    System.out.println();
  }
}