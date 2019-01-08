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
        if(this.first.elem.equals(elem)) this.first = this.first.next ;
        else this.first.deleteNode(elem);
        this.size-- ;
    }

    public void print(){
        this.first.show() ;
        System.out.println();
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
        friends.delete("toto") ;
        friends.print();

    }

}
