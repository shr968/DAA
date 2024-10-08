package shreyanayak;
import java.util.*;
public class BST {
	public class Node{
		int key;
		Node right,left;
		public Node(int item) {
			key=item;
			left=right=null;
		}
	}
	Node root;
	BST(){
		root=null;
	}
	void insert(int key) {
		root=insertRec(root,key);
	}
	Node insertRec(Node root, int key) {
		if(root==null)
		{
			root=new Node(key);
			return root;
		}
		if(key<root.key)
			root.left=insertRec(root.left,key);
		if(key>root.key)
			root.right=insertRec(root.right, key);
		return root;
	}
	void delete(int key) {
		root=deleteRec(root,key);
	}
	Node deleteRec(Node root, int key) {
		if(root==null)
			return root;
		if(key<root.key)
			root.left=deleteRec(root.left,key);
		else if(key>root.key)
			root.right=deleteRec(root.right,key);
		else {
			if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			root.key=minValue(root.right);
			root.right=deleteRec(root.right,root.key);
		}
		return root;
	}
	int minValue(Node root) {
		int min = root.key;
		while(root.left!=null)
		{
			min=root.left.key;
			root=root.left;
		}
		return min;
	}
	void inorder() {
		 inorderRec(root); 
		}
		void inorderRec(Node root) { 
		 if (root != null) { 
		 inorderRec(root.left); 
		System.out.print(root.key + " "); 
		 inorderRec(root.right); 
		}
		} // Main method for testing the BST operations 
		public static void main(String[] args) { 
		 BST tree = new BST();
		tree.insert(50); 
		tree.insert(30); 
		tree.insert(20); 
		tree.insert(40); 
		tree.insert(70); 
		tree.insert(60); 
		tree.insert(80);
		 System.out.println("Inorder traversal:"); 
		tree.inorder(); 
		System.out.println(); // Delete elements 
		System.out.println("Delete 20:"); 
		tree.delete(20); 
		tree.inorder();
		System.out.println(); 
		System.out.println("Delete 30:");
		tree.delete(30); 
		tree.inorder(); 
		 System.out.println(); 
		 } 
		}

