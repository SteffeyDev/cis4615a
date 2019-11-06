/******************************************************************************
*  Compilation:  javac R02_XP00_J.java
*  Execution:    java R02_XP00_J
*
*  Calls function deleteFile() and demonstrates failure handling
* 
******************************************************************************/

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class R02_XP00_J {
  final String filename = "testFile.txt";

  public static void main(String[] args) {
    R02_XP00_J test = new R02_XP00_J();

    // First try to delete file when it doesn't exist
    test.deleteFile();

    // Then delete file when it does exist
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(test.filename));
      writer.write("asdf");
      writer.close();

      File someFile = new File(test.filename);

      test.deleteFile();
    } catch (Exception e) {
      // Ignoring error for this demo
    }
  }

  public void deleteFile() {
    File someFile = new File(filename);

    // Do something with someFile

    if (!someFile.delete()) {
      System.out.println("Could not delete file: " + filename);
    } else {
      System.out.println("File deleted successfully: " + filename);
    }

  }

}
