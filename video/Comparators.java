package video;
import java.util.Comparator;
import java.util.Objects;

/**
 * Created by ikirilov on 04/03/15.
 */
public class Comparators  {
    public static void sort(Object[] a, Comparator comparator){
         int N = a.length;
        for(int i=0; i < N; i++){
            for(int j = i; j >0 && isLess(comparator, a[j], a[j-1]); j--){
                exchange(a, j, j-1);
            }
        }
    }

    public static boolean isLess(Comparator a, Object i, Object j){
        return a.compare(i, j) <0 ;

    }

    public static void exchange(Object[]a, int i, int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
