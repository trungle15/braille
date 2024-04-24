import java.io.PrintWriter;
import java.security.InvalidKeyException;

/**
 * The BrailleASCII utility class converts text between Braille, ASCII, and Unicode representations.
 * The class serves as the entry point to the program.
 * @author Trung Le
 */
public class BrailleASCII {

  static PrintWriter pen = new PrintWriter(System.out, true);

  public static void main(String[] args) throws InvalidKeyException {

    if (args.length != 2) {
      System.err.println("Invalid parameter amounts");
      System.exit(1);
    } // if

    else {
      String command = args[0];
      String input = args[1];

      if (command.equals("braille")) {
        char[] chars = input.toCharArray();
        for (char c : chars) {
          pen.print(BrailleASCIITables.toBraille(c));
        } // if
        pen.println();
      } // else

      else if (command.equals("ascii")) {
        
        int chunkSize = 6;
        if (input.length() % chunkSize != 0) {
          System.err.print("Invalid bit sequence length");
          System.exit(1);
        } // if

        for (int i = 0; i < input.length(); i += chunkSize) {
          int end = i + chunkSize;
          String substring = input.substring(i, end);
          pen.print(BrailleASCIITables.toASCII(substring));
        } // for

        pen.println();

      } // else if

      else if (command.equals("unicode")) {
        char[] chars = input.toCharArray();
        for (char c : chars) {
          String hexCode = BrailleASCIITables.toUnicode(BrailleASCIITables.toBraille(c));
          int codePoint = Integer.parseInt(hexCode, 16);
          char unicode = (char) codePoint;
          pen.print(unicode);
        } // for
        pen.println();
      } // else if

      else {
        System.err.println("Invalid command");
        System.exit(1);
      } // else
    } // else
    pen.close();
  } // main
} // class BrailleASCII
