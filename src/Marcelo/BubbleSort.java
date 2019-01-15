package Marcelo;

import java.util.Comparator;

@SuppressWarnings("all")

public class BubbleSort<T>{
    private LinkedList<T> list ;
    private Comparator<T> comp ;

    public BubbleSort(LinkedList<T> list) {
        this.list = list;
        this.comp = list.getComp() ;
    }

    public void sort(){
        int size = list.getSize() ;
        System.out.println("size" + size) ;
        for(int i=0 ; i<size ; i++){
            for(int j=size-1 ; j>i ; j--){
                if( comp.compare(list.get(j-1),list.get(j))>0 ) swap(j-1,j) ;
            }
        }
    }

    private void swap(int a, int b){
        T elemA = list.get(a) ;
        T elemB = list.get(b) ;
        list.set(a,elemB) ;
        list.set(b,elemA) ;
    }

    public static void main(String[] args) {
        LinkedList<Integer> primes = new LinkedList<>(Integer::compareTo) ;
        primes.add(11) ;
        primes.add(2) ;
        primes.add(5) ;
        primes.add(13) ;
        primes.add(7) ;
        primes.add(3) ;
        primes.print() ;
        System.out.println();
        BubbleSort bubbleSort = new BubbleSort(primes) ;
        bubbleSort.sort() ;
        primes.print();
//        LinkedList<Integer> nums = new LinkedList<>(11,Integer::compareTo) ;
//        for(int i=0 ; i<11 ; i++){
//            nums.set(i,2*i);
//        }
//        nums.print();
//        nums.set(10,69);
//        nums.print();

    }

}
