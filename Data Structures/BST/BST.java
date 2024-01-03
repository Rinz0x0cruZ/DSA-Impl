public class BST<T extends Comparable<T>> {
    private class Node{
        T data;
        Node left,right;
        Node(){
            this.left=null;
            this.right=null;
        }
        Node(T data){
            this.data=data;
        }
    }
    Node root;
    public BST(T[] arr){
        makeTree(arr);
    }
    public void insert(T x){
        if(this.root==null){
            this.root=new Node(x);
            return ;
        }
        Node temp=this.root;
        while(true){
            if(x.compareTo(temp.data)>0){
                if(temp.right==null){
                    temp.right=new Node(x);
                    break;
                }
                temp=temp.right;
            } else {
                if(temp.left==null){ 
                    temp.left=new Node(x);
                    break;
                }
                temp=temp.left;
            }
        }
    }
    public void display(){
        Node temp=this.root;
        traverse(temp);
    }
    public void update(T x){
        Node temp=this.root;
        while(true){
            int a=x.compareTo(temp.data);
            if(a>0){
                if(temp.right==null){
                    temp.right=new Node(x);
                    return ;
                }
                temp=temp.right;
            } else if(a<0) {
                if(temp.left==null){ 
                    return ;
                }
                temp=temp.left;
            }
            else {
                temp.data=x;
                return;
            }
        }
    }
    public Node search(T x){
        Node temp=this.root;
        while(true){
            int a=x.compareTo(temp.data);
            if(a>0){
                if(temp.right==null){
                    return new Node();
                }
                temp=temp.right;
            } else if(a<0) {
                if(temp.left==null){ 
                    return new Node();
                }
                temp=temp.left;
            }
            else {
                return temp;
            }
        }
    }
    public void delete(T x){
        Node temp=this.root;
        while(true){
            int a=x.compareTo(temp.data);
            if(a>0){
                if(temp.right==null){
                    return ;
                }
                temp=temp.right;
            } else if(a<0) {
                if(temp.left==null){ 
                    return ;
                }
                temp=temp.left;
            }
            else {
                temp=null;
                return ;
            }
        }
    }
    private void makeTree(T[] arr){
        for(T x:arr) insert(x);
    }
    private void traverse(Node rt){
        if(rt==null) return;
        traverse(rt.left);
        System.out.println(rt.data);
        traverse(rt.right);
    }
    
}