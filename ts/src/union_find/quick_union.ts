export default class QuickUnionUF {
  private id: Array<number> = [];

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

    this.id[rootP] = rootQ;
  }

  private root(i: number): number {
    while (i != this.id[i]) {
      i = this.id[i];
    }

    return i;
  }
}
