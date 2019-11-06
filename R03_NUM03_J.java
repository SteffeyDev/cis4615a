/******************************************************************************
*  Compilation:  javac R03_NUM03_J.java
*  Execution:    java R03_NUM03_J
*
*  Calls function getIntegerCompliant(is) and getIntegerNonCompliant(is) to
*  demonstrate effectiveness of compliant solution
* 
******************************************************************************/

import java.io.*;

public class R03_NUM03_J {

  public static void main(String[] args) throws IOException {
    long num = 0xFF010203L; // This value is not supposed to be negative, and is clearly within the bounds of an unsigned int

    System.out.println("Control       = " + num);

    DataOutputStream dataOutputStream =
            new DataOutputStream(
                    new FileOutputStream("data.bin"));

    dataOutputStream.writeInt((int) num);
    dataOutputStream.close();

    // Non-Compliant
    DataInputStream is = new DataInputStream(new FileInputStream("data.bin"));
    System.out.println("Non-Compliant = " + getIntegerNonCompliant(is));
    is.close();


    // Compliant
    is = new DataInputStream(new FileInputStream("data.bin"));
    System.out.println("Compliant     = " + getIntegerCompliant(is));
    is.close();
  }

  public static long getIntegerCompliant(DataInputStream is) throws IOException {
    return is.readInt() & 0xFFFFFFFFL; 
  }

  public static int getIntegerNonCompliant(DataInputStream is) throws IOException {
    return is.readInt(); 
  }
}
