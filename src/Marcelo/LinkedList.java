package Marcelo;

import java.util.*;

public class LinkedList<T>{
    private Node<T> first ;
    private int size ;
    private Comparator<T> comp ;

    public LinkedList(){
        this.size = 0 ;
    }

    public LinkedList(Comparator<T> comp){
        this.comp = comp;
    }

    public LinkedList(int size,Comparator<T> comp ){
        for(int i=0 ; i<size ; i++) this.add(null);
        this.comp = comp ;
    }

    public void add(T elem){
        if(this.first==null) this.first = new Node<>(elem) ;
        else this.first.addNode(elem)  ;
        this.size++ ;
    }

    public void setAt(int index, T elem){
        if(index<size){
            int i = 0 ;
            Node<T> current = this.first ;
            while (i<index-1){
                current = current.next ;
                i++ ;
            }
            if(current.next!=null){
                Node<T> temp = current.next ;
                current.next = new Node<>(elem) ;
                current.next.next = temp.next ;
            }
        }else throw new NoSuchElementException("error, no hay tal indice en la lista") ;
    }

    public void set(int index, T elem){
        Node<T> current = this.first ;
        for(int i=0 ; i<index ; i++) current = current.next ;
        current.elem = elem ;
    }

    public void delete(T elem){
        if(!isEmpty()){
            if(this.first.elem.equals(elem)) this.first = this.first.next ;
            else this.first.deleteNode(elem);
            this.size-- ;
        }else throw new NoSuchElementException("error, no hay tal elemento en la lista") ;
    }

    public void deleteAt(int index){
        if(index<size){
            Node<T> current = this.first ;
            int i = 0 ;
            while (i<index-1){
                current = current.next ;
                i++ ;
            }
            if(current.next.next!=null) current.next = current.next.next ;
            this.size-- ;
        }else throw new NoSuchElementException("error, hay elemento en esa posicion") ;
    }

    public T get(int index){
        if(index<size){
            Node<T> current = this.first ;
            int i = 0 ;
            while (i<index){
                current = current.next ;
                i++ ;
            }
            return current.elem ;
        }else throw new NoSuchElementException("error, hay elemento en esa posicion") ;
    }

    public boolean contains(T elem){
        if(this.first.elem.equals(elem)) return true ;
        else return this.first.search(elem) ;
    }

    public Object[] toArray(){
        Object[] array = new Object[size] ;
        Node<T> current = this.first ;
        for(int i=0 ; i<size ; i++){
            array[i] = current.elem ;
            current = current.next ;
        }
        return array ;
    }

    public void sort(){
        // la ordeno con selectionSort()
        if(this.comp!=null){
            List<T> temp = this.toArrayList() ;
            BubbleSort<T> bable =  new BubbleSort<>(this) ;
            bable.sort() ;
        }else throw new NoSuchElementException("error, no hay comparator") ;
    }

    public void copyAll(List<T> arrList){
        this.first = null ;
        this.first = new Node<>(arrList.get(0)) ;
        int n = arrList.size() ;
        for(int i=1 ; i<n ; i++){
            this.add(arrList.get(i)) ;
        }
    }

    public LinkedList<T> subList(int a, int b){
        if(a<size &&  b<size){
            LinkedList trimedList = new LinkedList() ;
            for(int i=a ; i<b ; i++){
                trimedList.add( this.get(i) );
            }
            return trimedList ;
        }else throw new NoSuchElementException("error") ;
    }

    public List<T> toArrayList(){
        List<T> list = new ArrayList<>(size) ;
        for(int i=0 ; i<size ; i++) list.add(this.get(i)) ;
        return list ;
    }

    public void print(){
        this.first.show() ;
        System.out.println();
    }

    public boolean isEmpty(){
        return this.size==0 ;
    }

    public int getSize() {
        return size;
    }

    public Comparator<T> getComp() {
        return comp;
    }

    private class Node<T>{
        T elem ;
        Node<T> next ;

        public Node() {
        }

        public Node(T elem) {
            this.elem = elem;
            this.next = null ;
        }

        public Node(T elem, Node<T> next) {
            this.elem = elem;
            this.next = next;
        }

        public void addNode(T elem){
            if(this.next==null) this.next = new Node<>(elem) ;
            else this.next.addNode(elem) ;
        }

        public void deleteNode(T elem){
            if(this.next!=null){
                if(this.next.elem.equals(elem)) this.next = this.next.next ;
                else this.next.deleteNode(elem) ;
            }
        }

        public boolean search(T elem){
            if(this.next.elem.equals(elem)) return true ;
            else if(this.next.next!=null) return this.next.search(elem) ;
            else return false ;
        }

        public void show(){
            if(this.elem!=null) System.out.print(this.elem + " , ") ;
            if(this.next!=null) this.next.show() ;
        }

    }

    public static void main(String[] args) {
        Comparator<String> comp = Comparator.comparing(String::toString) ;
        LinkedList<String> friends = new LinkedList<>(comp) ;
        friends.add("master") ;
        friends.add("fabri") ;
        friends.add("toto") ;
        friends.add("ferron") ;
        friends.add("agus") ;
        friends.add("leonardo") ;
        friends.add("victor hugo") ;
        friends.add("sol") ;
        friends.print();
        friends.sort();
        friends.print();
        System.out.println();

        Comparator<Integer> comp2 = Comparator.comparing(Integer::intValue) ;
        LinkedList<Integer> primes = new LinkedList<>(comp2) ;
        primes.add(11) ;
        primes.add(2) ;
        primes.add(5) ;
        primes.add(13) ;
        primes.add(7) ;
        primes.add(3) ;
        primes.print();
        primes.sort() ;
        primes.print();

        LinkedList<String> friendsTrimmed = friends.subList(2,5) ;
        friendsTrimmed.print();



    }

}
