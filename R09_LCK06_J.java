/******************************************************************************
*  Compilation:  javac R09_LCK06_J.java
*  Execution:    java R09_LCK06_J
*
*  Demonstrates danger of using an instance lock when mutating a
*  static class variable from multiple threads
* 
******************************************************************************/

final class CountBoxesNonCompliant implements Runnable {
  private static volatile int counter;
  private final Object lock = new Object();
 
  @Override public void run() {
    synchronized (lock) {
      for (int i = 0; i < 1000000; i++)
        counter++;
      System.out.println("Counter (non-compliant): " + counter);
    }
  }
}

final class CountBoxes implements Runnable {
  private static int counter;
  private static final Object lock = new Object();
 
  @Override public void run() {
    synchronized (lock) {
      for (int i = 0; i < 1000000; i++)
        counter++;
      System.out.println("Counter (compliant): " + counter);
    }
  }
}

public class R09_LCK06_J {
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      new Thread(new CountBoxes()).start();
    }

    for (int i = 0; i < 10; i++) {
      new Thread(new CountBoxesNonCompliant()).start();
    }
  }
}
