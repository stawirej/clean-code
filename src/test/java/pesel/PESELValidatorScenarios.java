package pesel;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class PESELValidatorScenarios {

    protected Validator peselValidator;

    public PESELValidatorScenarios() {

        peselValidator = new PESELValidator();
    }

    @Test
    public void souldSuccessfullyValidateCorrectPesel() {

        // When
        final boolean isPeselCorrect = peselValidator.validate("49040501580");

        // Then
        then(isPeselCorrect).isTrue();
    }

    @Test
    public void souldSuccessfullyValidateIncorrectPesel() {

        // When
        final boolean isPeselCorrect = peselValidator.validate("11040501580");

        // Then
        then(isPeselCorrect).isFalse();
    }

    @Test
    public void souldSuccessfullyValidateIncorrectToLongPesel() {

        // When
        final boolean isPeselCorrect = peselValidator.validate("49040501580123");

        // Then
        then(isPeselCorrect).isFalse();
    }

    @Test
    public void shouldSuccessfullyValidatePeselWithCharacterPresent() {

        // When
        final boolean isPeselCorrect = peselValidator.validate("11040X01580");

        // Then
        then(isPeselCorrect).isFalse();
    }
}
