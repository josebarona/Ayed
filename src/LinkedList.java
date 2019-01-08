public class LinkedList<T>{
    private Node<T> first ;
    private int size ;

    public LinkedList(){
        this.size = 0 ;
    }

    public void add(T elem){
        if(this.first==null) this.first = new Node<>(elem) ;
        else{
            this.first.addNode(elem)  ;
        }
        this.size++ ;
    }

    public void delete(T elem){
        if(this.)
    }

    public void print(){
        this.first.show() ;
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
        System.out.println("size: " + friends.getSize() );
        friends.print();

    }

}
