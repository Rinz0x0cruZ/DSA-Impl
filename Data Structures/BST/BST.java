public class BST<T extends Comparable<T>> {
    private class Node{
        T data;
        Integer idx;
        Node left,right;
        Node(){
            this.left=null;
            this.right=null;
        }
        Node(T data,Integer index){
            this.data=data;
            this.idx=index;
        }
    }
    Node root;
    public BST(T[] arr){
        makeTree(arr);
    }
    public void insert(T x,Integer index){
        if(this.root==null){
            this.root=new Node(x,index);
            return ;
        }
        Node temp=this.root;
        while(true){
            if(x.compareTo(temp.data)>0){
                if(temp.right==null){
                    temp.right=new Node(x,index);
                    break;
                }
                temp=temp.right;
            } else {
                if(temp.left==null){ 
                    temp.left=new Node(x,index);
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
    public void update(T x,T f){
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
                temp.data=f;
                return;
            }
        }
    }
    public Integer search(T x){
        Node temp=this.root;
        while(true){
            int a=x.compareTo(temp.data);
            if(a>0){
                if(temp.right==null){
                    break;
                }
                temp=temp.right;
            } else if(a<0) {
                if(temp.left==null){ 
                    break;
                }
                temp=temp.left;
            }
            else {
                return temp.idx;
            }
        }
        return -1;
    }
    public void delete(T x){
        Node temp=this.root;
        Node prev=null;
        while(true){
            int a=x.compareTo(temp.data);
            if(a>0){
                if(temp.right==null){
                    return ;
                }
                prev=temp;
                temp=temp.right;
            } else if(a<0) {
                if(temp.left==null){ 
                    return ;
                }
                prev=temp;
                temp=temp.left;
            }
            else {
                if(prev==null) this.root=null;
                else if(prev.left.data==x) prev.left=null;
                else prev.right=null;
                return ;
            }
        }
    }
    private void makeTree(T[] arr){
        for(int i=0;i<arr.length;++i) insert(arr[i],i);
    }
    private void traverse(Node rt){
        if(rt==null) return;
        traverse(rt.left);
        System.out.print(rt.data+" ");
        traverse(rt.right);
    }
}