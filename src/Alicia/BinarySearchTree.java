package Alicia;

import java.awt.font.TextHitInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

    public void remove(K key){
        List<Node<K,V>> temp = new ArrayList<>(this.size) ;
        if(root!=null){
            this.root.dump(key,temp) ;
            this.copyFromList(temp);
        }
        else throw new NoSuchElementException("error, arbol vacio") ;
    }

    public void printInOrder(){
        if(root!=null) root.visit() ;
        else throw new NoSuchElementException("error, no hay nada que imprimir") ;
    }

    public void copyFromList(List<Node<K, V>> list){
        this.root = null ;
        this.root = list.get(0) ;
        for (Node<K,V> n : list) {
            K key = n.key ;
            V value = n.value ;
            this.add(value,key);
        }
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

        public void dump(K key,List<Node<K,V>> list){
            if(this.left!=null) this.left.dump(key,list);
            if(this.key!=null){
                if(!this.key.equals(key)) list.add(new Node(this.value,this.key)) ;
            }
            if(this.right!=null) this.right.dump(key,list) ;
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
        tree.add("rodri",5) ;
        tree.add("jose",0) ;
        tree.add("franz",1) ;
        tree.add("master",3) ;
        tree.add("fanny",7);
        tree.add("fabri",4) ;
        tree.add("ferron",6) ;
        tree.add("agus",8) ;
        tree.add("toto",9);
        tree.add("donati",-1);
        tree.printInOrder() ;
        tree.delete(7) ;
        System.out.println("--------------------");
        tree.printInOrder() ;
        System.out.println("--------------------");
        tree.remove(6) ;
        tree.printInOrder();

    }

}
