package Marcelo;

@SuppressWarnings("all")

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
        this.size++ ;
    }

    public void insertBefore(int index, T elem){
        Node<T> current = this.first ;
        int i = 0 ;
        while (i<index-1){
            current = current.next ;
            i++ ;
        }
        Node<T> temp = current.next ;
        current.next = new Node<T>(elem,temp) ;
        this.size++ ;
    }

    public void insertAfter(int index, T elem){
        Node<T> current = this.first ;
        int i = 0 ;
        while (i<index){
            current = current.next ;
            i++ ;
        }
        Node<T> temp = current.next ;
        current.next = new Node<>(elem,temp) ;
        this.size++ ;
    }

    public void delete(int index){
        Node<T> current = this.first ;
        for(int i=0 ; i<index-1 ; i++) current = current.next ;
        current.next = current.next.next ;
        this.size-- ;
    }

    public void print(){
        this.first.show() ;
        System.out.println();
    }

    public void printWithIndex(){
        Node<T> current = this.first ;
        for(int i=0 ; i<size ; i++){
            System.out.print(i + ": " + current.elem + " , ") ;
            current = current.next ;
        }
        System.out.println();
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
        list.printWithIndex();
        list.insertBefore(3,"harry") ;
        list.printWithIndex();
        list.insertAfter(4,"hermione") ;
        list.printWithIndex();
        list.delete(10) ;
        list.printWithIndex();
    }

}
