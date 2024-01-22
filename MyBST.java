public class MyBST {

    BSTNode root;

    private class BSTNode {
        Integer val;
        BSTNode left, right;

        public BSTNode(Integer val) {
            this.val = val;
            left = right = null;
        }

        @Override
        public String toString() {
            return "" + this.val;
        }
    }

    public int size() {
        return sizeHelper(0, root);
    }

    private int sizeHelper(int countSoFar, BSTNode currentNode) {
        if (currentNode == null) {
            return countSoFar;
        } else {
            return 1 + sizeHelper(countSoFar, currentNode.left) + sizeHelper(countSoFar, currentNode.right);
        }
    }

    public void insert(Integer n) {
        if (root == null) {
            root = new BSTNode(n);
        } else {
            insertHelper(n, root);
        }
    }

    private void insertHelper(int insertNum, BSTNode currentNode) {
        if (insertNum > currentNode.val) {
            if (currentNode.right == null) {
                currentNode.right = new BSTNode(insertNum);
            } else {
                insertHelper(insertNum, currentNode.right);
            }
        } else if (insertNum < currentNode.val) {
            if (currentNode.left == null) {
                currentNode.left = new BSTNode(insertNum);
            } else {
                insertHelper(insertNum, currentNode.left);
            }
        } else {
            currentNode.val = insertNum;
        }
    }

    public boolean contains(int n) {
        return containsHelper(n, root);
    }

    private boolean containsHelper(int n, BSTNode currentNode) {
        if (currentNode == null) {
            return false;
        }

        if (n > currentNode.val) {
            return containsHelper(n, currentNode.right);
        } else if (n < currentNode.val) {
            return containsHelper(n, currentNode.left);
        } else {
            return true;
        }
    }

    public int getMax() {

        return getMaxHelper(root, Integer.MIN_VALUE);
    }

    private int getMaxHelper(BSTNode currentNode, int currentMax) {

        if (currentNode == null) {

            return currentMax;
        }

        if (currentNode.val > currentMax) {

            return getMaxHelper(currentNode.right, currentNode.val);

        } else {

            return currentMax;

        }
    }

    public int getMin() {

        return getMinHelper(root, Integer.MAX_VALUE);
    }

    private int getMinHelper(BSTNode currentNode, int currentMin) {

        if (currentNode == null) {

            return currentMin;
        }

        if (currentNode.val < currentMin) {

            return getMinHelper(currentNode.left, currentNode.val);

        } else {

            return currentMin;

        }
    }

    public void delete(int n) {
        root = deleteHelper(n, root);
    }

    private BSTNode deleteHelper(int n, BSTNode currentNode) {
        if (currentNode == null) {
            return null;
        }

        if (n < currentNode.val) {
            currentNode.left = deleteHelper(n, currentNode.left);
        } else if (n > currentNode.val) {
            currentNode.right = deleteHelper(n, currentNode.right);
        } else {

            if (currentNode.left == null) {
                return currentNode.right;
            } else if (currentNode.right == null) {
                return currentNode.left;
            }

            currentNode.val = findMin(currentNode.right).val;
            currentNode.right = deleteHelper(currentNode.val, currentNode.right);
        }

        return currentNode;
    }

    private BSTNode findMin(BSTNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void inOrder() {
        inOrderTraversalHelper(root);
    }

    private void inOrderTraversalHelper(BSTNode currentNode) {
        if (currentNode != null) {

            inOrderTraversalHelper(currentNode.left);

            System.out.print(currentNode.val + " ");

            inOrderTraversalHelper(currentNode.right);
        }
    }

    public void print() {
        int treeHeight = calculateHeight(root);
        printTree(root, treeHeight, 0);
    }

    private int calculateHeight(BSTNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = calculateHeight(node.left);
            int rightHeight = calculateHeight(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    private void printTree(BSTNode node, int treeHeight, int depth) {
        if (node == null) {
            return;
        }

        printTree(node.right, treeHeight, depth + 1);

        for (int i = 0; i < depth * 4; i++) {
            System.out.print(" ");
        }
        System.out.println(node.val);

        printTree(node.left, treeHeight, depth + 1);
    }

}
