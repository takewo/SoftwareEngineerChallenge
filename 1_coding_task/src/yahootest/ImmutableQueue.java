package yahootest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableQueue<T> implements Queue<T> {

    private List<T> items;

    public ImmutableQueue() {
        this.items = Collections.unmodifiableList(Collections.emptyList());
    }

    public ImmutableQueue(List<T> initial) {
        this.items = Collections.unmodifiableList(initial);
    }

    @Override
    public Queue<T> enQueue(T t) {
        List<T> modifiable = new ArrayList<>(items);
        modifiable.add(t);
        return new ImmutableQueue<>(modifiable);
    }

    @Override
    public Queue<T> deQueue() {
        List<T> modifiable = new ArrayList<>(items);
        if (!modifiable.isEmpty()) {
            modifiable.remove(0);
        }
        return new ImmutableQueue<>(modifiable);
    }

    @Override
    public T head() {
        return items.get(0);
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
