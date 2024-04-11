import java.util.Iterator;
import java.util.NoSuchElementException;

// TODO JAVADOC
public class Line<T> implements List<T> {

    private Person<T> firstPerson;
    private int size;

    // TODO JAVADOC
    public Line(T[] parcel) {
        // FIXME
    }

    // TODO JAVADOC
    public Line() {
        // FIXME
    }

    // TODO JAVADOC
    public Person<T> getFirstPerson() {
        return firstPerson;
    }

    // TODO JAVADOC
    public T[] toArray() {
        return null; // FIXME
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("===== LINE %d =====\nisEmpty: %b\nsize: %d\nfirstPerson: %s\n: [",
                        hashCode(),
                        isEmpty(),
                        size(),
                        (firstPerson == null ? "null" : firstPerson.getParcel())));

        T[] people = toArray();
        if (people == null) {
            sb.append("TODO: Implement toArray method...");
        } else {
            for (int i = 0; i < people.length - 1; ++i) {
                sb.append(String.format("%s, ", people[i])); // append all but last value
            }
            if (people.length > 0) {
                sb.append(String.format("%s", people[people.length - 1])); // append last value
            }
        }
        sb.append("]\n============================");
        return sb.toString();
    }

    @Override
    public void add(T element) throws IllegalArgumentException {
        // FIXME
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        // FIXME
    }

    @Override
    public T remove() throws NoSuchElementException {
        return null; // FIXME
    }

    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        return null; // FIXME
    }

    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        return null; // FIXME
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        return null; // FIXME
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        return null; // FIXME
    }

    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        return false; // FIXME
    }

    @Override
    public void clear() {
        // FIXME
    }

    @Override
    public boolean isEmpty() {
        return false; // FIXME
    }

    @Override
    public int size() {
        return 0; // FIXME
    }

    @Override
    public Iterator<T> iterator() {
        return null; // FIXME
    }

    // TODO JAVADOC
    public void reverse() {
        // FIXME
    }
}
