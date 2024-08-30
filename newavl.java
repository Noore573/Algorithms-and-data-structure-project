import java.util.Vector;

public class newavl extends BST{
   
    Node root;
 
    /* This function traverse the skewed binary tree and
       stores its nodes pointers in vector nodes[] */
    void storeBSTNodes(Node root, Vector<Node> nodes)
    {
        // Base case
        if (root == null)
            return;
        // store nodes in inorder
        storeBSTNodes(root.left, nodes);
        nodes.add(root);
        storeBSTNodes(root.right, nodes);
    }
 
    Node buildTree(Node root)
    {
        Vector<Node> nodes = new Vector<Node>();
        storeBSTNodes(root, nodes);
        int n = nodes.size();
        return ConvertToAvl(nodes, 0, n - 1);
    }
    Node ConvertToAvl(Vector<Node> nodes, int start,
            int end)
    {
        // base case
        if (start > end)
        
            return null;
        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        Node node = nodes.get(mid);
           //build tree using inorder traversal
        node.left = ConvertToAvl(nodes, start, mid - 1);
        node.right = ConvertToAvl(nodes, mid + 1, end);
        return node;
    }
   

}

