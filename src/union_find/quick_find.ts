export default class QuickFindUF {
  private id: Array<number> = [];

  constructor(N: number) {
    for (let i: number = 0; i < N; i++) {
      this.id.push(i);
    }
  }

  public connected(p: number, q: number): boolean {
    return this.id[p] === this.id[q];
  }

  public union(p: number, q: number): void {
    const pid = this.id[p];
    const qid = this.id[q];

    for (let i: number = 0; i < this.id.length; i++) {
      if (pid === this.id[i]) {
        this.id[i] = qid;
      }
    }
  }
}
