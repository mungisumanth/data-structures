import java.util.*;
public class BST{
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        
        if(root.data > val){
            //left subtree
            root.left = insert(root.left, val);
        }
        
        else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        else if(key>root.data){
            return search(root.right, key);
        }
        else if(root.data == key){
            return true;
        }
        else{
            return search(root.left, key);
        }
    }
    
    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right, val);
        }
        else{ //root.data == val
            //case 1 - leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            //case 2 - node with one child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            //case 3 - node with 2 children - substitute deleted node with inorder successor, which is the leftmost node in the right subtree
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    public static Node inorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    
    public static void printInRange(Node root, int x, int y){
        if(root == null){
            return;
        }
        if(x <= root.data && y>= root.data){
            printInRange(root.left, x, y);
            System.out.print(root.data+ " ");
            printInRange(root.right, x, y);
        }
        else if(y<= root.data){
            printInRange(root.left, x, y);
        }
        else if(x >= root.data){
            printInRange(root.right, x, y);
        }
    }
    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        //leaf node
        if(root.left == null && root.right == null){
            printPath(path);
        }
        else{
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        }
        path.remove(path.size()-1);
    }
    
    public static void main(String args[]){
        int values[] = {10, 15, 8, 9, 2, 3, 5, 7, 89, 65, 100, 4, 1};
        Node root = null;
        
        for(int i=0;i<values.length;i++){
            root = insert(root, values[i]);
        }
        
        inorder(root);
        System.out.println();
        if(search(root,7)){
            System.out.println("Found");
        }
        else{
            System.out.println("Not found");
        }
        
        delete(root, 4);
        inorder(root);
        printInRange(root, 5, 10); 
        printRoot2Leaf(root, new ArrayList<>());
    }
}
