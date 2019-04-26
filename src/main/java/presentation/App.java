package presentation;

import static org.junit.Assert.assertTrue;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Book {

    private final String title;

    public Book(
        String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }

    @Override
    public boolean equals(
        final Object obj) {
        Book book = (Book)obj;
        return Objects.equals(title, book.title);
    }
}

// @FunctionalInterface
// interface Human {
// void to(Human human);
// }
//
// class Library {
//
// public Human lend(Book book) {
// return human -> {
// System.out.println("Remove from library.");
// human.add(book);
// };
// }
// }

// public final class ExceptionAssert {
//
// @FunctionalInterface
// public interface ThrowsException<T, R> {
// R throwsException(T value);
// }
//
// @FunctionalInterface
// public interface WithMessage<T> {
// void withMessage(T value);
// }
//
// !!! add version: public static ThrowsException<Class, WithMessage<String>> then(Executable executable) {
// public static ThrowsException<Class, WithMessage<String>> assertThat(Executable executable) {
// return exceptionType -> message -> {
// var exception = org.junit.jupiter.api.Assertions.assertThrows(exceptionType, executable);
// BDDAssertions.then(exception.getMessage()).isEqualTo(message);
// };
// }
// }

// FPF library
// Fluent Preposition Functions
// Functional Prepositions For Fluent API
// Fluent Functional Prepositions api
// FFP - taken

//https://qph.fs.quoracdn.net/main-qimg-c38c730e197f93e1adbf7a8c47968b84
//:) Higher-order functions is a pathway to many abilities some consider to be unnatural. - Supreme Chancellor Palpatine

@FunctionalInterface
interface With<T> {

    void with(
        T value);
}

@FunctionalInterface
interface WithReturn<T, R> {

    R with(
        T value);
}

@FunctionalInterface
interface WithOptional<T, R> {

    Optional<R> with(
        T value);
}

@FunctionalInterface
interface To<T> {

    void to(
        T value);
}

@FunctionalInterface
interface ToReturn<T, R> {

    R to(
        T value);
}

@FunctionalInterface
interface ToOptional<T, R> {

    Optional<R> to(
        T value);
}

@FunctionalInterface
interface From<T> {

    void from(
        T value);
}

@FunctionalInterface
interface In<T> {

    Image in(
        T value);
}

@FunctionalInterface
interface InReturn<T, R> {

    R in(
        T value);
}

@FunctionalInterface
interface InOptional<T, R> {

    Optional<R> in(
        T value);
}

class Human {

    private final List<Book> books = new ArrayList<>();

    void add(
        Book book) {
        System.out.println("Human.add");
        books.add(book);
    }

    void giveBack(
        Book book) {
        books.remove(book);
    }

    // To<Library> giveBack(Book book) {
    // return library -> {
    // availableBooks.remove(book);
    // library.retrieve(book);
    // };
    // }
    // }
}

class X {

    void foo(
        Consumer<Human> consumer) {
        System.out.println("Start transaction");
        final Human human = new Human();
        consumer.accept(human);
        System.out.println("End transaction");
    }
}
//
// class Library {
//
// To<Human> lend(Book book) {
// return human -> {
// System.out.println("Remove from library.");
// //this
// human.add(book);
// };
// }
//
// void retrieve(Book book) {
// }
// }

// interface Books {
// void add(Book book);
// void remove(Book book);
// }
//
// class LibraryBooks implements Books{
//
// private List<Book> availableBooks = new ArrayList<>();
//
// public void add(Book book) {
// availableBooks.add(book);
// }
//
// public void remove(Book book) {
// availableBooks.remove(book);
// }
// }
//
// class Lends implements Books{
// private List<Book> lendts = new ArrayList<>();
//
// public void add(Book book) {
// lendts.add(book);
// }
//
// public void remove(Book book) {
// lendts.remove(book);
// }
// }
class Books {

    private List<Book> books = new ArrayList<>();

    public void add(
        Book book) {
        books.add(book);
    }

    public void remove(
        Book book) {
        books.remove(book);
    }
}

class LendInfo {

    private final Human human;
    private final Book book;

    public LendInfo(
        Human human,
        Book book) {
        this.human = human;
        this.book = book;
    }

    Human human() {
        return human;
    }

    Book book() {
        return book;
    }
}

class LendInfoRepository {

    void add(
        LendInfo lendInfo) {

    }
}

class Library {

    Books availableBooks = new Books();
    Books lendBooks = new Books();
    LendInfoRepository lendInfoRepository = new LendInfoRepository();

    // ToReturn<Human, With<Human>> lend(Book book) {
    To<Human> lend(Book book) {
        return human -> lend(book, human);
    }

    // IoC sustained
    // @Fluent(To<Human>)
    private void lend(
        final Book book,
        final Human human) {
        human.add(book);
        // to much
        append(book).to(lendBooks);
        remove(book).from(availableBooks);
        LendInfo lendInfo = new LendInfo(human, book);
        // add(lendInfo).to(lendInfoRepository);

        lendInfoRepository.add(lendInfo);
        // add(book).with(human).to(lendInfoRepository);
        // return human1 -> human1.add(book);
        // return true;
    }

