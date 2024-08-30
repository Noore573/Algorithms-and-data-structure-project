import java.util.Scanner;

//creating a node class with a constructe
class Node {
    int key;
    Node left, right;

    public Node(int key) {
        this.key = key;
        left = null;
        right = null;

    }
}
class BST {
    static Node root;
    static final int COUNT = 5;
    public BST() {
        root = null;
    }

    // insertion methode for BST
    public void insert(int key) {
        Node newNode = new Node(key);
        // empty tree
        if (root == null) {
            root = newNode;
            return;
        }
        // place holder
        Node current = root;
        while (true) {
            if (key < current.key) {
                if (current.left == null) {
                    current.left = newNode;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    break;
                }
                current = current.right;
            }
        }
    }
    // Function to print binary tree in 2D
    // It does reverse inorder traversal
    static void print2DUtil(Node root, int space)
    {
        // Base case
        if (root == null)
            return;
        space += COUNT;
        //  right child first
        print2DUtil(root.right, space);
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.key + "\n");
 
        //  left child
        print2DUtil(root.left, space);
    }
 
    // Wrapper over print2DUtil()
    static void print2D(Node root)
    {
        print2DUtil(root, 0);
    }
   /****/////
    // inorder sorting method(LRE)
    public void inorder(Node node) {

        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " - ");
            inorder(node.right);
        }
    }

    // a booleqan method to check if the tree is a bst
    public boolean isBST() {
        return IsBstCheck(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean IsBstCheck(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.key < min || node.key > max) {
            return false;
        }

        return IsBstCheck(node.left, min, node.key) && IsBstCheck(node.right, node.key, max);
    }

    // a boolean method to search in bst by just *KEY*
    public boolean search(int key) {
        return SearchBst(root, key);
    }

    private boolean SearchBst(Node node, int key) {

        while (node != null) {
            if (key > node.key) {
                node = node.right;
            } else if (key < node.key) {
                node = node.left;
            } else {
                return true;
            }
        }
        return false;
    }

    // finding the biggest value in a BST
    private void maxvalue() {

        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        System.out.println("The maximum value in the BST is: " + current.key);

    }
    private int minvalue2() {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.key;
    }
    // delet a key method
    static void deleteKey(int key) {
        root = deleteRec(root, key);
    }
    static Node deleteRec(Node root, int key) {

        //1-searching for the key
        // if the tree is empty
        if (root == null)
            return root;
        // else go down the tree
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        // if found the-->>
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    static int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    ////// ****************************************************************************
    ////// */
    // main methods
    public static void checkbst(BST bst) {
        if (bst.isBST()) {
            System.out.println("This tree is a BST");
        } else {
            System.out.println("False!this tree is not a BST");
        }
    }

    public static void searching(int l, BST bst) {

        var result = bst.search(l);
        if (result == true) {
            System.out.println("The value " + l + " was found in the BST.");
        } else {
            System.out.println("The value " + l + " was not found in the BST.");
        }
    }

    public static void maxmin(BST bst) {
        bst.maxvalue();
        System.out.println("\n");
        int min=bst.minvalue2();
        System.out.println("\nThe minimum value in the BST is: "+min);
    }

    public static void deletion(int t, BST bst) {

        deleteKey(t);
        bst.inorder(bst.root);
        System.out.println('\n');
        print2D(root);
       // TreePrinter(bst);
    }

    public static void insertion(int h, BST bst) {
        System.out.println("\n old" + bst.root.key);

        bst.insert(h);
        System.out.println("\n new" + bst.root.key);
        bst.inorder(bst.root);
        System.out.println("\n newer" + bst.root.key);
    }
////////////////******************************************************* */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = 0;
        //int entry = 0;
        BST bst = new BST();
        newavl tree = new newavl();
        // avl2 avltree = new avl2();
        
        
        System.out.println("what is the number of node you have");
        num = scan.nextInt();
        
            for (int i = 0; i < num; i++) {
                System.out.println("enter new node:");
                int v = scan.nextInt();
                bst.insert(v);
                bst.inorder(bst.root);

                System.out.println("\n ----------------------------------------\n");

                System.out.println("\n ----------------------------------------\n");

              //  TreePrinter(bst);
              print2D(root);
                System.out.println("\n ++++++++++++++++++++++++++++++++++++++++++\n");
            }
         //// *** */
        System.out.println("\n ");
        int type = 1;
        while (type != 0) {
            System.out.println("Methods availble: \n 1-checkbst , 2-search , 3-get the max and min , 4-delete key , 5-print , 6-insert , 7-convert to avl ");
            System.out.println("enter the method you want:");
            type = scan.nextInt();
            switch (type) {
                case 0:
                    break;
                case 1:
                    checkbst(bst);
                    break;
                case 2:
                    System.out.println("Enter the number to search forit in a Bst");
                    int l = scan.nextInt();
                    searching(l, bst);
                    break;
                case 3:
                    maxmin(bst);
                    break;
                case 4:
                    System.out.println("Enter the number you want to delete:");
                    int t = scan.nextInt();
                    deletion(t, bst);
                    break;
                case 5:
                   print2D(root);
                    break;
                case 6:
                    System.out.println("\nEnter new node to insert: ");
                    int h = scan.nextInt();
                    insertion(h, bst);
                    break;
                case 7:
                    bst.root = tree.buildTree(root);
                    System.out.println("Preorder traversal of balanced BST is :");
                    //tree.preOrder(root);
                    System.out.println("\n +++++++++++++++++++++++++++++++++++++++++\n");
                    print2D(root);
                    System.out.println("\n ++++++++++++++++++++++++++++++++++++++++++\n");
                    break;
                default:
                    break;
            }

        }
    }
}
