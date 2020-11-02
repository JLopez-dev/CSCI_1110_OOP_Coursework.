/* Author: John Lopez.
 * Date: 11/02/2020.
 */
import java.util.*;

public class Exercise22_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
            System.out.println("Enter a string s1: ");
            String s1 = input.nextLine();
            System.out.println("Enter a string s2: ");
            String s2 = input.nextLine();

            int index = -1;
            int count = 0;

            for(int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) == s2.charAt(0) && count == 0) {
                    index = i;
                    count++;
                }
                else if (s1.charAt(i) == s2.charAt(count)) {
                    count++;
                }
                else {
                    count = 0;
                    index = -1;
                }
                if (count == s2.length()) {
                    break;
                }
            }
        if (index >= 0){
            System.out.println("Match at index " + index);
        }
        else {
            System.out.println("Error");
        }
    }
}