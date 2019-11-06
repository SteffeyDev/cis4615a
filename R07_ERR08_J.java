/******************************************************************************
*  Compilation:  javac R07_ERR08_J.java
*  Execution:    java R07_ERR08_J
*
*  Calls function isName(s) with legal and illegal values
* 
******************************************************************************/

public class R07_ERR08_J {

  public static void main(String[] args) {
    String validName = "Peter Steffey";
    String invalidName = "haxor__bob";

    System.out.println("Is " + validName + " a name? " + (isName(validName) ? "Yes" : "No"));
    System.out.println("Is " + invalidName + " a name? " + (isName(invalidName) ? "Yes" : "No"));
    System.out.println("Is " + null + " a name? " + (isName(null) ? "Yes" : "No"));
  }

  public static boolean isName(String s) {
    if (s == null) {
      return false;
    }
    String names[] = s.split(" ");
    if (names.length != 2) {
      return false;
    }
    return (isCapitalized(names[0]) && isCapitalized(names[1]));
  }

  public static boolean isCapitalized(String s) {
    return Character.isUpperCase(s.charAt(0));
  }

}
