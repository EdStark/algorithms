package book;

/**
 * Created by ikirilov on 12/04/15.
 */
public class SubstringSearch {
    //1.Brute-force method
    public static int search(String txt, String pat){
        int N = txt.length();
        int M = pat.length();
        for(int i=0; i<N-M;i++){
            int j;
            for(j=0;j<M;j++){
                if(txt.charAt(i+j)!=pat.charAt(j))
                    break;
            }
            if(j==M) return i;
        }
        return N;
    }

    public static void main(String[] args) {
        System.out.println("Found at " + search("one two three", "thre"));
    }

}
