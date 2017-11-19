package by.polegoshko.dance.tournament;

import java.util.Arrays;
import java.util.List;

public class ForwardAndBackDancer extends Dancer {

    private int numberOfSteps;

    public ForwardAndBackDancer() {
        super();
    }

    @Override
    public int dance(Integer[] sequence) throws NullPointerException, IllegalArgumentException {
        if (sequence == null) {
            throw new NullPointerException("Sequence can't be null");
        }
        return this.dance(Arrays.stream(sequence).mapToInt(Integer::intValue).toArray());
    }

    @Override
    public int dance(List<Integer> list) throws NullPointerException, IllegalArgumentException {
        if (list == null) {
            throw new NullPointerException("Sequence can't be null");
        }
        return this.dance(list.stream().mapToInt(i -> i).toArray());
    }

    @Override
    public int dance(int... sequence) throws NullPointerException, IllegalArgumentException {
        numberOfSteps = 0;
        if (sequence.length >= 50 || sequence.length <= 1) {
            return 0;
        }
        checkNumbersNotNegative(sequence);
        if (checkFirstNumber(sequence)) {
            return numberOfSteps;
        } else {
            int areaSize = sequence.length;
            int position = sequence[0];
            numberOfSteps = sequence[0];
            sequence[0] = -1;
            while (true) {
                if (sequence[position] == 0 || sequence[position] == -1) {
                    return -1;
                } else {
                    if (isEven(sequence[position])) {
                        if ((areaSize - position) > sequence[position]) {
                            int tmpPosition = position;
                            numberOfSteps += sequence[tmpPosition];
                            position += sequence[tmpPosition];
                            sequence[tmpPosition] = -1;
                        } else {
                            numberOfSteps += position;
                            return numberOfSteps;
                        }
                    } else {
                        if (position >= sequence[position]) {
                            int tmpPosition = position;
                            numberOfSteps += sequence[tmpPosition];
                            position -= sequence[tmpPosition];
                            sequence[tmpPosition] = -1;
                        } else {
                            numberOfSteps += position;
                            return numberOfSteps;
                        }
                    }
                }
            }
        }
    }

    private boolean isEven(Integer integer) {
        return integer % 2 == 0;
    }

    private boolean checkFirstNumber(int[] sequence) {
        return !isEven(sequence[0]) || sequence[0] > sequence.length || sequence[0] == 0;
    }

    private void checkNumbersNotNegative(int[] sequence) throws IllegalArgumentException {
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] < 0) throw new IllegalArgumentException("The value in the sequence can't be negative");
        }
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }

    private void setNumberOfSteps(int numberOfSteps) {
        this.numberOfSteps = numberOfSteps;
    }

}