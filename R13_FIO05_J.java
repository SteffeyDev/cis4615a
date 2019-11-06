/******************************************************************************
*  Compilation:  javac R13_FIO05_J.java
*  Execution:    java R13_FIO05_J
*
*  Demonstrates the security issue with using CharBuffer.wrap instead
*  of copying the array into a new CharBuffer
* 
******************************************************************************/

import java.nio.*;

final class WrapNonCompliant {
  private char[] dataArray;

  public WrapNonCompliant() {
    dataArray = new char[10];
    String data = "HelloWorld";
    for (int i = 0; i < 10; i++)
      dataArray[i] = data.charAt(i);
  }

  public CharBuffer getBufferCopy() {
    return CharBuffer.wrap(dataArray);
  }
}

final class Wrap {
  private char[] dataArray;
 
  public Wrap() {
    dataArray = new char[10];
    String data = "HelloWorld";
    for (int i = 0; i < 10; i++)
      dataArray[i] = data.charAt(i);
  }
 
  public CharBuffer getBufferCopy() {
    CharBuffer cb = CharBuffer.allocate(dataArray.length);
    cb.put(dataArray);
    cb.rewind();
    return cb;
  }
}

public class R13_FIO05_J {

  public static void main(String[] args) {
    WrapNonCompliant wrapNonCompliant = new WrapNonCompliant();

    System.out.println("Non-Compliant");
    System.out.println("Original CharBuffer: " + wrapNonCompliant.getBufferCopy().toString());

    CharBuffer test = wrapNonCompliant.getBufferCopy();
    test.put("overwrite".toCharArray());
    test.rewind();

    System.out.println("Modified CharBuffer: " + test.toString());
    System.out.println("'Clean' CharBuffer: " + wrapNonCompliant.getBufferCopy().toString());
    System.out.println();

    Wrap wrapCompliant = new Wrap();

    System.out.println("Compliant");
    System.out.println("Original CharBuffer: " + wrapCompliant.getBufferCopy().toString());

    test = wrapNonCompliant.getBufferCopy();
    test.put("overwrite".toCharArray());
    test.rewind();

    System.out.println("Modified CharBuffer: " + test.toString());
    System.out.println("Clean CharBuffer: " + wrapCompliant.getBufferCopy().toString());
    System.out.println();
  }

}
