package Alicia;

import java.util.Comparator;

public class BinarySearchTree<K,V>{
    private Node<K,V> root ;
    private Comparator<K> comparator ;
    private int size ;

    public BinarySearchTree(Comparator<K> comparator) {
        this.comparator = comparator;
        this.size = 0 ;
    }


    public void add(V value, K key){
        if(this.root==null) this.root = new Node<>(value,key) ;
        else this.root.addNode(value,key,comparator) ;

    }

    private class Node<K,V>{
        V value;
        K key ;
        private Node<K,V> left ;
        private Node<K,V> right ;

        public Node(V val, K key){
            this.value = val ;
            this.key = key ;
        }

        public void addNode(V value, K key, Comparator<K> comparator){
            int comp = comparator.compare(key,this.key) ;
            if(comp<0){
                //si key<this.key
                if(this.left==null) this.left = new Node<>(value,key) ;
                else this.left.addNode(value,key,comparator) ;
            }
            else if(comp>0){
                //si key>this.key
                if(this.right==null) this.right = new Node<>(value,key) ;
                else this.right.addNode(value,key,comparator) ;
            }
        }

    }

}
