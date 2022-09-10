import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution {
  private final ArrayDeque<String> words;
  public static final int APPEND = 1;
  public static final int DELETE = 2;
  public static final int PRINT = 3;
  public static final int UNDO = 4;

  public Solution() {
    words = new ArrayDeque<String>();
  }

  /**
   * 
   * @param word to append at body
   */
  public void append(String word) {
    String elem;
    if (words.isEmpty()) {
      elem = word;
    } else {
      elem = words.peek() + word;
    }
    words.push(elem);
  }

  /**
   * 
   * @param k number of characters to delete
   */
  public void delete(int k) {
    String prev = words.peek();
    int end = prev.length() - k;
    words.push(prev.substring(0, end));
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

  public static void main(String[] args) throws IOException {
    Solution editor = new Solution();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int numberOfOperations = Integer.parseInt(reader.readLine());

    for (int i = 0; i < numberOfOperations; i++) {
      String line = reader.readLine();
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
  }
}