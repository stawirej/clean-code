package presentation;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Hello world!
 */
public class App {

    public static void main(final String[] args) {

        final Map<Entry<String, Integer>, List<String>> a;
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
//        on(prohibitedManeuver).for(net2class).add(value); //INVALID - KEY WORD
//        on(prohibitedManeuver).using(net2class).add(value);
//        on(prohibitedManeuver).applying(net2class).add(value);
//        on(prohibitedManeuver).to(net2class).add(value);value
    }
}
