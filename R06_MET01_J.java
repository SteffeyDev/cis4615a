/******************************************************************************
*  Compilation:  javac R06_MET01_J.java
*  Execution:    java R06_MET01_J
*
*  Calls function getAbsAdd(x,y) with legal and illegal values
* 
******************************************************************************/

public class R06_MET01_J {

  public static void main(String[] args) {

    try {
      int result = getAbsAdd(5, 10);
      System.out.println("Result (control): " + result);
    } catch (IllegalArgumentException e) {
      System.out.println("Illegal Arguments (control)");
    }

    try {
      int result = getAbsAdd(Integer.MIN_VALUE, 10);
      System.out.println("Result (x_min_value): " + result);
    } catch (IllegalArgumentException e) {
      System.out.println("Illegal Arguments (x_min_value)");
    }

    try {
      int result = getAbsAdd(5, Integer.MIN_VALUE);
      System.out.println("Result (y_min_value): " + result);
    } catch (IllegalArgumentException e) {
      System.out.println("Illegal Arguments (y_min_value)");
    }

    try {
      int result = getAbsAdd(Integer.MAX_VALUE - 10, Integer.MAX_VALUE - 200);
      System.out.println("Result (overflow): " + result);
    } catch (IllegalArgumentException e) {
      System.out.println("Illegal Arguments (overflow)");
    }

  }

  public static int getAbsAdd(int x, int y) {
    if (x == Integer.MIN_VALUE || y == Integer.MIN_VALUE) {
      throw new IllegalArgumentException();
    }
    int absX = Math.abs(x);
    int absY = Math.abs(y);
    if (absX > Integer.MAX_VALUE - absY) {
      throw new IllegalArgumentException();
    }
    return absX + absY;
  }

}
