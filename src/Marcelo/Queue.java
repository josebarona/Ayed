package Marcelo;

import java.util.NoSuchElementException;

public class Queue<T>{
    private Node<T> first ;
    private int size ;

    public Queue(){
        this.size = 0 ;
    }

    public void enqueue(T elem){
        if(this.first==null) this.first = new Node<>(elem) ;
        else this.first.add(elem) ;
        this.size++ ;
    }

    public T dequeue(){
        if(this.first!=null){
            T soonToBePoped = this.first.elem ;
            this.first = this.first.next ;
            this.size-- ;
            return soonToBePoped ;
        }else throw new NoSuchElementException("error") ;
    }

    public void print(){
        if(this.first!=null) this.first.print() ;
        System.out.println();
    }

    private class Node<T>{
        T elem ;
        Node<T> next ;

        public Node(T elem){
            this.elem = elem;
        }

        public void add(T elem){
            if(this.next==null) this.next = new Node<>(elem) ;
            else this.next.add(elem) ;
        }

        public void print(){
            if(this.elem!=null) System.out.print( " , " + this.elem) ;
            if(this.next!=null) this.next.print() ;
        }

    }

    public static void main(String[] args) {
        Queue<String> family = new Queue<>() ;
        family.enqueue("yiyo") ;
        family.enqueue("yiya") ;
        family.enqueue("mami") ;
        family.enqueue("tio") ;
        family.enqueue("ane") ;
        family.enqueue("nicky") ;
        family.enqueue("jose") ;
        family.print() ;
        System.out.println("first to exit: " + family.dequeue() ) ;
        family.print() ;
    }

}
