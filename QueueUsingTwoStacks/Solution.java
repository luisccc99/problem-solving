import java.util.Scanner;
import java.util.Stack;

public class Solution {
  public static final int ENQUEUE = 1;
  public static final int DEQUEUE = 2;
  public static final int PRINT_FIRST_ELEMENT = 3;

  private static void move(Stack<Long> from, Stack<Long> to) {
    while (!from.isEmpty()) {
      to.push(from.pop());
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numQueries = Integer.parseInt(scanner.nextLine().trim());

    Stack<Long> s1 = new Stack<Long>();
    Stack<Long> s2 = new Stack<Long>();

    for (int i = 0; i < numQueries; i++) {
      String line = scanner.nextLine();
      int query = Integer.parseInt(line.split(" ")[0]);
      if (query == Solution.ENQUEUE) {
        long x = Long.parseLong(line.split(" ")[1]);
        if (s1.isEmpty() && s2.isEmpty()) {
          s2.push(x);
        } else {
          s1.push(x);
        }
      } else if (query == Solution.DEQUEUE) {
        if (s2.isEmpty()) {
          move(s1, s2);
        }
        s2.pop();
      } else if (query == Solution.PRINT_FIRST_ELEMENT) {
        if (s2.isEmpty()) {
          move(s1, s2);
        }
        System.out.println(s2.peek());
      }
    }
    scanner.close();
  }
}