import java.util.Scanner;

public class Solution {
  private final StringBuilder body;
  public static final int APPEND = 1;
  public static final int DELETE = 2;
  public static final int PRINT = 3;
  public static final int UNDO = 4;

  
  public Solution() {
    this.body = new StringBuilder();
  }

  /**
   * 
   * @param word to append at body
   */
  public void append(String word) {
    body.append(word);
  }

  /**
   * 
   * @param k number of characters to delete
   */
  public void delete(int k) {
    // TODO: case when n - k is negative
    int size = body.length();
    body.delete(size - k, body.length());
  }

  /**
   * 
   * @param k index of the character to print
   */
  public void print(int k) {
   System.out.println(body.charAt(k - 1)); 
  }

  /**
   * Undo the last (not previously undone) operation (append, delete), reverting
   * body to the state it was prior to that operation
   */
  public void undo() {

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