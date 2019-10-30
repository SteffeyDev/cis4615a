public class Ser implements Serializable {
  private final long serialVersionUID = 123456789;
  private Ser() {
    // Initialize
  }
  public static void writeObject(final ObjectOutputStream stream)
    throws IOException {
    stream.defaultWriteObject();
  }
  public static void readObject(final ObjectInputStream stream)
      throws IOException, ClassNotFoundException {
    stream.defaultReadObject();
  }
}
