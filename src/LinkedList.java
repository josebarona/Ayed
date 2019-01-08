import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList<T>{
    private Node<T> first ;
    private int size ;

    public LinkedList(){
        this.size = 0 ;
    }

    public void add(T elem){
        if(this.first==null) this.first = new Node<>(elem) ;
        else this.first.addNode(elem)  ;
        this.size++ ;
    }

    public void delete(T elem){
        if(!isEmpty()){
            if(this.first.elem.equals(elem)) this.first = this.first.next ;
            else this.first.deleteNode(elem);
            this.size-- ;
        }else throw new NoSuchElementException("error") ;
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
        }else throw new NoSuchElementException("error") ;
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

    private class Node<T>{
        T elem ;
        Node<T> next ;

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
        LinkedList<String> friends = new LinkedList<>() ;
        friends.add("master") ;
        friends.add("fabri") ;
        friends.add("toto") ;
        friends.add("ferron") ;
        friends.add("agus") ;
//        System.out.println("size: " + friends.getSize() );
//        friends.print();
//        friends.delete("toto") ;
//        friends.print();
//        LinkedList<String> familia = new LinkedList<>() ;
//        familia.delete("mami") ;
//        friends.deleteAt(2) ;
//        friends.print();
        System.out.println(friends.contains("lefo"));
        Object[] friendsArr = friends.toArray() ;
        System.out.println(Arrays.toString(friendsArr) );

    }

}
