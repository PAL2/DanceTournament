package by.polegoshko.dance.tournament;

import java.util.List;

public class ForwardAndBackDancer extends Dancer {

    private int numberOfSteps;
    public ForwardAndBackDancer() {
        super();
    }

    @Override
    public int dance(Integer[] sequence) {
        return 0;
    }

    @Override
    public int dance(List<Integer> list) {
        return 0;
    }

    @Override
    public int dance(int... sequence) {
        return 0;
    }

    private boolean isEven(Integer integer) {
        return integer % 2 == 0;
    }

    private boolean checkFirstNumber(Integer[] sequence) {
        return !isEven(sequence[0]) || sequence[0] > sequence.length || sequence[0] == 0;
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }

    private void setNumberOfSteps(int numberOfSteps) {
        this.numberOfSteps = numberOfSteps;
    }

}