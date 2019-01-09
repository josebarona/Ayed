package Marcelo;

import java.util.Comparator;
import java.util.List;

public class Selection<T>{

    public <T> void sort(List<T> list,Comparator<T> comparator){
        int size = list.size() ;
        T min ;
        int minIndex ;
        for(int i=0 ; i<size ; i++){
            min = list.get(i) ;
            minIndex = i ;
            for(int j=i ; j<size ; j++){
                if(less(list.get(j),min,comparator)){
                    min = list.get(j) ;
                    minIndex = j ;
                }
            }
            compareSwap(list,minIndex,i,comparator);
        }
    }

    public <T> void swap(List<T> list , int a , int b){
        T elemA = list.get(a) ;
        T elemB = list.get(b) ;
        list.set(a,elemB) ;
        list.set(b,elemA) ;
    }


    public <T> boolean less(T elem1 , T elem2 , Comparator<T> comp){
        //elem1<elem2
        return comp.compare(elem1,elem2) < 0 ;
    }

    public <T> void compareSwap(List<T> list , int a , int b , Comparator<T> comp){
        if(less(list.get(a),list.get(b),comp)){
            swap(list,a,b);
        }
    }

}
