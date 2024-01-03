public class BST<T extends Comparable<T>> {
    private class Node{
        T data;
        Node left,right;
        Node(T data){
            this.data=data;
        }
    }
    Node root;
    public BST(T[] arr){
        makeTree(arr);
    }
    public void insert(T x){
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
    private void makeTree(T[] arr){
        this.root=new Node(arr[0]);
        for(T x:arr) insert(x);
    }
    
}