    // private To<LendInfoRepository> add(final LendInfo lendInfo) {
    // return lendInfoRepository1 -> lendInfoRepository.add(lendInfo);
    // }

    private From<Books> remove(
        final Book book) {
        return books1 -> books1.remove(book);
    }

    private To<Books> append(
        final Book book) {
        return lends1 -> lends1.add(book);
    }

    void add(
        Book book) {
        availableBooks.add(book);
    }

    From<Human> retrieve(
        Book book) {
        return human -> retrieve(book, human);
    }

    private void retrieve(
        Book book,
        Human human) {
        human.giveBack(book);
        remove(book).from(lendBooks);
        append(book).to(availableBooks);
    }

}

// @FunctionalInterface
// interface Function3 <A, B, C, R> {
// //R is like Return, but doesn't have to be last in the list nor named R.
// public R apply (A a, B b, C c);
// }

@FunctionalInterface
interface A {

    B a(
        String a);
}

@FunctionalInterface
interface B {

    C b(
        String b);
}

@FunctionalInterface
interface C {

    D c(
        String c);
}

class D {

    public D(
        final Object a,
        final Object b,
        Object c) {
    }

    public static A create() {
        return a -> b -> c -> new D(a, b, c);
    }
}

class Finder {

    public InOptional<ImageRepository, Image> findImageByName(
        final String name) {
        return imageRepository -> imageRepository.find(image -> image.name()
                                                                     .equals(name));
    }

    //
    // public WithReturn<Predicate<Image>, InOptional<ImageRepository, Image>>> find() {
    // return id -> name -> imageRepository ->
    // imageRepository.find();
    //
    //
    // return imageRepository -> {
    // Optional<Image> image1 = imageRepository.find(image);
    // return integer -> integer.equals(image1.get().id());
    // };
    // }
}

class Image {

    private String image;
    private Integer id;

    public Image(
        final String name,
        Integer id) {
        this.image = name;
        this.id = id;
    }

    Integer id() {
        return id;
    }

    String name() {
        return image;
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, id);
    }

    @Override
    public boolean equals(
        final Object obj) {
        return Objects.equals(image, ((Image)obj).image) && Objects.equals(id, ((Image)obj).id);
    }

    @Override
    public String toString() {
        return id + " " + image;
    }
}

class ImageRepository {

    private List<Image> images = new ArrayList<>();

    void store(
        Image image) {
        images.add(image);
    }

    Optional<Image> find(
        Predicate<Image> predicate) {
        return images.stream()
                     .filter(predicate)
                     .findFirst();
    }

    // Optional<Image> find(Image image) {
    // return images
    // .stream()
    // .filter(image1 -> image1.equals(image))
    // .findFirst();
    // }
}

class Data {

    @Size(min = 3, max = 20)
    String s;

    public Data(
        String s) {
        this.s = s;
    }
}

public class App {

    public static void main(
        final String[] args) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Data data = new Data("x");
        validator.validate(data);

        Finder finder = new Finder();
        final Image image1 = new Image("Peter", 1);
        final Image image2 = new Image("John", 2);
        final Image image3 = new Image("Monica", 3);

        final ImageRepository repository = new ImageRepository();
        repository.store(image1);
        repository.store(image2);
        repository.store(image3);

        Optional<Image> found = finder.findImageByName("John")
                                      .in(repository);

        found.ifPresent(image -> System.out.println("found.get().name() = " + image.name()));

        // Optional<Image> in = finder.find().with(id -> id == 2).with(name -> name.equals("John")).in(repository);

        // in.ifPresent(image -> System.out.println("Image = " + image.toString()));

        D.create()
         .a("a")
         .b("b")
         .c("c");

        X x = new X();
        x.foo(human -> human.add(new Book("xxx")));

        // Library().lend("lend").to("to");

        Library library = new Library();
        final Book book = new Book("Rambo");
        library.add(book);
        Human john = new Human();
        library.lend(book).to(john);

        // library.apply(book).apply(john)
        // john.borrows(book).from(library);
        library.retrieve(book)
               .from(john);
        // john.giveBack(book).to(library);
    }

    public void testCompareTo() {
        final Widget widgetA = new Widget("WidgetA");
        final Widget widgetB = new Widget("WidgetB");
        final Widget widgetAB = new Widget("WidgetAWidgetB");

        assertTrue(widgetA.compareTo(widgetA) == 0); // widgetA == widgetA
        assertTrue(widgetA.compareTo(widgetB) != 0); // widgetA != widgetB
        assertTrue(widgetAB.compareTo(widgetA) == 1); // widgetAB > widgetA
    }

    public void using() {
        // on(prohibitedManeuver).for(net2class).add(value); //INVALID - KEY WORD
        // on(prohibitedManeuver).using(net2class).add(value);
        // on(prohibitedManeuver).applying(net2class).add(value);
        // on(prohibitedManeuver).to(net2class).add(value);value
    }
}
