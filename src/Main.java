import java.io.*;
import java.util.*;
public class Main {
    static final int N = 3;
    static final int TURN = 100;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("mixmilk");
        int[] cap = new int[N];
        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            cap[i] = io.nextInt();
            num[i] = io.nextInt();
        }
        for (int i = 0; i < TURN; i++) {
            int b1 = i % N;
            int b2 = (i + 1) % N;
            int amt = Math.min(num[b1], cap[b2] - num[b2]);
            num[b1] -= amt;
            num[b2] += amt;
        }

        for (int m : num) {
            io.println(m);
        }
        io.close();

    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}