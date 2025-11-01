public class ExpressionTreeDriver {
    public static void main(String[] args) {
        // Build the tree for: ( (3 + 7) * (9 - 4) )
        // root
        BinaryTreeNode root = new BinaryTreeNode("*");
//left branch
        BinaryTreeNode nodePlus = new BinaryTreeNode("+");
        //right branch
        BinaryTreeNode nodeMinus = new BinaryTreeNode("-");
//adds both the branches to the root
        root.left = nodePlus;
        root.right = nodeMinus;
        // creates a parent reference to the plus/minus nodes
        nodePlus.parent = root;
        nodeMinus.parent = root;
// leaf nodes
        BinaryTreeNode node3 = new BinaryTreeNode("3");
        BinaryTreeNode node7 = new BinaryTreeNode("7");
        BinaryTreeNode node9 = new BinaryTreeNode("9");
        BinaryTreeNode node4 = new BinaryTreeNode("4");
//attaches 3,7 to plus parent node and makes 3 the left leaf and 7 the right leaf
        nodePlus.left = node3;
        nodePlus.right = node7;
        node3.parent = nodePlus;
        node7.parent = nodePlus;
//attaches 9,4 to minus parent node and makes 9 left and 4 right leaf
        nodeMinus.left = node9;
        nodeMinus.right = node4;
        node9.parent = nodeMinus;
        node4.parent = nodeMinus;

        // Perform Traversals
        System.out.println("--- Preorder Traversal (Prefix) ---");
        root.traversePreorder();

        System.out.println("\n\n--- Inorder Traversal (Infix) ---");
        root.traverseInorder();

        System.out.println("\n\n--- Postorder Traversal (Postfix) ---");
        root.traversePostorder();
    }
}
