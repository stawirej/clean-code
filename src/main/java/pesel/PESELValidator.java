package pesel;

class PESELValidator implements Validator {

    private final int weights[] = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3}; // digit weights

    // mb: @see http://pl.wikipedia.org/wiki/PESEL
    @Override
    public boolean validate(final String str) {

        int s = 0;
        final int last;
        int peselDigit;

        if (str.length() != 11) {
            return false;
        }

        // calculate control sum
        for (int i = 0; i < str.length() - 1; i++) {
            try {
                peselDigit = Integer.parseInt(str.substring(i, i + 1));
            } catch (final NumberFormatException ex) {
                return false;
            }

            s += weights[i] * peselDigit;
        }

        // get last digit
        try {
            last = Integer.parseInt(str.substring(str.length() - 1));
        } catch (final NumberFormatException ex) {
            return false;
        }
        if ((10 - s % 10) % 10 == last) {
            return true;
        } else {
            return false;
        }
    }
}
