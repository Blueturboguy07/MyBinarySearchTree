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
}
