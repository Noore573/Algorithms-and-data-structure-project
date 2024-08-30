// public class avl2 extends BST {
//     //Get Balance factor of node N
// int getBalance(Node N)
// {
// if (N==null)
// return 0;
// System.out.println("Node:"+N.key+" "+(height(N.left) - height(N.right)));
// return height(N.left) - height(N.right);

// }

// Node insertavl(Node node, int key)
// { /* 1. Perform the normal BST insertavlion*/
// if (node==null)
// return(new Node(key));
// if (key < node.key)
// node.left = insertavl(node.left,key);
// else if ( key>node.key)
// node.right= insertavl(node.right , key);
// else //Deplicate Keys not allowed
// return node;
// /* 2. Update height of this ancestor node*/
// node.height1 = 1 + Math.max(height(node.left),height(node.right));
// /* 3. Get the balance factor of this ancestor node
// to check wether this node became unbalanced */
// int balance = getBalance(node);

// // if this node becomes unbalanced, then there are 4 cases, left left case
// if (balance > 1 && key < node.left.key){

// return rightRotate(node);

// }
// //Right Right case
// if (balance < -1 && key > node.right.key)
// return leftRotate(node);
// //Left Right case
// if (balance > 1 && key > node.left.key)
// {
// node.left = leftRotate(node.left);
// return rightRotate(node);
// }
// //right left case
// if (balance < -1 && key < node.right.key)
// {
// node.right = rightRotate(node.right);
// return leftRotate(node);
// }
// /* return the (unchanged) node pointer */
// return node;
// }
// // A utility function to right
// // rotate subtree rooted with y
// // see the diagram given above
// Node rightRotate(Node y)
// {
// Node x = y.left;
// Node T2 = x.right;
// //Perform rotation
// x.right = y;
// y.left= T2;
// // Update heights
// y.height1 = Math.max(height(y.left),
// height(y.right)) + 1 ;
// x.height1 = Math.max(height(x.left),
// height(x.right)) + 1 ;
// // Return new root

// return x ;
// }
// // A utility function to left
// // rotate subtree rooted with x
// // see the diagram given above
// Node leftRotate(Node x)
// {
// Node y = x.right;
// Node T2 = y.left ;
// //Perform rotation
// y.left = x;
// x.right = T2;
// // Update heights
// x.height1 = Math.max(height(x.left),
// height(x.right)) + 1 ;
// y.height1 = Math.max(height(y.left),height(y.right)) + 1 ;
// // Return new root
// return y ;
// }
//     ///
//     //*delete */
//     /* A function to delete an existing key in AVL */
// Node delete(Node root, int key)
// {
// /* Base case: If the tree is empty */
// if (root== null)
// return root;
// /* otherwise, recur down the tree */
// if (key<root.key)
// root.left= delete(root.left, key);
// else if (key>root.key)
// root.right= delete(root.right,key);
// //if key is same as root’s key, then this is the node to be deleted
// else {
// // node with only one child or no child
// if (root.left == null)
// return root.right;
// else if (root.right == null)
// return root.left;
// // node with two children: get the inorder successor (smallest in the right subtree)
// root.key = minValue(root.right);
// //Delete the inorder successor
// root.right = delete(root.right, root.key);
// }
// // if the tree had only one node then return
// if (root == null)
// return root;
// // step 2: Update height of the current node
// root.height1 = Math.max(height(root.left),height(root.right)) +1 ;
// // Step 3: Get the balance factor of this node
// // (to check wetherthis node became unbalanced)
// int balance =getBalance(root);
// // if this node becomes unbalanced
// //then there are 4 cases
// //left left case
// if (balance > 1 && getBalance(root.left) >= 0)
// return rightRotate(root);
// //Left Right case
// if (balance > 1 && getBalance(root.left) < 0)
// {
// root.left = leftRotate(root.left);
// return rightRotate(root);
// }
// //Right Right case
// if (balance < -1 && getBalance(root.right) <= 0)
// return leftRotate(root);
// //right left case
// if (balance < -1 && getBalance(root.right) > 0)
// {
// root.right = rightRotate(root.right);
// return leftRotate(root);
// }
// return root; }
// }
