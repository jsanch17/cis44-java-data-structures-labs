import java.util.ArrayList;
import java.util.List;

public class GeneralTreeNode {
    String name; // Employee name or department title
    GeneralTreeNode parent;
    List<GeneralTreeNode> children;

    public GeneralTreeNode(String name) {
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    // Method to add a child to this node
    public void addChild(GeneralTreeNode child) {
        child.parent = this;
        this.children.add(child);
    }

    /**
     * Performs a preorder traversal starting from this node.
     * Prints the name of each node visited.
     * (Visit Parent, then visit children)
     */
    public void traversePreorder() {
        //prints the name of current node
        System.out.println(this.name); // Visit parent
        //recursively calls the method for as many children as there is
        for (GeneralTreeNode child : children) {
            child.traversePreorder(); // Visit children
        }
    }

    /**
     * Performs a postorder traversal starting from this node.
     * Prints the name of each node visited.
     * (Visit children, then visit Parent)
     */
    public void traversePostorder() {
        //recursively calls the method for x children
        for (GeneralTreeNode child : children) {
            child.traversePostorder(); //
        }
        //prints name of the last node or parent
        System.out.println(this.name);
    }
}
