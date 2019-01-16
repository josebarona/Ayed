package Marcelo;

public class LL<T>{
    private Node<T> first ;
    private int size ;

    public LL(){
        this.size = 0 ;
    }

    public void add(T elem){
        if(this.first==null) this.first = new Node<>(elem) ;
        else{
            Node<T> temp = this.first ;
            this.first = new Node<>(elem,temp) ;
        }
    }

    public void print(){
        this.first.show() ;
    }

    private class Node<T>{
        T elem ;
        Node<T> next ;

        public Node(T elem) {
            this.elem = elem;
        }

        public Node(T elem, Node<T> next) {
            this.elem = elem;
            this.next = next;
        }

        public void show(){
            if(this.elem!=null) System.out.print(" , " + this.elem) ;
            if(this.next!=null) this.next.show() ;
        }

    }

    public static void main(String[] args) {
        LL<String> list = new LL<>() ;
        list.add("jose") ;
        list.add("master") ;
        list.add("fabri") ;
        list.add("toto") ;
        list.add("ferron") ;
        list.add("agus") ;
        list.add("leonardo") ;
        list.add("victor hugo") ;
        list.add("sol") ;
        list.print();
    }

}
