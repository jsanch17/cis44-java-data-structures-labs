public class CompanyTreeDriver {
    public static void main(String[] args) {
        // Root
        GeneralTreeNode root = new GeneralTreeNode("CEO");

        // Create department heads
        GeneralTreeNode vpSales = new GeneralTreeNode("VP of Sales");
        GeneralTreeNode vpEngineering = new GeneralTreeNode("VP of Engineering");
        //add to the tree
        root.addChild(vpSales);
        root.addChild(vpEngineering);

        // VP of Sales children
        GeneralTreeNode salesNA = new GeneralTreeNode("Sales Manager (NA)");
        GeneralTreeNode salesEU = new GeneralTreeNode("Sales Manager (EU)");
        //add to VP sales branch
        vpSales.addChild(salesNA);
        vpSales.addChild(salesEU);

        // VP of Engineering children
        GeneralTreeNode devLead = new GeneralTreeNode("Dev Team Lead");
        GeneralTreeNode qaLead = new GeneralTreeNode("QA Team Lead");
        //add to vp engineering branch
        vpEngineering.addChild(devLead);
        vpEngineering.addChild(qaLead);

        // Dev Team Lead children
        GeneralTreeNode dev1 = new GeneralTreeNode("Developer 1");
        GeneralTreeNode dev2 = new GeneralTreeNode("Developer 2");
        //add to dev lead branch
        devLead.addChild(dev1);
        devLead.addChild(dev2);

        // 2. Perform Traversals
        System.out.println("--- Preorder Traversal (Company Hierarchy) ---");
        root.traversePreorder();

        System.out.println("\n--- Postorder Traversal (Staff Roll Call) ---");
        root.traversePostorder();
    }
}
