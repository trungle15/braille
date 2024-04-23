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
			} 
			else {
				if (current.right == null) {
					throw new InvalidKeyException("No right path at bit index " + i);
				}	else {
					current = current.right;
				}
			}
		}

		BitTreeLeaf ret = (BitTreeLeaf) current;

		return ret.getValue();
	}

	void dumpHelper(PrintWriter pen, BitTreeNode root) {
		
		StringBuilder stb = new StringBuilder();
		
		
		while (root != null) {
			if (root instanceof BitTreeLeaf) {
				BitTreeLeaf ret = (BitTreeLeaf) root;
				pen.print(',' + ret.getValue() + '\n');
			}
			else {

				if (root.left != null) {
					pen.print('1');
					dumpHelper(pen, root.left);
				}

				if (root.right != null) {
					pen.print('0');
					dumpHelper(pen, root.right);
				}
			}
		}
	}

	void dump(PrintWriter pen) {
		// Pre-order traversal then print the path + value at end of node
		/* Pseudocode:
		 * initialize empty string
		 * If node is empty return ''
		 * Otherwise
		 */
		dumpHelper(pen, this.root);
	}

}
