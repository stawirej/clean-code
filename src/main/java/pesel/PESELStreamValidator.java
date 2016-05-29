package pesel;

import static java.lang.Character.getNumericValue;

import java.util.stream.IntStream;

public class PESELStreamValidator implements Validator {

    private static final int WEIGHTS[] = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};

    @Override
    public boolean validate(final String pesel) {
        final int checkSum = calculateCheckSum(pesel);
        return validateCheckSum(pesel, checkSum);
    }

    private int calculateCheckSum(final String pesel) {
        return IntStream.range(0, WEIGHTS.length).reduce(0,
            (sum, i) -> sum + (WEIGHTS[i] * getNumericValue(pesel.charAt(i))));
    }

    private boolean validateCheckSum(final String pesel, final int checkSum) {
        final char lastDigit = pesel.charAt(pesel.length() - 1);
        return getNumericValue(lastDigit) == (10 - checkSum % 10) % 10;
    }
}
