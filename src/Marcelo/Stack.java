package Marcelo;

//stack is a last in first out structure

public class Stack<T>{
    private Node<T> first ;
    private int size ;

    public Stack(){
        this.size = 0 ;
    }

    public void push(T elem){
        if(this.first==null) this.first = new Node(elem) ;
        else this.first.addOnTop(elem) ;
        this.size++ ;
    }

    public T peek(){
        if(this.first.next==null) return this.first.elem ;
        else return this.first.peek() ;
    }

    public T pop(){
        if(this.first.next==null){
            T elem = this.first.elem ;
            this.first = null ;
            this.size = 0 ;
            return elem ;
        }else{
            this.size-- ;
            return this.first.pop() ;
        }
    }

    public void print(){
        this.first.print() ;
        System.out.println();
    }

    public boolean isEmpty(){
        return this.first==null || this.size==0 ;
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

        public void addOnTop(T elem){
            if(this.next==null) this.next = new Node<>(elem) ;
            else this.next.addOnTop(elem);
        }

        public T peek(){
            if(this.next==null) return this.elem ;
            else return this.next.peek() ;
        }

        public T pop(){
            if(this.next.next==null){
                T elem = this.next.elem ;
                this.next = null ;
                return elem ;
            }else return this.next.pop() ;
        }

        public void print(){
            System.out.print(this.elem + " , ");
            if(this.next!=null) this.next.print() ;
        }

    }

    public static void main(String[] args) {
        Stack<String> steak = new Stack<>() ;
        System.out.println("is empty? " + steak.isEmpty() );
        steak.push("jose") ;
        steak.push("master") ;
        steak.push("fabri") ;
        steak.push("franz") ;
        steak.push("ferron") ;
        steak.push("rodri") ;
        steak.push("agus") ;
        steak.push("toto") ;
        System.out.println("size: " + steak.size ) ;
        steak.print() ;
        System.out.println( steak.peek() );
        System.out.println( steak.pop() ) ;
        steak.print() ;
        System.out.println("is empty? " + steak.isEmpty() );
        //posii
    }

}
