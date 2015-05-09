package video;

/**
 * Created by ikirilov on 04/03/15.
 */
public class Insertion {

    //InsertionSort
    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i=0; i < N; i++){
          for(int j=i; j >0; j--){
              if(isLess(a[j], a[j-1])){
                  exchange(a, j, j-1);
              }
              else break;
          }
        }
    }

    public static boolean isLess(Comparable a, Comparable b){
        return (a.compareTo(b) < 0);

    }

    public static boolean isSorted(Comparable[] a){
       for(int i=0; i < a.length; i++){
           if(isLess(a[i], a[i-1])){
               return false;
           }
       }
        return true;
    }

    public static void exchange(Comparable[]a, int i, int j){
        Comparable swap = a[j];
        a[j] = a[i];
        a[i] = swap;
    }

    public static void main(String[] args) {
        Comparable[] a = {98, 34, 56, 2, 4, 87, 6};
        sort(a);
        for(int i=0; i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        assert isSorted(a);
    }
}
