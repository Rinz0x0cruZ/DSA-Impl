public class AVL<T extends Comparable<T>>{
    class Node{
        Node left,right;
        T data;
        Integer height;
        Node(T data){
            this.data=data;
            this.height=0;
        }
    }
    Node root;
    private void finder(Node temp,T x){
        while(true){
            if(x.compareTo(temp.data)<=0){ 
                if(temp.left==null){ 
                    temp.left=new Node(x);
                    break;
                }
                temp=temp.left;
            }
            else{ 
                if(temp.right==null){
                    temp.right=new Node(x);
                    break;
                }
                temp=temp.right;
            }
        }
    }
    private void rotateLeft(Node temp){

    }
    private void rotateRight(Node temp){

    }
    private int setHeight(Node temp){
        if(temp==null) return 0;
        int left=setHeight(temp.left);
        int right=setHeight(temp.right);
        temp.height=1+(left>right?left:right);
        return temp.height;
    }
    public void makeTree(T[] arr){
        this.root=new Node(arr[0]);
        Node temp;
        int n=arr.length;
        for(int i=1;i<n;++i){
            temp=this.root;
            T x=arr[i];
            finder(temp,x);
        }
        temp=this.root;
        setHeight(temp);
    }

    public void insert(T data){
        Node temp=this.root;
        finder(temp,data);
    }

    public void display(Node root){
        if(root==null) return;
        display(root.left);
        System.out.println(root.data+" "+root.height);
        display(root.right);
    }
}
