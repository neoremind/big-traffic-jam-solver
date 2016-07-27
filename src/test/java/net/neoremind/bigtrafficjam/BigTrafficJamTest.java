package net.neoremind.bigtrafficjam;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author zhangxu
 */
public class BigTrafficJamTest {

    @Test
    public void show() throws Exception {
        new BigTrafficJam(17).setPrintOutIntervalMs(1200).solve();
    }

    @Test
    public void test() throws Exception {
        testTemplate(3);
        testTemplate(5);
        testTemplate(7);
        testTemplate(17);
        testTemplate(103);
    }

    @Test(expected = RuntimeException.class)
    public void testNegative() throws Exception {
        testTemplate(2);
    }

    @Test(expected = RuntimeException.class)
    public void testNegativeOdd() throws Exception {
        testTemplate(8);
    }

    private void testTemplate(int length) {
        List<Id> result = new BigTrafficJam(length).setDebug(false).solve();
        System.out.println(result);
        System.out.println(BigTrafficJam.generateAnsweredList(length));
        assertThat(result, Matchers.is(BigTrafficJam.generateAnsweredList(length)));
    }
}
