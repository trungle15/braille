import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;

/**
 * The BrailleASCIITables class represents a collection of tables used for Braille to ASCII and Unicode conversions.
 * It provides methods to convert characters to Braille, ASCII, and Unicode representations.
 * @author Trung Le
 */
public class BrailleASCIITables {
  
  private static BitTree ASCIIToBraille = new BitTree(8);
  private static BitTree BrailleToASCII = new BitTree(6);
  private static BitTree BrailleToUnicode = new BitTree(6);

  static {
    try {
      ASCIIToBraille.load(new FileInputStream("src/mappings/ASCIItoBraille.csv"));
      BrailleToASCII.load(new FileInputStream("src/mappings/BrailletoASCII.csv"));
      BrailleToUnicode.load(new FileInputStream("src/mappings/BrailletoUnicode.csv"));
    } // try
    catch (InvalidKeyException | IOException e) {
      e.printStackTrace();
    } // catch
  } // static


  static String toBraille(char letter) throws InvalidKeyException {
    int l = (int) letter;
    String binary = "0" + Integer.toBinaryString(l);
    return ASCIIToBraille.get(binary);
  } // String toBraille

  static String toASCII(String bits) throws InvalidKeyException {
    return BrailleToASCII.get(bits);
  } // String toASCII

  static String toUnicode(String c) throws InvalidKeyException {
    return BrailleToUnicode.get(c);
  } // String toUnicode
} // class BrailleASCIITables
