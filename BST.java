public class BST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root; 
        }
        if(root.data>val){
            //left subtree
            root.left=insert(root.left,val);
        }else{
            //right subtree
            root.right=insert(root.right,val);
        }
        return root;
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

//searching  of key in BST
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left,key);
        }
        else{
            return search(root.right,key);
        }
    }
    public static Node delete(Node root,int val){
        if(root.data<val){
            root.right=delete(root.right,val);
        }
        else if(root.data>val){
            root.left=delete(root.left,val);
        }
        else{
            //case 1-leaf node
            if(root.left==null && root.right==null){
                return null;
            }
            //case 2-single child
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            //case 3-both children
            Node IS= findInorderSuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right,IS.data);
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

// valid BST or not
    public static boolean isValidBST(Node root,Node min, Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        else if(max!=null && root.data>=max.data){
            return false;
        }
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

// Balanced the BST 
    //preorder traversal
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node createBST(int arr[],int st,int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root=new Node(arr[mid]);
        root.left=createBST(arr, st, mid-1);
        root.right=createBST(arr, mid+1, end);
        return root;
    }

    public static void main(String args[]){
        // int values[]={3,5,6,8,10,11,14};
        // Node root=null;

        // for(int i=0; i<values.length;i++){
        //     root=insert(root,values[i]);
        // }
        // inOrder(root);
        // System.out.println();

        // if(search(root,6)){
        //     System.out.println("found");
        // }
        // else{
        //     System.out.println("not found");
        // }
    //     root = delete(root, 10);
    //     System.out.println();

    //     inOrder(root);
    // }
        // if(isValidBST(root, null, null)){
        //     System.out.println("valid");
        // }else{
        //     System.out.println("not valid");
        // }
        int arr[]={3,5,6,8,10,11,12};
        Node root=createBST(arr, 0, arr.length-1);
        preorder(root) ;
    }
}    
