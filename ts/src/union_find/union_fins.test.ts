import QuickFindUF from "./quick_find";
import QuickUnionUF from "./quick_union";
import WeightedQuickUnionUF from "./weighted_quick_union";

describe("Union Find Suite: Quick Find", () => {
  it("should connect 0 and 3 throught 1", () => {
    const qf = new QuickFindUF(10);
    qf.union(0, 1);
    qf.union(1, 3);
    expect(qf.connected(0, 3)).toBeTruthy();
  });

  it("should not connect 0 and 2", () => {
    const qf = new QuickFindUF(10);
    qf.union(0, 1);
    qf.union(1, 3);
    expect(qf.connected(0, 2)).toBeFalsy();
  });
});

describe("Union Find Suite: Quick Union", () => {
  it("should connect 0 and 3 throught 1", () => {
    const qf = new QuickUnionUF(10);
    qf.union(0, 1);
    qf.union(1, 3);
    expect(qf.connected(0, 3)).toBeTruthy();
  });

  it("should not connect 0 and 2", () => {
    const qf = new QuickUnionUF(10);
    qf.union(0, 1);
    qf.union(1, 3);
    expect(qf.connected(0, 2)).toBeFalsy();
  });
});

describe("Union Find Suite: Weighted Quick Union", () => {
  it("should connect 0 and 3 throught 1", () => {
    const qf = new WeightedQuickUnionUF(10);
    qf.union(0, 1);
    qf.union(1, 3);
    expect(qf.connected(0, 3)).toBeTruthy();
  });

  it("should not connect 0 and 2", () => {
    const qf = new WeightedQuickUnionUF(10);
    qf.union(0, 1);
    qf.union(1, 3);
    expect(qf.connected(0, 2)).toBeFalsy();
  });
});
