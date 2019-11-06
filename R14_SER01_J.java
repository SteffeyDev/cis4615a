/******************************************************************************
*  Compilation:  javac R14_SER01_J.java
*  Execution:    java R14_SER01_J
*
*  Demonstrates how custom writeObject/readObject methods could be ignored
*  if function signature is incorrect, leading to unexpected result
* 
******************************************************************************/

import java.util.*;
import java.io.*;

class CompliantSer implements Serializable {
  private final long serialVersionUID = 123456789;

  public CompliantSer() {
    // Initialize
  }
  private void writeObject(final ObjectOutputStream stream)
    throws IOException {
    System.out.println("[Compliant] Custom writeObject called");
    stream.defaultWriteObject();
  }
  private void readObject(final ObjectInputStream stream)
    throws IOException, ClassNotFoundException {
    System.out.println("[Compliant] Custom readObject called");
    stream.defaultReadObject();
  }
}

class NonCompliantSer implements Serializable {
  private final long serialVersionUID = 123456789;

  public NonCompliantSer() {
    // Initialize
  }
  public static void writeObject(final ObjectOutputStream stream)
    throws IOException {
    System.out.println("[NonCompliant] Custom writeObject called");
    stream.defaultWriteObject();
  }
  public static void readObject(final ObjectInputStream stream)
    throws IOException, ClassNotFoundException {
    System.out.println("[NonCompliant] Custom readObject called");
    stream.defaultReadObject();
  }
}

public class R14_SER01_J {

  private static void serializeObject(Object o, String filename) {
    // Serialization
    try
    {
      //Saving of object in a file
      FileOutputStream file = new FileOutputStream(filename);
      ObjectOutputStream out = new ObjectOutputStream(file);

      // Method for serialization of object
      out.writeObject(o);

      out.close();
      file.close();

      System.out.println("Object has been serialized");

    } catch(IOException ex) {
      System.out.println("IOException is caught");
    }
  }

  public static void main(String[] args) {
    NonCompliantSer ncs = new NonCompliantSer();
    CompliantSer cs = new CompliantSer();
    serializeObject(ncs, "R14_SER01_NonComplaint_Output.ser");
    serializeObject(cs, "R14_SER01_Complaint_Output.ser");
  }

}
