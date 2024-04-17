import java.util.Iterator;

/**
 * Line iterator which implements the Iterator interface.
 * @param <T> representing the generic element held by a person
 * @author mpalucci3
 * @version 1.3
 */
public class LineIterator<T> implements Iterator<T> {
    private Person<T> nextPerson;

    /**
     * Constructor which takes in a Line and sets the next person.
     * @param line Line representing the list of people in line
     */
    public LineIterator(Line<T> line) {
        if (line == null) {
            throw new IllegalArgumentException();
        }
        this.nextPerson = line.getFirstPerson();
    }
    @Override
    public boolean hasNext() {
        return (nextPerson != null);
    }
    @Override
    public T next() {
        T t = nextPerson.getParcel();
        nextPerson = nextPerson.getNextPerson();
        return t;
    }
}
