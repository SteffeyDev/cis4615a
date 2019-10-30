boolean isName(String s) {
  try {
    String names[] = s.split(" ");
 
    if (names.length != 2) {
      return false;
    }
    return (isCapitalized(names[0]) && isCapitalized(names[1]));
  } catch (NullPointerException e) {
    return false;
  }
}
