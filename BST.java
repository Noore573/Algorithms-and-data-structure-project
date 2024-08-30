


// import static java.lang.System.out;

// public class BST {

//     private Node root;

//     class Node {
//         int data;
//         Node parent,left,right;

//         Node(int data){
//             this.data = data;
//         }
//         Node(int data, Node parent){
//             this(data);
//             this.parent = parent;
//         }

//         void remove(){
//             if(left == null && right == null){
//                 if(this == parent.left)
//                     parent.left  = null;
//                 else
//                     parent.right = null;
//             }
//             else if(left != null && right == null){
//                 if(this == parent.left){
//                     parent.left = left;
//                 }
//                 else{
//                     parent.right = left;
//                 }
//                 left.parent = parent;
//             }
//             else if(left == null && right != null){
//                 if(this == parent.left){
//                     parent.left = right;
//                 }
//                 else{
//                     parent.right = right;
//                 }
//                 right.parent = parent;
//             }
//             else{
//                 Node maxOfLeftSubTree = left.maxNode();
//                 data = maxOfLeftSubTree.data;
//                 maxOfLeftSubTree.remove();
//             }
//         }
//         Node maxNode(){
//             Node max = this;
//             while(max.right != null){
//                 max = max.right;
//             }
//             return max;
//         }
//         Node minNode(){
//             Node min = this;
//             while(min.left != null){
//                 min = min.left;
//             }
//             return min;
//         }
//         boolean isBinarySearch(){
//             return (left == null && right == null) || (left != null && right == null && data >= left.data && left.isBinarySearch()) || (left == null && right != null && data < right.data && right.isBinarySearch()) || (data >= left.data && data < right.data && left.isBinarySearch() && right.isBinarySearch());
//         }
//         void print(int level) {
//             if(right != null){
//                 right.print(level + 1);
//             }
//             for (int i = 0; i < level; i++) {
//                 out.print("    ");
//             }
//             out.println(data);
//             if(left != null){
//                 left.print(level + 1);
//             }
//         }
//     }
//     public void add(int data){
//         if(root == null){             
//             root = new Node(data);
//             return;
//         }
//         Node n = root;
//         while(true){
//             if(data <= n.data){
//                 if(n.left == null){
//                     n.left = new Node(data,n);
//                     break;
//                 }
//                 n = n.left;
//             }
//             else{
//                 if(n.right == null){
//                     n.right = new Node(data,n);
//                     break;
//                 }
//                 n = n.right;
//             }
//         }
//     }

//     public boolean contains(int data){
//         Node n = root;
//         while(n != null){
//             if(n.data == data)
//                 break;
//             n = data < n.data ? n.left : n.right;
//         }
//         if(n == null){
//             return false;
//         }
//         return true;
//     }

//     public void remove(int data){
//         Node n;
//         for(n = root; n != null ; n = data < n.data ? n.left : n.right)
//             if(n.data == data)
//                 break;
//         if(n == null){             
//             return;
//         }
//         if(n == root){
//             if(n.left == null && n.right == null)
//                 root = null;
//             else if(n.left != null && n.right == null){
//                 n.left.parent = null;
//                 root = root.left;
//             }
//             else if(n.left == null && n.right != null){
//                 n.right.parent = null;
//                 root = root.right;
//             }
//         }
//         else
//             n.remove();
//     }
//     public boolean isBinarySearch(){
//         return root != null && root.isBinarySearch();
//     }
//     public int min(){
//         if(root == null)
//             return -1;
//         return root.minNode().data;
//     }
//     public int max(){
//         if(root == null)
//             return -1;
//         return root.maxNode().data;
//     }
//     public void print(){
//         if(root != null)
//             root.print(0);
//     }
// }
