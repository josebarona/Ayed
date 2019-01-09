package Alicia;

import java.util.Comparator;
import java.util.NoSuchElementException;

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
        this.size++ ;
    }

    public void delete(K key){
        if(this.root.key.equals(key)){
            this.root.key = null ;
            this.root.value = null ;
        }
        else this.root.delete(key,this.comparator) ;
        this.size-- ;
    }

    public void printInOrder(){
        if(root!=null) root.visit() ;
        else throw new NoSuchElementException("error, no hay nada que imprimir") ;
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

        public void delete(K key,Comparator<K> comparator){
            int comp = comparator.compare(key,this.key) ;
            // key < key
            if(comp<0){
                if(left!=null){
                    if(left.key.equals(key)){
                        left.key = null ;
                        left.value = null ;
                    }else if(left.left!=null) left.left.delete(key,comparator);
                }
            }else if(comp>0){
                if(right!=null){
                    if(right.key.equals(key)){
                        right.key = null ;
                        right.value = null ;
                    }else if(right.right!=null) right.right.delete(key,comparator);
                }
            }
        }

        public void visit(){
            if(this.left!=null) this.left.visit() ;
            System.out.println("key: " + this.key + " || Value: " + this.value) ;
            if(this.right!=null) this.right.visit() ;
        }

    }

    public static void main(String[] args) {
        Comparator<Integer> comp0 = Integer::compareTo ;
        BinarySearchTree<Integer,String> tree = new BinarySearchTree<>(comp0) ;
        tree.add("jose",0) ;
        tree.add("franz",1) ;
        tree.add("master",3) ;
        tree.add("fabri",4) ;
        tree.add("ferron",6) ;
        tree.add("rodri",5) ;
        tree.add("fanny",7);
        tree.add("agus",8) ;
        tree.add("toto",9);
        tree.printInOrder() ;
        tree.delete(7) ;
        System.out.println("--------------------");
        tree.printInOrder() ;
    }

}
