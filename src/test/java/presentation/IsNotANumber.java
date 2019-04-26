package presentation;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.junit.internal.matchers.TypeSafeMatcher;

public class IsNotANumber extends TypeSafeMatcher<Double> {

    @Override
    public boolean matchesSafely(final Double number) {
        return number.isNaN();
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("not lend number");
    }

    @Factory
    public static <T> Matcher<Double> notANumber() {
        return new IsNotANumber();
    }
}
