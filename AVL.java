
// package ds;
// import static ds.AVL.Node.State.*;
import static java.lang.System.out;

public class AVL {

    Node root;
    int size;
    enum State {
        LEAF, HAS_LEFT, HAS_RIGHT, HAS_TWO
    }
    class Node {
        // private static final AVL.Node.State LEAF = null;
        // private static  fi AVL.Node.State HAS_LEFT = null;
        // private static  AVL.Node.State HAS_TWO = null;
        // private static  AVL.Node.State HAS_RI = null;
        // private static  AVL.Node.State HAS_RIGHT = null;
        int data, balanceFactor;
        Node parent, left, right;
        private AVL.State LEAF;
        State state = LEAF;
        private AVL.State HAS_LEFT;
        private AVL.State HAS_RIGHT;
        private AVL.State HAS_TWO;

       

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node parent) {
            this(data);
            this.parent = parent;
        }

        void updateState() {
            System.out.println("HIIIII");
            state = !hasLeft() && !hasRight() ? LEAF
                    : hasLeft() && !hasRight() ? HAS_LEFT
                            : !hasLeft() && hasRight() ? HAS_RIGHT
                                    : HAS_TWO;
        }

        boolean isRoot() {
            return parent == null;
        }

        boolean hasLeft() {
            return left != null;
        }

        boolean hasRight() {
            return right != null;
        }

        int height() {
            return switch (state) {
                case LEAF -> 0;
                case HAS_LEFT -> 1 + left.height();
                case HAS_RIGHT -> 1 + right.height();
                case HAS_TWO -> 1 + Math.max(left.height(), right.height());
            };
        }

        void updateBalanceFactor() {
            balanceFactor = switch (state) {
                default ->0;
                //case null->0;
                case LEAF -> 0;
                case HAS_LEFT -> left.height() - -1;
                case HAS_RIGHT -> -1 - right.height();
                case HAS_TWO -> left.height() - right.height();
            };
        }

        boolean isLeftHeavy() {
            return balanceFactor > 1;
        }

        boolean isRightHeavy() {
            return balanceFactor < -1;
        }

        void ensureBalance() {
            out.println("ensure : " + data);
            updateBalanceFactor();
            if (isLeftHeavy()) {
                left.updateBalanceFactor();
                if (left.balanceFactor == -1) {
                    left.leftRotate();
                }
                rightRotate();
            } else if (isRightHeavy()) {
                right.updateBalanceFactor();
                if (right.balanceFactor == 1) {
                    right.rightRotate();
                }
                leftRotate();
            } else if (!isRoot()) {
                parent.ensureBalance();
            }
        }

        void rightRotate() {
            out.println("Right Rotation : " + data);
            if (isRoot())
                root = left;
            else if (this == parent.left)
                parent.left = left;
            else
                parent.right = left;
            Node t = left.right;

            left.right = this;
            left.parent = parent;

            parent = left;
            left = t;

            updateState();
            parent.updateState();
        }

        void leftRotate() {
            out.println("Left Rotation : " + data);
            if (isRoot())
                root = right;
            else if (this == parent.left)
                parent.left = right;
            else
                parent.right = right;

            Node t = right.left;

            right.left = this;
            right.parent = parent;

            parent = right;
            right = t;

            updateState();
            parent.updateState();
        }

        void add(int data) {
            if (data <= this.data) {
                if (!hasLeft()) {
                    left = new Node(data, this);
                    updateState();
                    if (!isRoot())
                        parent.ensureBalance();
                } else {
                    left.add(data);
                }
            } else {
                if (!hasRight()) {
                    right = new Node(data, this);
                    updateState();
                    if (!isRoot())
                        parent.ensureBalance();
                } else {
                    right.add(data);
                }
            }
        }

        void remove() {
            out.println("removing : " + data);
            if (isRoot() && state != HAS_TWO) {
                switch (state) {
                    case LEAF -> root = null;

                    case HAS_LEFT -> {
                        left.parent = null;
                        root = root.left;
                    }
                    case HAS_RIGHT -> {
                        right.parent = null;
                        root = root.right;
                    }
                    default -> throw new IllegalArgumentException("Unexpected value: " + state);
                }
            } else
                switch (state) {
                    case LEAF -> {
                        if (this == parent.left)
                            parent.left = null;
                        else
                            parent.right = null;
                        parent.updateState();
                        parent.ensureBalance();
                    }
                    case HAS_LEFT -> {
                        if (this == parent.left)
                            parent.left = left;
                        else
                            parent.right = left;
                        left.parent = parent;
                        parent.ensureBalance();
                    }
                    case HAS_RIGHT -> {
                        if (this == parent.left)
                            parent.left = right;
                        else
                            parent.right = right;
                        right.parent = parent;
                        parent.ensureBalance();
                    }
                    case HAS_TWO -> {
                        Node minOfRightSubtree = right.minNode();
                        data = minOfRightSubtree.data;
                        minOfRightSubtree.remove();
                    }
                }
        }

        Node minNode() {
            return left != null ? left.minNode() : this;
        }

        void print(int level) {
            if (right != null) {
                right.print(level + 1);
            }
            for (int i = 0; i < level; i++) {
                // out.print(" ");
                out.print("     ");
            }
            out.println(data);
            if (left != null) {
                left.print(level + 1);
            }
        }
    }

    public void add(int... data) {
        for (int i : data) {
            // out.println("adding : " + i);
            add(i);
        }
    }

    public void add(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            root.add(data);
        }
        size++;
    }

    public boolean remove(int data) {
        Node n = root;
        while (n != null) {
            if (n.data == data)
                break;
            n = data < n.data ? n.left : n.right;
        }
        if (n == null)
            return false;
        n.remove();
        size--;
        return true;
    }

    public void print() {
        if (root != null) {
            root.print(0);
        }
    }
}
