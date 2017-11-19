package by.polegoshko.dance.tournament;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ForwardAndBackDancerTest {

    ForwardAndBackDancer dancer;

    @Before
    public void init() {
        dancer = new ForwardAndBackDancer();
    }

    @Test
    public void dance1() {
        assertEquals(4, dancer.dance(2, 0, 7));
    }

    @Test
    public void dance2() {
        assertEquals(0, dancer.dance(8));
    }

    @Test
    public void dance3() {
        assertEquals(4, dancer.dance(2, 2, 1));
    }

    @Test
    public void dance4() {
        assertEquals(12, dancer.dance(4, 2, 0, 2, 3));
    }

    @Test
    public void dance5() {
        assertEquals(12, dancer.dance(4, 2, 9, 2, 3));
    }

    @Test
    public void dance6() {
        assertEquals(12, dancer.dance(6, 2, 2, 4, 9, 1, 3));
    }

    @Test
    public void dance7() {
        assertEquals(24, dancer.dance(6, 9, 5, 9, 9, 6, 1, 7, 7, 5, 5, 9));
    }

    @Test
    public void dance8() {
        assertEquals(-1, dancer.dance(2, 1, 1));
    }

    @Test
    public void dance9() {
        assertEquals(12, dancer.dance(2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test
    public void dance10() {
        assertEquals(24, dancer.dance(2, 4, 6, 8, 8, 6, 4, 2, 1, 2, 5, 2, 1));
    }

    @Test
    public void dance11() {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 0, 7));
        assertEquals(4, dancer.dance(list));
    }

    @Test
    public void dance12() {
        Integer[] integers = {2, 0, 7};
        assertEquals(4, dancer.dance(integers));
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerException() {
        ArrayList<Integer> list = null;
        dancer.dance(list);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerException2() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(null);
        list.add(7);
        dancer.dance(list);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerException3() {
        Integer[] integers = {2, null, 7};
        dancer.dance(integers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException() {
        dancer.dance(2, -1, 2);
    }

    @After
    public void destroy() {
        dancer = null;
    }
}