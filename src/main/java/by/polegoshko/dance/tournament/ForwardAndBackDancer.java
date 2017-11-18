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

    private int[] getSumOfEvenAndOddNumbers(Integer[] sequence) {
        int evenNumbers = 0;
        int oddNumbers = 0;
        int[] ints = new int[2];
        for (Integer integer : sequence) {
            if (integer < 0) {
                throw new IllegalArgumentException("The value in the sequence can't be negative");
            }
            if (isEven(integer)) {
                evenNumbers += integer;

            } else {
                oddNumbers += integer;
            }
        }
        ints[0] = evenNumbers;
        ints[1] = oddNumbers;
        return ints;
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }

    private void setNumberOfSteps(int numberOfSteps) {
        this.numberOfSteps = numberOfSteps;
    }

}