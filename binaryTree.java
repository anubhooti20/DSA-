import java.util.HashMap;
import java.util.Queue;
import java.util.*;

public class binaryTree{
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left=null;
            this.right = null;
        }
    }
    static class Binarytree{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;
        }
    }

// problem of subtrees matching them is they are same in trees or not.
    public static boolean isIdentical(Node node, Node subRoot){
        if(node==null && subRoot==null){
            return true;
        }else if(node==null || subRoot == null|| node.data !=subRoot.data){
            return false;
        }
        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right,subRoot.right)){
            return false;
        }
        return true;
    }
    public static boolean isSubtree(Node root, Node subRoot){
        if(root==null){
            return false;
        }
        if(root.data==subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
        return isSubtree(root.left,subRoot)|| isSubtree(root.right,subRoot);
    }

// problem of top view

    static class info{
        Node node;
        int hd;

        public info(Node node, int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public static void topView(Node root){
        Queue<info> q=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();

        int min=0,max=0;
        q.add(new info(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            info curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
            if(!map.containsKey(curr.hd)){
                map.put(curr.hd,curr.node);
            }
            if(curr.node.left!=null){
                q.add(new info(curr.node.left, curr.hd-1));
                min=Math.min(min,curr.hd-1);
            }
            if(curr.node.right!=null){
                q.add(new info(curr.node.right, curr.hd+1));
                max=Math.max(max,curr.hd+1);
            }
        }
    }
        for(int i=min; i<=max;i++){
            System.out.print(map.get(i).data+ " ");
        }
        System.out.println();
    }

// problem-printing the data of k level node

    public static void KLevel(Node root,int level,int k){
        if(root==null){
            return;
        }
        if(level==k){
            System.out.print(root.data+" ");
            return;
        }
        KLevel(root.left, level+1, k);
        KLevel(root.right, level+1, k);
    }

// problem-lowest common ancestor 
    public static boolean getPath(Node root,int n, ArrayList<Node>path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==n){
            return true;
        }
        boolean foundLeft=getPath(root.left, n, path);
        boolean foundRight=getPath(root.right, n, path);

        if(foundLeft || foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root,int n1, int n2){
        ArrayList<Node> path1=new ArrayList<>();
        ArrayList<Node> path2=new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);

        //last common ancestor
        int i=0;
        for(; i<path1.size()&& i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        Node lca=path1.get(i-1);
        return lca;

    }
//approach2
    public static Node lca2(Node root,int n1,int n2){
        if(root.data==n1|| root.data==n2){
            return root;
        }
        Node leftlca=lca2(root.left,n1,n2);
        Node rightlca=lca2(root.right,n1,n2);

        //leftLCA=val rightLCA=null
        if(leftlca==null){
            return rightlca;
        }
        if(rightlca==null){
            return leftlca;
        }
        return root;
    }
    public static void main(String args[]){
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        Node subRoot =new Node(2);
        subRoot.left=new Node(4);
        subRoot.right=new Node(5);

        // System.out.println(isSubtree(root, subRoot));
        // topView(root);
        // int k=2;
        // KLevel(root, 1, k); 

        int n1=4, n2=6;
        System.out.println(lca(root,n1,n2).data);
    }
}
