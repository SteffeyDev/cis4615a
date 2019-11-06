/******************************************************************************
*  Compilation:  javac R04_STR03_J.java
*  Execution:    java R04_STR03_J
*
*  Demonstrates the the issues with using toByteArray in serializing
*  BigIntegers and converting the back
* 
******************************************************************************/

import java.math.*;

public class R04_STR03_J {

  public static void main(String[] args) {
    String num = "530500452766";

    System.out.println("Control:       " + num);
    System.out.println("Compliant:     " + compliant(num));
    System.out.println("Non-Compliant: " + nonCompliant(num));
  }

  public static BigInteger nonCompliant(String num) {
    BigInteger x = new BigInteger(num);
    byte[] byteArray = x.toByteArray();
    String s = new String(byteArray);
    byteArray = s.getBytes();
    return new BigInteger(byteArray);
  }

  public static BigInteger compliant(String num) {
    BigInteger x = new BigInteger(num);
    String s = x.toString();  // Valid character data
    byte[] byteArray = s.getBytes();
    String ns = new String(byteArray);
    return new BigInteger(ns);
  }
}

