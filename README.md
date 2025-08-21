# MyBST - Binary Search Tree Implementation

## Overview

`MyBST` is a simple Java implementation of a Binary Search Tree (BST). A Binary Search Tree is a data structure that allows fast search, insertion, and deletion of elements while maintaining a specific order.

## Features

- **Insertion:** Add elements to the tree while maintaining the BST property.
- **Deletion:** Remove elements from the tree while preserving the BST property.
- **Search:** Check if a specific value exists in the tree.
- **Maximum and Minimum:** Find the maximum and minimum values in the tree.
- **Traversal:** Perform in-order traversal to display the elements in ascending order.
- **Print Tree:** Visualize the structure of the tree with a simple text-based representation.

## Usage

### Creating an Instance

```java
MyBST bst = new MyBST();
```

### Insertion

```java
bst.insert(5);
```

### Deletion

```java
bst.delete(8);
```

### Search

```java
boolean exists = bst.contains(3);
```

### Maximum and Minimum

```java
int max = bst.getMax();
int min = bst.getMin();
```

### Traversal

```java
bst.inOrder();
```

### Print Tree

```java
bst.print();
```

## Implementation Details

- The `MyBST` class contains a private inner class `BSTNode` representing a node in the BST.
- Various helper methods are used for different operations to maintain clean and modular code.

## Example

```java
MyBST bst = new MyBST();
bst.insert(8);
bst.insert(3);
bst.insert(10);
bst.insert(1);

bst.inOrder(); // Output: 1 3 8 10
```

## Contribution

Feel free to contribute to the improvement of this BST implementation. Fork the repository, make your changes, and submit a pull request.
