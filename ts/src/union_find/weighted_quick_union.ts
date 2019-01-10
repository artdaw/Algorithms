export default class WeightedQuickUnionUF {
  private id: Array<number> = [];
  private sz: Array<number> = [];

  constructor(N: number) {
    for (let i: number = 0; i < N; i++) {
      this.id.push(i);
    }
  }

  public connected(p: number, q: number): boolean {
    return this.root(p) === this.root(q);
  }

  public union(p: number, q: number): void {
    const rootP = this.root(p);
    const rootQ = this.root(q);

    if (rootP === rootQ) return;

    if (this.sz[rootP] < this.sz[rootQ]) {
      this.id[rootP] = rootQ;
      this.sz[rootQ] += this.sz[rootP];
    } else {
      this.id[rootQ] = rootP;
      this.sz[rootP] += this.sz[rootQ];
    }
  }

  private root(i: number): number {
    while (i != this.id[i]) {
      this.id[i] = this.id[this.id[i]];
      i = this.id[i];
    }

    return i;
  }
}
