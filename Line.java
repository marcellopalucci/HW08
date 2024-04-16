import java.util.Iterator;
import java.util.NoSuchElementException;

// TODO JAVADOC
public class Line<T> implements List<T> {
    private Person<T> firstPerson;
    private int size;

    // TODO JAVADOC
    public Line(T[] parcel) {
        firstPerson = new Person<>(parcel[0]);
        for (int i = 0; i < parcel.length; i++) {
            add(parcel[i]);
        }
    }

    /**
     * Create an empty list
     */
    public Line() {
        firstPerson = null;
    }

    /**
     * Returns the first person in the line
     * @return Person<T> representing the first person in line
     */
    public Person<T> getFirstPerson() {
        if (size == 0) return null;
        return firstPerson;
    }

    // TODO JAVADOC
    public T[] toArray() {
        T[] arr = (T[]) new Object[size];
        Iterator<T> itr = this.iterator();
        int i = 0;
        while (itr.hasNext()) {
            arr[i++] = itr.next();
        }
        return arr;
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
        // addFirst (24.4.3.1)
        if (firstPerson == null) {
            firstPerson = new Person<>(element);
            size++;
            return;
        }
        Person<T> newPerson = new Person<>(element);
        newPerson.nextPerson = firstPerson;
        firstPerson = newPerson;
        size++;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        //24.4.3.3
        //if index == 0 then add to head
        if (index > size) throw new IndexOutOfBoundsException("Index cannot exceed size");
        if (element == null) throw new IllegalArgumentException("Illegal argument, element");
        if (index == 0) {
            add(element);
        } else {
            Person<T> current = firstPerson;
            for (int i = 1; i < index; i++) {
                current = current.getNextPerson();
            }

            Person<T> temp = current.getNextPerson();
            Person<T> personToAdd = new Person<>(element, current.getNextPerson());
            current.setNextPerson(personToAdd);
        }
        size ++;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (size == 0) return null;
        //throw new NoSuchElementException("Element was not found");
        else {
            Person<T> temp = firstPerson;
            firstPerson = firstPerson.getNextPerson();
            size--;
            return temp.getParcel();
        }
    }

    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Cannot remove at this index");
        else if (index == 0) return remove();
        else {
            Person<T> previous = firstPerson;
            for (int i = 1; i < index; i++) {
                previous = previous.getNextPerson();
            }
            Person<T> current = previous.getNextPerson();
            previous.setNextPerson(current.getNextPerson());
            size --;
            return current.getParcel();
        }
       // throw new NoSuchElementException("Element was not");
    }

    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        Person<T> current = firstPerson;
        for (int i = 0; i < size; i++) {
            if (current.getParcel().equals(element)) {
                return remove(i);
            }
            current = current.nextPerson;
        }
        return null;
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        return null; // FIXME
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        Person<T> current = getFirstPerson();
        for (int i = 0; i < index; i++) {
            current = current.getNextPerson();
        }
        return current.getParcel();
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
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LineIterator(this);
    }

    // TODO JAVADOC
    public void reverse() {
        // FIXME
    }

}
