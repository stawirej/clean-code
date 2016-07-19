package presentation;

import static org.assertj.core.api.BDDAssertions.then;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static presentation.IsNotANumber.notANumber;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PersonScenarios {

    @Test
    public void shouldCreatePersonWithFullInformations() {
        // Given
        final int age = 23;
        final String name = "John";

        // When
        final Person john = new Person(name, age);

        // Then
        final Person expectedPerson = new Person(name, age);
        then(john).isEqualTo(expectedPerson);
    }

    @Test
    public void shouldSquareRootOfMinusOneBeNotANumber() {
        assertThat(Math.sqrt(-1), is(notANumber()));
    }

    @Test
    public void shouldContainSpecificString() {
        // Given
        final List<String> names = new ArrayList<String>();

        // When
        names.add("Mike");
        names.add("Nick");
        names.add("Betty");

        // Then
        then(names).contains("Mike", "Nick", "Betty");
    }

    @Test
    public void shouldPersonHaveFriend() {
        // Given
        final Person john = new Person("John", 23);
        final Person paul = new Person("Paul", 24);

        // When
        john.addFriend(paul);

        // Then
        final Persons johnFriends = john.getFriends();
        then(johnFriends).contains(paul);
    }

    @Test
    public void shouldCreatePersonWithCorrectAge() {
        // Given
        final String name = "John";
        final int age = 23;

        // When
        final Person john = new Person(name, age);

        // Then
        then(john.getAge()).isEqualTo(age);
    }
}
