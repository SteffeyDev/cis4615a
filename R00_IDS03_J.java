/******************************************************************************
*  Compilation:  javac R00_IDS03_J.java
*  Execution:    java R00_IDS03_J
*
*  Calls function login(username) with legal and illegal values
* 
******************************************************************************/

import java.util.regex.Pattern;

public class R00_IDS03_J {

  public static void main(String[] args) {
    String validUsername = "ps0123456";
    String invalidUsername = "1nva1id_u$3rn8m!!*";

    R00_IDS03_J test = new R00_IDS03_J();
    test.login(validUsername);
    test.login(invalidUsername);
  }

  // Mock for AuthSystem class
  private class AuthSystem {
    public boolean login(String username) {
      return true;
    }
  }

  private class Logger {
    public void severe(String out) {
      System.out.println("[severe] " + out);
    }
  }

  public boolean login(String username) {
    AuthSystem auth = new AuthSystem();
    Logger logger = new Logger();
    boolean loginSuccessful = auth.login(username);

    if (loginSuccessful) {
      logger.severe("User login succeeded for: " + sanitizeUser(username));
      return true;
    } else {
      logger.severe("User login failed for: " + sanitizeUser(username));
      return false;
    }
  }

  private String sanitizeUser(String username) {
    return Pattern.matches("[A-Za-z0-9_]+", username)
        ? username : "unauthorized user";
  }

}
