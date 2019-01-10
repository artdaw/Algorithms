package union_find;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class QuickUnionTest {

    @Test
    public void connected() {
        QuickUnion qu = new QuickUnion(10);
        qu.union(0, 1);
        qu.union(1, 3);
        assertTrue(qu.connected(0, 3));
    }

    @Test
    public void union() {
        QuickUnion qu = new QuickUnion(10);
        qu.union(0, 1);
        qu.union(1, 3);
        assertFalse(qu.connected(0, 2));
    }
}