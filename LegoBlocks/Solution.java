import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

  /**
   * build a wall with the following characteristics:
   *   - no holes
   *   - no vertical breaks
   *   - bricks must be laid horizontally
   */
  public static int legoBlocks(int height, int width) {
    return 0 % (int) Math.pow(10, 9) + 7;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(reader.readLine().trim());
    for (int i = 0; i < testCases; i++) {
      String[] line = reader.readLine().trim().split(" ");
      int n = Integer.parseInt(line[0]);
      int m = Integer.parseInt(line[1]);
      System.out.println(String.valueOf(legoBlocks(n, m)));
    }
  }
}