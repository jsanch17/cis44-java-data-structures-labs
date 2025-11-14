public class AVLTreeDriver {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Insert test values
        tree.insert(10);
        tree.insert(20);
        tree.insert(30); // triggers Left rotation
        tree.insert(5);
        tree.insert(4);  // triggers Right rotation
        tree.insert(8);  // triggers Left-Right rotation
        tree.insert(25); // triggers Right-Left rotation

        // Print traversals
        System.out.print("Inorder: ");
        tree.inorder();   // Expected sorted order

        System.out.print("Preorder: ");
        tree.preorder();  // Shows root-first structure

        System.out.print("Postorder: ");
        tree.postorder(); // Shows children-first structure
    }
}
