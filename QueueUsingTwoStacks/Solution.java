import java.util.Scanner;
import java.util.Stack;

public class Solution {
  public static final int ENQUEUE = 1;
  public static final int DEQUEUE = 2;
  public static final int PRINT_FIRST_ELEMENT = 3;
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int numQueries = Integer.parseInt(in.nextLine().trim());
    
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    
    for (int i = 0; i < numQueries; i++) {
      String line = in.nextLine();
      int query = Integer.parseInt(line.split(" ")[0]);
      if (query == Solution.ENQUEUE) {
        int x = Integer.parseInt(line.split(" ")[1]);
        s1.push(x);
      } else if (query == Solution.DEQUEUE) {
        if (!s2.isEmpty()) {
          s2.pop();
        } else {
          s2.addAll(s1);
          s1.clear();
          s2.pop();
        }
      } else if (query == Solution.PRINT_FIRST_ELEMENT) {
        System.out.println(s2.peek());
      }
    } 
    in.close();
  }
}