/*1. insert
2. inorder
3. search
4. delete
5. inorder successor
6. print in range
7. print path
8. print root 2 leaf
9. main */

class BST
{
	ArrayList<Integer> a = new ArrayList<>();
	static class Node
	{
		int data;
		Node left, right;
		Node(int data)
		{
			this.data = data;
		}
	}
	public static void main(String args[])
	{
		int values[] = {5, 3, 4, 2, 6, 1, 7, 9, 8, 10};
		Node root = null;
		for(int i=0;i<values.length;i++)
		{
			root = insert(root, values[i]);
		}
		delete(root, 9);
		inorder(root);
		insert(root, 12);
		search(6);
		printRoot2Leaf(root);
		printInRange(root, 4, 10);
	}
	public static Node insert(Node root, int val)
	{
		if(root == null)
		{
			root = new Node(val);
			return root;
		}
		if(val < root.data)
		{
			root.left = insert(root.left, val);
		}
		if(val > root.data)
		{
			root.right = insert(root.right, val);
		}
		return root;
	}
	public static Node delete(Node root, int val)
	{
		if(root == null)
		{
			return;
		}
		if(val < root.data)
		{
			root.left = delete(root.left, val);
		}
		else if(val > root.data)
		{
			root.right = delete(root.right, val);
		}
		//case 1 - leaf node
		if(root.left == null && root.right == null)
		{
			return null; //returns null to the parent after node deletion
		}
		//case 2 - node with 1 children
		if(root.left == null)
		{
			return root.right;
		}
		else if(root.right == null)
		{
			return root.left;
		}
		//case 3 - node with 2 children - replace node with its inorder successor, which is leftmost node in the right subtree
		else{
			Node IS = inorderSuccessor(root.right);
			root.data = IS.data;
			root.right = delete(root.right, IS.data);
		}
		return root;
	}
	public static void inorder(Node root)
	{
		inorder(root.left);
		a.add(root.data);
		inorder(root.right);
		for(int i=0;i<a.size();i++)
		{
			System.out.print(a.get(i) + " ");
		}
	}
	public static Node inorderSuccessor(Node root)
	{
		while(root.left != null)
		{
			root = root.left;
		}
		return root;
	}
	public static boolean search(Node root, int val)
	{
		if(root == null)
		{
			System.out.print("Element not found as tree is empty");
			return false;
		}
		if(val < root.data)
		{
			search(root.left, val);
		}
		if(val > root.data)	
		{
			search(root.right, val);
		}
		if(val == root.data)
		{
			return true;
		}
	}
	public static void printInRange(Node root, int x, int y)
	{
		for(int i=0;i<a.size();i++)
		{
			if(x <= a.get(i) && y>=a.get(i))
			{
				System.out.print(a.get(i) + " ");
			}
		}
	}
	public static void printPath(ArrayList<Integer> a)
	{
		for(int  i=0;i<a.size();i++)	
		{
			System.out.print(a.get(i) + " ");
		}
		System.out.println();
	}
	public static void printRoot2Leaf(Node root)
	{
		if(root == null)
		{
			return;
		}
		a.add(root.data);
		if(root.left == null && root.right == null)
		{
			printPath(a);
		}
		else
		{
			printRoot2Leaf(root.left, a);
			printRoot2Leaf(root.right, a);
		}
		a.remove(a.size()-1);
	}
}
