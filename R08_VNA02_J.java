/******************************************************************************
*  Compilation:  javac R08_VNA02_J.java
*  Execution:    java R08_VNA02_J
*
*  Demonstrates how 'synchronized' keyword protects non-atomic writes to
*  shared variable in multithreaded environment
* 
******************************************************************************/

final class Flag {
  private boolean flag = true;

  public synchronized void toggle() {
    flag ^= true; // Same as flag = !flag;
  }

  public synchronized boolean getFlag() {
    return flag;
  }
}

class TaskModifyFlag implements Runnable {
    private Flag flag;

    public TaskModifyFlag(Flag flag) {
      this.flag = flag;
    }


    @Override
    public void run() {
      flag.toggle();
      System.out.println("Flag (inside): " + flag.getFlag());
    }
}

public class R08_VNA02_J {

  public static void main(String[] args) {
    Flag flag = new Flag();

    System.out.println("Flag: " + flag.getFlag());
    Thread t1 = new Thread(new TaskModifyFlag(flag));
    Thread t2 = new Thread(new TaskModifyFlag(flag));
    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
      System.out.println("Flag: " + flag.getFlag());
    } catch (Exception e) {
      // Ignoring error for this demo
    }
  }

}
