package video;
/**
 * Created by ikirilov on 28/02/15.
 * Methods:
 * public static void sort(Comparable[] a);
 * public static void shuffle(Object[] a);
 * public static boolean isLess(Comparable a, Comparable b);
 * public static void exchange(Comparable a[], int i, int j);
 */
public class CardDealer {
    private static boolean isSorted(Comparable[] a){
        for(int i=0; i < a.length-1; i++){
            if (isLess(a[i], a[i-1])){return false;}
        }
        return true;
    }

    public static boolean isLess(Comparable a, Comparable b){
        return (a.compareTo(b) < 0);
    }

    public static void exchange(Comparable[] a, int i, int j){
            Comparable swap = a[i];
            a[i] = a[j];
            a[j] = swap;
    }

    public static void sort(Comparable[] a){
        //Insertion sort
        int N = a.length;
        for(int i=0; i<N; i++){
            for(int j=i; j > 0; j--){
                if(isLess(a[j], a[j-1])){
                    exchange(a, j, j-1);
                }
                else break;
            }
        }
    }

    public static void shuffle(Object[] a){
        int N = a.length;
        for(int i=0; i < N; i++) {
            //Random number between i and N-1
            int r = i + (int) (Math.random() * (N - i));
            Object swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }

    public static void main(String[] args) {
        Comparable[] cards = {'2','5','4','3'};
        System.out.print("Initial array: ");
        for(int i=0; i< cards.length; i++)
        System.out.print(cards[i] + " ");

        sort(cards);
        System.out.println("");
        System.out.print("Sorted array: ");
        for(int i=0; i< cards.length; i++)
            System.out.print(cards[i] + " ");

        shuffle(cards);
        System.out.println("");
        System.out.print("Shuffled array: ");
        for(int i=0; i< cards.length; i++)
        System.out.print(cards[i] + " ");


    }
}
