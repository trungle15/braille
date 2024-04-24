/**
 * Represents a leaf node in a binary tree.
 * Extends the BitTreeNode class.
 * @author Trung Le
 */
public class BitTreeLeaf extends BitTreeNode {

  String value;

  public BitTreeLeaf(String value) {
    super();
    this.value = value;
  } // BitTreeLeaf

  public String getValue() {
    return value;
  } // String getValue
} // class BitTreeLeaf
