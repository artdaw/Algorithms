package union_find;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class QuickFindTest {

    @Test
    public void connected() {
        QuickFind qf = new QuickFind(10);
        System.out.println(Arrays.toString(qf.getId()));

        qf.union(5, 2);
        System.out.println(Arrays.toString(qf.getId()));

        qf.union(2, 1);
        System.out.println(Arrays.toString(qf.getId()));

        assertTrue(qf.connected(5, 1));
    }

    @Test
    public void union() {
        QuickFind qf = new QuickFind(10);
        qf.union(0, 1);
        qf.union(1, 3);
        assertFalse(qf.connected(0, 2));
    }
}