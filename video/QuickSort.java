package video;
import java.util.*;

/**
 * Created by ikirilov on 05/03/15.
 */
public class QuickSort {
    //K R A T E L E P U I M Q C X O S
    //lo
    //i->                           <-j
    //++i -> i = R, R>K, so stopping here
    //j-> S, j->O, j->X (--j>lo) , j->C stop here
    //exchange i and j
    //K C A T E L E P U I M Q R X O S
    public static int partition(Comparable[] a, int lo, int hi){
        int i=lo;
        int j=hi+1;
        Comparable v = a[lo];
        while(true){
            while(less(a[++i], v)){if (i == hi) break;}     //scan right
            while(less(v, a[--j])){if (j==lo) break;}       //scan left
            if(i >= j) break; //stop when indices cross
            exchange(a,i,j);
        }
        exchange(a,j,lo);
        return j;  //partition
    }

    //helper methods
    public static void exchange(Object[] a, int i, int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static boolean less(Comparable a, Comparable b){
        return (a.compareTo(b) < 0);
    }


    public static boolean sorted(Comparable[] a){
        for(int i=0; i<a.length;i++){
            if(less(a[i], a[i-1])) return false;
        }
        return true;
    }


    //sort methods
    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }

    public static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo) return;        //1.
        int part = partition(a,lo,hi); //2. Partition the array
        sort(a,lo,part-1); //3. Recursively sort left
        sort(a,part+1,hi); //4. Recursively sort right
        assert sorted(a);   //5. Verify sorted array
    }

    public static void main(String[] args) {
        Comparable[] a = new Comparable[10];
        for (int i = 0 ; i < a.length ; i++)
        {
            a[i] = (int) (Math.random () * 100);
        }

        System.out.print("Initial array: ");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("");
        sort(a);
        System.out.print("Sorted: ");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
    }
}
