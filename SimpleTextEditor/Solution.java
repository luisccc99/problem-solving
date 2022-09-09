import java.util.Scanner;
import java.util.Stack;

public class Solution {
  private final Stack<String> words;
  public static final int APPEND = 1;
  public static final int DELETE = 2;
  public static final int PRINT = 3;
  public static final int UNDO = 4;

  public Solution() {
    words = new Stack<String>();
  }

  /**
   * 
   * @param word to append at body
   */
  public void append(String word) {
    String init = words.isEmpty() ? "" : words.peek();
    StringBuilder prev = new StringBuilder(init);
    prev.append(word);
    words.push(prev.toString());
  }

  /**
   * 
   * @param k number of characters to delete
   */
  public void delete(int k) {
    StringBuilder old = new StringBuilder(words.peek());
    words.push(old.delete(old.length() - k, old.length()).toString());
  }

  /**
   * 
   * @param k index of the character to print
   */
  public void print(int k) {
    System.out.println(words.peek().charAt(k - 1));
  }

  /**
   * Undo the last (not previously undone) operation (append, delete), reverting
   * body to the state it was prior to that operation
   */
  public void undo() {
    words.pop();
  }

  public static void main(String[] args) {
    Solution editor = new Solution();
    Scanner sc = new Scanner(System.in);
    int numberOfOperations = Integer.parseInt(sc.nextLine().trim());

    for (int i = 0; i < numberOfOperations; i++) {
      String line = sc.nextLine();
      int operation = Integer.parseInt(line.split(" ")[0]);
      switch (operation) {
        case Solution.APPEND:
          String word = line.split(" ")[1];
          editor.append(word);
          break;
        case Solution.DELETE:
          editor.delete(Integer.parseInt(line.split(" ")[1]));
          break;
        case Solution.PRINT:
          editor.print(Integer.parseInt(line.split(" ")[1]));
          break;
        case Solution.UNDO:
          editor.undo();
          break;
      }
    }

    sc.close();
  }
}