package pesel;

import com.google.common.base.Preconditions;

class PESELValidatorRefactor implements Validator {

    private static final int WEIGHTS[] = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
    private static final int PESEL_LENGTH = 11;

    @Override
    public boolean validate(final String pesel) {
        try {
            validatePeselLength(pesel);
            final int sum = calculateControlSum(pesel);
            final Integer lastDigit = getLastDigit(pesel);
            return validateControlSum(sum, lastDigit);
        } catch (final IllegalArgumentException exception) {
            return false;
        }
    }

    private void validatePeselLength(final String pesel) {
        Preconditions.checkArgument(pesel.length() == PESEL_LENGTH, "Invalid PESEL length.");
    }

    private boolean validateControlSum(final int sum, final Integer lastDigit) {
        return (10 - sum % 10) % 10 == lastDigit;
    }

    private Integer getLastDigit(final String pesel) {
        final String lastCharacter = pesel.substring(pesel.length() - 1);
        return Integer.parseInt(lastCharacter);
    }

    private int calculateControlSum(final String pesel) {
        int sum = 0;
        int peselDigit;
        for (int i = 0; i < pesel.length() - 1; i++) {
            peselDigit = Integer.parseInt(pesel.substring(i, i + 1));
            sum += WEIGHTS[i] * peselDigit;
        }
        return sum;
    }
}
