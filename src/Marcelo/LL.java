package Marcelo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

@SuppressWarnings("all")

public class LL<T>{
    private Node<T> first ;
    private int size ;
    private Comparator<T> comp ;

    public LL(){
        this.size = 0 ;
    }

    public LL(Comparator<T> comp){
        this.comp = comp ;
    }

    public void add(T elem){
        if(this.first==null) this.first = new Node<>(elem) ;
        else{
            Node<T> temp = this.first ;
            this.first = new Node<>(elem,temp) ;
        }
        this.size++ ;
    }

    public void set(int index, T elem){
        if(index<=size){
            if(size==0) this.first = new Node<>(elem) ;
            else{
                Node<T> current = this.first ;
                for(int i=0 ; i<index ; i++) current = current.next ;
                current.elem = elem ;
            }
            size++ ;
        }else throw new IndexOutOfBoundsException("error") ;
    }

    public void clear(){
        this.first = null ;
        this.size = 0 ;
    }

    private void reverse(){
        LL esrever = new LL() ;
        for(int i=0 ; i<size ; i++) esrever.add(this.get(i)) ;
        this.first = esrever.first ;
    }

    public T get(int index){
        if(index>=0 && index<size){
            Node<T> current = this.first ;
            for(int i=0 ; i<index ; i++) current = current.next ;
            return current.elem ;
        }else throw new IndexOutOfBoundsException("error") ;
    }

    public LL subList(int a, int b){
       // copia [a,b)
        if(a>=0 && b<=size){
            LL trimedList = new LL() ;
            int i = b-1 ;
            while(i>=a){
                T elem = this.get(i) ;
                trimedList.add(elem);
                i-- ;
            }
            return trimedList ;
        }else throw new IndexOutOfBoundsException("error") ;
    }


    public LL clone(){
        return subList(0,this.size) ;
    }

    public void insertBefore(int index, T elem){
        if(index>=0){
            Node<T> current = this.first ;
            int i = 0 ;
            while (i<index-1){
                current = current.next ;
                i++ ;
            }
            Node<T> temp = current.next ;
            current.next = new Node<T>(elem,temp) ;
            this.size++ ;
        }else throw new NoSuchElementException("error") ;
    }

    public void insertAfter(int index, T elem){
        if(index<=size){
            Node<T> current = this.first ;
            int i = 0 ;
            while (i<index){
                current = current.next ;
                i++ ;
            }
            Node<T> temp = current.next ;
            current.next = new Node<>(elem,temp) ;
            this.size++ ;
        }else throw new NoSuchElementException("error") ;
    }

    private void swap(LL<T> list, int a, int b){
        T elemA = list.get(a) ;
        T elemB = list.get(b) ;
        list.set(a,elemB) ;
        list.set(b,elemA) ;
    }

    public void sort(){
        if(this.comp!=null){
            for(int i=0 ; i<size ; i++){
                int minIndex = i ;
                T minElem = this.get(i) ;
                for(int j=i+1 ; j<size-1 ; j++){
                    if(comp.compare(this.get(j),minElem)<0){
                        minIndex = j ;
                        minElem = this.get(j) ;
                    }
                }
                swap(this,i,minIndex);
            }

        }else throw new NoSuchElementException("metele un comp lok") ;
    }


    public void delete(int index){
        if(index<=size){
            Node<T> current = this.first ;
            for(int i=0 ; i<index-1 ; i++) current = current.next ;
            current.next = current.next.next ;
            this.size-- ;
        }else throw new NoSuchElementException("error") ;
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
        LL<String> list = new LL<>(String::compareTo) ;
//        list.add("jose") ;
//        list.add("master") ;
//        list.add("fabri") ;
//        list.add("toto") ;
//        list.add("ferron") ;
//        list.add("agus") ;
//        list.add("leonardo") ;
//        list.add("victor hugo") ;
//        list.add("sol") ;
//        list.printWithIndex();
//        list.insertBefore(3,"harry") ;
//        list.printWithIndex();
//        list.insertAfter(4,"hermione") ;
//        list.printWithIndex();
//        list.delete(10) ;
//        list.printWithIndex();
//        list.set(0,"simona");
//        list.printWithIndex();
        list.add("rodri") ;
        list.add("hermione") ;
        list.add("jj") ;
        list.add("master") ;
        list.add("jose");
        list.printWithIndex();
//        LL<String> list2 = list.subList(1,4) ;
//        list2.printWithIndex();
//        LL<String> list3 = list.clone() ;
//        list3.printWithIndex();
//        list.reverse() ;
//        list.printWithIndex();
        list.sort() ;

    }

}
