package union_find;

public class QuickUnion {
    private int[] id;

    public QuickUnion(int N) {
        this.id = new int[N];

        for (int i = 0; i < N; i++) {
            this.id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
      return this.root(p) == this.root(q);
    }

    public void union(int p, int q) {
      int rootP = this.root(p);
      int rootQ = this.root(q);

      this.id[rootP] = rootQ;
    }

    private int root(int i) {
      while (i != this.id[i]) {
        i = this.id[i];
      }

      return i;
    }
  }
