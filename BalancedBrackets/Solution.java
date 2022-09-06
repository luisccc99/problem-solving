import java.util.Stack;

public class Solution {

  /**
   * 
   * @param s string of brackets: (, ), {, }, [, ]
   * @return YES if string of brackets is balanced or NO if it's not
   */
  public static String isBalanced(String s) {
    if (s.length() < 2) {
      return "NO";
    }
    
    Stack<Character> brackets = new Stack<>();
    char[] closingBrackets = { ')', ']', '}' };
    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      if (isIn(current, closingBrackets)) {
        if (brackets.isEmpty()) {
          return "NO";
        }
        char top = brackets.pop();
        if (top == '(' && current == ')') {
          continue;
        } else if (top == '[' && current == ']') {
          continue;
        } else if (top == '{' && current == '}') {
          continue;
        } else {
          return "NO";
        }
      } else {
        brackets.push(current);
      }
    }
    if (!brackets.isEmpty()) {
      return "NO";
    }
    return "YES";
  }

  private static boolean isIn(char key, char[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (key == arr[i]) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(isBalanced("}][}}(}][))]")); // NO
    System.out.println(isBalanced("{{}(")); // NO
    System.out.println(isBalanced("({}([][]))[]()")); // YES
  }
}