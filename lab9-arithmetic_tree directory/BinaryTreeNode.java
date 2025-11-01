public class BinaryTreeNode {
    String value; // Can be an operator "+" or an operand "3"
    BinaryTreeNode parent;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(String value) {
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    /**
     * Performs a preorder traversal starting from this node.
     * (Visit Parent, then Left, then Right)
     * Outputs Prefix notation.
     */
    public void traversePreorder() {
        System.out.print(this.value + " "); //prints the node value
        if (left != null) left.traversePreorder(); // recursively calls on the left if not null
        if (right != null) right.traversePreorder();// recursively calls on the right if not null
    }

    /**
     * Performs an inorder traversal starting from this node.
     * (Visit Left, then Parent, then Right)
     * Outputs Infix notation with parentheses.
     */
    public void traverseInorder() {
        if (left != null) {//recursively calls on the left child if not null
            System.out.print("(");//prints ( before recursing left
            left.traverseInorder();
        }

        System.out.print(this.value);//prints the nodes value

        if (right != null) { // recursively calls on the right child if not null
            right.traverseInorder();
            System.out.print(")");//prints ) after recursing right
        }
    }

    /**
     * Performs a postorder traversal starting from this node.
     * (Visit Left, then Right, then Parent)
     * Outputs Postfix (RPN) notation.
     */
    public void traversePostorder() {
        if (left != null) left.traversePostorder(); //recursively calls on the left if not null
        if (right != null) right.traversePostorder(); // recursively calls on the right if not null
        System.out.print(this.value + " "); // prints the nodes value
    }
}
