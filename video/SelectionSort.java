package video;

import java.util.Objects;

/**
 * Created by ikirilov on 28/02/15.
 */
public class SelectionSort {
    //Classic SelectionSort using Comparable
    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i=0; i < N; i++){
            int min = i;
            for(int j=i+1; j < N; j++){
                if (isLess(a[j], a[min])){min = j;}
               exch(a,i,min);
            }
        }
    }

    public static boolean isLess(Comparable a, Comparable b){
        return (a.compareTo(b) < 0);
    }

    public static void exch(Object[]a, int i, int j){
        Object swap = a[i];
        a[i]=a[j];
        a[j]=swap;
    }

    public static void main(String[] args) {
        //Comparable[] a = {'k', 'a', 'f', 'z', 'r'};
        Comparable[] a = {100,2,55,4,67,88,99,7};
        sort(a);

        for(int i=0; i<a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
}
