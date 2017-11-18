package by.polegoshko.dance.tournament;

import java.util.List;

public class ForwardAndBackDancer extends Dancer {

    private int numberOfSteps;

    public ForwardAndBackDancer() {
        super();
    }

    @Override
    public int dance(Integer[] sequence) throws NullPointerException, IllegalArgumentException {
        numberOfSteps = 0;
        int position = 0;
        if (sequence == null) {
            throw new NullPointerException("Sequence can't be null");
        }
        if (sequence.length >= 50 || sequence.length <= 1) {
            return 0;
        }
        int[] ints = getSumOfEvenAndOddNumbers(sequence);
        int sumOfEvenNumbers = ints[0];
        int sumOfOddNumbers = ints[1];
        int areaSize = sequence.length;
        if (checkFirstNumber(sequence)) {
            return numberOfSteps;
        } else {
            for (int i = 0; i < sequence.length; i++) {
                if (sequence[i] != 0) {
                    if (isEven(sequence[i])) {
                        if ((areaSize - position) >= sequence[i]) {
                            position += sequence[i];
                            sumOfEvenNumbers -= sequence[i];
                            numberOfSteps += sequence[i];
                        } else {
                            numberOfSteps += position;
                            return numberOfSteps;
                        }
                    } else {
                        if (position >= sequence[i]) {
                            position -= sequence[i];
                            sumOfOddNumbers -= sequence[i];
                            numberOfSteps += sequence[i];
                        } else {
                            numberOfSteps += position;
                            return numberOfSteps;
                        }
                    }
                }
                if (((position + sumOfEvenNumbers) <= areaSize) && (position - sumOfOddNumbers) >= 0) return -1;
            }
        }
        return numberOfSteps;
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