package book;

/**
 * Created by ikirilov on 13/04/15.
 */
public class BoyerMoore {
    private int[] right;
    private String pat;
    BoyerMoore(String pat)
    { // Compute skip table.
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        right = new int[R];
        for (int c = 0; c < R; c++)
            right[c] = -1; // -1 for chars not in pattern
        for (int j = 0; j < M; j++) // rightmost position for
            right[pat.charAt(j)] = j; // chars in pattern
    }
    public int search(String txt)
    { // Search for pattern in txt.
        int N = txt.length();
        int M = pat.length();
        int skip;
        for (int i = 0; i <= N-M; i += skip)
        { // Does the pattern match the text at position i ?
            skip = 0;
            for (int j = M-1; j >= 0; j--)
                if (pat.charAt(j) != txt.charAt(i+j))
                {
                    System.out.println(pat.charAt(j));
                    System.out.println(txt.charAt(i+j));
                    System.out.println(right[txt.charAt(i+j)]);
                    skip = j - right[txt.charAt(i+j)];
                    if (skip < 1) skip = 1;
                    break;
                }
            if (skip == 0) return i; // found.
        }
        return N; // not found.
    }
    public static void main(String[] args)
    {
        //String pat = "TRUSTHARDTOOTHBRUSHES"
        //String txt = args[1];
        String txt = "FINDINAHAYSTACKNEEDLEINA";
        String pat = "NEEDLE";
        BoyerMoore kmp = new BoyerMoore(pat);
        StdOut.println("txt:" + txt);
        int offset = kmp.search(txt);

        StdOut.print("pat: ");
        for (int i = 0; i < offset; i++)
            StdOut.print(" ");
        StdOut.println(pat);
        StdOut.print(offset);
    }
}
