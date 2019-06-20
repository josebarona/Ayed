package latest;

import java.util.Comparator;

public class LinkedList<T> {

    private Node<T> head ;
    private int size ;

    public LinkedList() {
        this.size = 0 ;
    }

    //El método unshift() agrega un elemento al inicio del array
    public void unshift(T elem){
        if(this.head==null) this.head = new Node<>(elem) ;
        else{
            final Node<T> back = this.head ;
            this.head = new Node<>(elem, back) ;
        }
        this.size++ ;
    }


    /*
    *El método push() añade uno o más elementos al final de un array
    */
    public void push(T elem){

        if(this.head==null){
            this.head = new Node<T>(elem) ;
        }
        else{
            Node<T> current = this.head ;
            while (current.hasNext()) current = current.next ;
            current.next = new Node<T>(elem) ;
        }
        this.size++ ;
    }

    /*
     El método pop() elimina el último elemento de un array y lo devuelve.
     Este método cambia la longitud del array.
     */
    public T pop(){

       Node<T> current = this.head ;
       for(int i=0 ; i<this.size-2 ; i++) current = current.next ;
       final T lastValue = current.next.value ;
       current.next = null ;
       this.size-- ;
       return lastValue ;
    }

    /*
    * El método shift() elimina el primer elemento del array y devuelve dicho elemento.
    * Este método modifica la longitud del array.
    */
    public T shift(){

        final T firstValue = this.head.value ;
        this.head = this.head.next ;
        return firstValue ;

    }

    public String stringify(){

        String str = "" ;
        Node<T> current = this.head ;
        while (current.hasNext()){
            str += current.value + " , ";
            current = current.next ;
        }
        str += current.value ;
        return str ;

    }

    private Node<T> getNodeAtIndex(int index){
        Node<T> current = this.head ;
        for(int i=0 ; i<index ; i++){
            current = current.next ;
        }
        return  current ;
    }

    /*
     *El método slice() devuelve una copia de una parte del array dentro de un nuevo array empezando por inicio hasta fin (fin no incluido).
     * El array original no se modificará.
     * [a,b)
     */
    public LinkedList<T> slice(int start, int end){
       if(start>=0 && end<=this.size){
           LinkedList<T> slicedVersion = new LinkedList<>() ;
           Node<T> current = getNodeAtIndex(start) ;
           for(int i=0 ; i<end-1 ; i++){
               slicedVersion.push(current.value);
               current = current.next ;
           }
           return slicedVersion ;
       }
       else return null ;
    }

    public T get(int index){
        if(index<=this.size){
            return getNodeAtIndex(index).value ;
        }else return null ;
    }


    public LinkedList<T> reverse(){

        LinkedList<T> esrever = new LinkedList() ;

        Node<T> current = this.head ;

        while (current.hasNext()){
            esrever.unshift(current.value); ;
            current = current.next ;
        }
        esrever.unshift(current.value);

        return esrever ;

    }

    public void set(int a, T value){
        Node<T> temp = getNodeAtIndex(a) ;
        temp.value = value ;
    }

    public void swap(int a, int b){

        T elemA = getNodeAtIndex(a).value ;
        T elemB = getNodeAtIndex(b).value ;
        set(a, elemB) ;
        set(b, elemA) ;

    }

    //bubble sorter
    public void sort(Comparator<T> comp){

        for(int i=0 ; i<this.size ; i++){
            for(int j=i+1 ; j<this.size ; j++){
                int comparison = comp.compare(get(j), get(i)) ;
                if(comparison<0) swap(j,i) ;
            }
        }

    }


    private class Node<T>{

        private T value;
        private Node<T> next ;

        public Node(T value, Node<T> next) {
            this.value = value ;
            this.next = next ;
        }

        public Node(T value) {
            this.value = value;
            this.next = null ;
        }

        public boolean hasNext(){
            return this.next != null ;
        }

    }

}
