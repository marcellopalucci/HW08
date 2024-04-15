import java.util.Iterator;

public class LineIterator<T> implements Iterator<T> {
    private Person<T> nextPerson;
    public LineIterator(Line line) {
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
        T t = nextPerson.parcel;
        nextPerson = (Person<T>) nextPerson.getNextPerson();
        return t;
    }
}
