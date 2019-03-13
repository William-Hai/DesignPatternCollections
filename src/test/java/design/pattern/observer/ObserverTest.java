package design.pattern.observer;

import design.pattern.observer.framework.NumberGenerator;
import design.pattern.observer.framework.Observer;
import org.junit.Test;

public class ObserverTest {

    @Test
    public void testObserver() {
        Observer o1 = new DigitObserver();
        Observer o2 = new GraphObserver();
        Observer o3 = new CycleObserver();

        NumberGenerator g1 = new RandomNumberGenerator();
        g1.registerChangedObserver(o1);
        g1.registerChangedObserver(o2);
        g1.registerCycleObserver(o3, 2);
        for (int i = 0; i < 5; i++) {
            g1.generate();
            g1.publish();
            System.out.println();
        }

        NumberGenerator g2 = new IncrementNumberGenerator();
        g2.registerChangedObserver(o1);
        g2.registerChangedObserver(o2);
        for (int i = 0; i < 5; i++) {
            g2.generate();
            g2.publish();
            System.out.println();
        }
    }
}
