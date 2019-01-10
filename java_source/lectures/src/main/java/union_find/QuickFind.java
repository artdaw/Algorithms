package union_find;

public class QuickFind {
  private int[] id;

  public QuickFind(int N) {
    this.id = new int[N]; // 0 1 2 3 4 5 6 7 8 9

    for (int i = 0; i < N; i++) {
      this.id[i] = i;
      // 0 1 2 3 4 5 6 7 8 9 - number
      //[0,1,1,3,4,2,6,7,8,9]
    }
  }

  public boolean connected(int p, int q) {
    return this.id[p] == this.id[q];
  }

   public void union(int p, int q) {
    int pid = this.id[p];
    int qid = this.id[q];

    for (int i = 0; i < this.id.length; i++) {
      if (pid == this.id[i]) {
        this.id[i] =  qid;
      }
    }
   }

   public int[] getId() {
      return this.id;
   }
}
