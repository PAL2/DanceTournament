package by.polegoshko.dance.tournament;

import java.util.List;

public abstract class Dancer {

    public abstract int dance(Integer[] sequence);

    public abstract int dance(List<Integer> list);

    public abstract int dance(int... sequence);

}