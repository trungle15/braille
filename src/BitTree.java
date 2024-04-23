import java.io.PrintWriter;
import java.security.InvalidKeyException;

public class BitTree {

  BitTreeNode root;
  int depth;

  public BitTree(int n) {
    this.root = new BitTreeNode();
    this.depth = n;
  }

  public void set(String bits, String value) throws InvalidKeyException {
    if (bits.length() != depth) {
      throw new InvalidKeyException("Invalid length for bits");
    }

    BitTreeNode current = root;

    // Invalid character
    for (int i = 0; i < bits.length(); i++) {

      char c = bits.charAt(i);

      if (c != '0' && c != '1') {
        throw new InvalidKeyException("Invalid bit sequence. Bit can only be either 0 or 1");
      }


      // Last character
      if (i == bits.length() - 1) {
        if (c == '0') {
          current.left = new BitTreeLeaf(value);
        } else {
          current.right = new BitTreeLeaf(value);
        }
      }


      else {

        // Traverse left
        if (c == '0') {
          if (current.left == null) {
            current.left = new BitTreeNode();
          }
          current = current.left;
        }

        // Traverse right
        else {
          if (current.right == null) {
            current.right = new BitTreeNode();
          }
          current = current.right;
        }
      }
    }
  }

  public String get(String bits) throws InvalidKeyException {

    if (bits.length() != depth) {
      throw new InvalidKeyException("Invalid length for bits");
    }

    BitTreeNode current = root;

    for (int i = 0; i < bits.length(); i++) {
      char c = bits.charAt(i);

      if (c != '0' && c != '1') {
        throw new InvalidKeyException("Invalid bit sequence. Bit can only be either 0 or 1");
      }

      if (c == '0') {
        if (current.left == null) {
          throw new InvalidKeyException("No left path at bit index " + i);
        } else {
          current = current.left;
        }
      } else {
        if (current.right == null) {
          throw new InvalidKeyException("No right path at bit index " + i);
        } else {
          current = current.right;
        }
      }
    }

    BitTreeLeaf ret = (BitTreeLeaf) current;

    return ret.getValue();
  }

  void dumpHelper(PrintWriter pen, BitTreeNode node, String path) {

    if (node == null) {
      return;
    }

    if (node instanceof BitTreeLeaf) {
      BitTreeLeaf leaf = (BitTreeLeaf) node;
      pen.println(path + ',' + leaf.getValue());
    }
    else {
      if (node.left != null) {
        dumpHelper(pen, node.left, path + "0");
      }
      if (node.right != null) {
        dumpHelper(pen, node.right, path + "1");
      }
    }
  }

  void dump(PrintWriter pen) {
    dumpHelper(pen, this.root, "");
  }
}
