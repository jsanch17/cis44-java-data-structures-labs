import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TwoFourNode {
    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public boolean isFull() {
        return keys.size() == 3;
    }

    public TwoFourNode getNextChild(int key) {
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        return children.get(i);
    }

    public void insertKey(int key) {
        keys.add(key);
        Collections.sort(keys);
    }
}

public class TwoFourTree {
    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int key) {
        TwoFourNode node = root;

        // Descend to leaf
        while (!node.isLeaf()) {
            node = node.getNextChild(key);
        }

        // Insert key
        node.insertKey(key);

        // Handle overflow
        while (node != null && node.keys.size() > 3) {
            split(node);
            node = node.parent;
        }
    }

    private void split(TwoFourNode node) {
        System.out.println("Splitting node with keys: " + node.keys);

        int midKey = node.keys.get(1); // Middle key
        TwoFourNode leftNode = new TwoFourNode();
        TwoFourNode rightNode = new TwoFourNode();

        // Left node gets first key
        leftNode.keys.add(node.keys.get(0));
        // Right node gets last key
        rightNode.keys.add(node.keys.get(2));

        // Handle children if not leaf
        if (!node.isLeaf()) {
            leftNode.children.add(node.children.get(0));
            leftNode.children.add(node.children.get(1));
            rightNode.children.add(node.children.get(2));
            rightNode.children.add(node.children.get(3));

            for (TwoFourNode child : leftNode.children) child.parent = leftNode;
            for (TwoFourNode child : rightNode.children) child.parent = rightNode;
        }

        if (node.parent == null) {
            // Node is root
            TwoFourNode newRoot = new TwoFourNode();
            newRoot.keys.add(midKey);
            newRoot.children.add(leftNode);
            newRoot.children.add(rightNode);
            leftNode.parent = newRoot;
            rightNode.parent = newRoot;
            root = newRoot;
        } else {
            // Promote midKey to parent
            TwoFourNode parent = node.parent;
            parent.insertKey(midKey);

            // Replace node with left/right in parent's children
            int index = parent.children.indexOf(node);
            parent.children.remove(index);
            parent.children.add(index, leftNode);
            parent.children.add(index + 1, rightNode);
            leftNode.parent = parent;
            rightNode.parent = parent;
        }
    }

    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) return;

        if (node.isLeaf()) {
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                inorder(node.children.get(i));
                System.out.print(node.keys.get(i) + " ");
            }
            inorder(node.children.get(i));
        }
    }
}

