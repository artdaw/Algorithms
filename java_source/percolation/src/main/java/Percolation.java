import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Percolation class
 *
 */
public class Percolation {

    private int gridSize;
    private WeightedQuickUnionUF connectedSites;
    private int openSitesNum = 0;
    private boolean[][] grid;

    // constructor
    public Percolation(final int n) {
        if (n < 0) {
            throw new java.lang.IllegalArgumentException();
        }
        this.gridSize = n + 1;
        this.connectedSites = new WeightedQuickUnionUF((n + 1) * (n + 1));
        this.grid = new boolean[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                grid[i][j] = false;
            }
        }
    }

    public static void main(final String[] args) {
        Percolation p = new Percolation(4);
        p.open(1,1);
        p.open(1,2);
        System.out.println(p.connectedSites.connected(0,1));
        System.out.println(p.numberOfOpenSites());
    }

    // open site (row, col) if it is not open already
    public void open(final int row, final int col) {
        validateIndices(row);
        validateIndices(col);


        if (!this.isOpen(row, col)) {
            grid[row][col] = true;
            openSitesNum++;

            if (row - 1 >= 0 && this.isOpen(row - 1, col)) {
                connectedSites.union(xyTo1D(row, col), xyTo1D(row - 1, col));
            }

            if (row + 1 < gridSize && this.isOpen(row + 1, col)) {
                connectedSites.union(xyTo1D(row, col), xyTo1D(row+1, col));
            }

            if (col + 1 < gridSize && this.isOpen(row, col + 1)) {
                connectedSites.union(xyTo1D(row, col), xyTo1D(row, col + 1));
            }

            if (col - 1 >= 0 && this.isOpen(row, col - 1)) {
                connectedSites.union(xyTo1D(row, col), xyTo1D(row, col - 1));
            }
        }
    }

    // is site (row, col) open?
    public boolean isOpen(final int row, final int col) {
        validateIndices(row);
        validateIndices(col);
        return grid[row][col];
    }

    // is site (row, col) full?
    public boolean isFull(final int row, final int col) {
        validateIndices(row);
        validateIndices(col);
        return false;
    }

    /**
     * Calculates a number of open sites
     * @return number of open sites
     */
    public int numberOfOpenSites() {
        return openSitesNum;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    /**
     * check index that should be 1
     * @param n - number to validate
     */
    private void validateIndices(final int n) {
        if (n < 0) {
            throw new java.lang.IllegalArgumentException();
        }
    }

    private int xyTo1D(final int row, final int col) {
        return row + col;
    }

//    private int dec(int i) {
//        return i - 1;
//    }
}
