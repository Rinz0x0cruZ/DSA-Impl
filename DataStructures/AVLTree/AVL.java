public class AVL {
    class Node{
        Integer data,height;
        Node left,right;
        Node(Integer data){
            this.data=data;
            this.height=0;
            this.left=null;
            this.right=null;
        }
    }
    Node root;
    public AVL(Integer[] arr){
        makeTree(arr);
        Node temp=this.root;
        setHeight(temp);
    }

    private void insert(Integer d){
        if(this.root==null){ 
            this.root=new Node(d);
            return ;
        }
        Node temp=this.root;
        while(true){
            Integer rootval=temp.data;
            if(d<=rootval){
                if(temp.left==null){
                    temp.left=new Node(d);
                    return ;
                }
                temp=temp.left;
            }
            else{
                if(temp.right==null){
                    temp.right=new Node(d);
                    return ;
                }
                temp=temp.right;
            }
        }
    }

    public Integer setHeight(Node node){
        if(node==null) return 0;

        Integer left=setHeight(node.left);
        Integer right=setHeight(node.right);

        node.height=1+(left>right ? left : right);

        return node.height;
    }

    public Integer getBalance(Node node){
        if(node==null) return 0;
        Integer left=(node.left==null ? 0 : node.left.height);
        Integer right=(node.right==null ? 0 : node.right.height);
        return left-right;
    }
    public void rotateCheck(){
        Node fault=null;
        Node temp=this.root;
        
        while(true){
            Integer balance=getBalance(temp);
            if(balance==0 || balance==1 || balance==-1) break;
            else if(balance==-2 || balance==2) fault=temp;
            else{
                if(balance>0) temp=temp.right;
                else temp=temp.left;
            }
        }

        String rot="";
        if(fault.left==null){ 
            rot+='r';
            temp=fault.right;
        }
        else{
            rot+='l';
            temp=fault.left;
        }
        if(temp.left==null) rot+='r';
        else rot+='l';
        
        if(rot=="rr") r_r(fault);
        else if(rot=="ll") l_l(fault);
        else if(rot=="lr") l_r(fault);
        else r_l(fault);
    }

    public void r_r(Node node){
        Node t=node;
        node=node.right;
        node.left=t;
    }

    public void l_l(Node node){

    }

    public void l_r(Node node){

    }

    public void r_l(Node node){

    }
    private void traverse(Node node){
        if(node==null) return ;
        traverse(node.left);
        System.out.println(node.data);
        traverse(node.right);
    }

    public void display(){
        Node temp=this.root;
        traverse(temp);
    }

    public void makeTree(Integer[] arr){
        for(Integer x:arr) insert(x);
    }
}