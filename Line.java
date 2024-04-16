import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Generic class that represents a line. A Line is comprised of
 * Person instances that are linked together. This class implements
 * all the methods required by the provided List interface. It uses the
 * Person and LineIterator classes to satisfy the requirements.
 * @param <T> represents the type of parcel that persons in this line carry
 */
public class Line<T> implements List<T> {
    private Person<T> firstPerson;
    private int size;

    /**
     * Constructor that takes in an array of parcels to type T.
     * @param parcel T representing the parcel in line
     */
    public Line(T[] parcel) {
        firstPerson = new Person<>(parcel[0]);
        for (T t : parcel) {
            add(t);
        }
    }

    /**
     * Constructor that creates an empty list.
     */
    public Line() {
        firstPerson = null;
    }

    /**
     * Getter that returns the firstPerson in line.
     * @return Person representing the first person in line
     */
    public Person<T> getFirstPerson() {
        return firstPerson;
    }

    /**
     * Returns the parcel that each person carries in an array.
     * @return an array of type T representing the parcel that each person
     * carries in this line.
     */
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
        if (element == null) {
            throw new IllegalArgumentException("Cannot add null parcel. Error 1");
        }
        if (firstPerson == null) {
            firstPerson = new Person<>(element);
            size++;
            return;
        }
        Person<T> current = firstPerson;
        while (current.getNextPerson() != null) {
            current = current.getNextPerson();
        }
        Person<T> newPerson = new Person<>(element);
        current.setNextPerson(newPerson);
        size++;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        //24.4.3.3
        if (isValidIndex(index)) throw new IndexOutOfBoundsException("Invalid index. Error 2");
        if (element == null) throw new IllegalArgumentException("Cannot add null parcel. Error 3");
        Person<T> personToAdd;
        if (index == 0) {
            personToAdd = new Person<>(element, firstPerson);
            firstPerson = personToAdd;
            size++;
            return;
        } else {
            Person<T> current = firstPerson;
            for (int i = 1; i < index; i++) {
                current = current.getNextPerson();
            }
            Person<T> temp = current.getNextPerson();
            personToAdd = new Person<>(element, temp);
            current.setNextPerson(personToAdd);
        }
        size ++;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (size == 0) throw new NoSuchElementException("Cannot remove parcel from 0 size line. Error 4");
        else {
            Person<T> temp = firstPerson.getNextPerson();
            firstPerson = temp;
            size--;
            return temp.getParcel();
        }
    }

    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        if (isValidIndex(index)) {
            if (size == 0) {
                throw new NoSuchElementException("Size is zero, and index is invalid. Error 5");
            }
            throw new IndexOutOfBoundsException("Invalid index. Error 6");
        }
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
    }

    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        if (element == null) {
            throw new IllegalArgumentException("Parcel cannot be null. Error 7");
        }
        Person<T> current = firstPerson;
        for (int i = 0; i < size; i++) {
            if (current.getParcel().equals(element)) {
                return remove(i);
            }
            current = current.getNextPerson();
        }
        throw new NoSuchElementException("Parcel is not in this line! Error 8");
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (element == null) {
            if (isValidIndex(index)) {
                throw new IndexOutOfBoundsException("Invalid index, and element. Error 9");
            }
            throw new IllegalArgumentException("Parcel cannot be null. Error 10");
        } else if (isValidIndex(index)) {
            throw new IndexOutOfBoundsException("Invalid index. Error 11");
        }
        Person<T> previousPerson = firstPerson;
        Person<T> setPerson;
        if (index == 0) {
            setPerson = new Person<>(element, firstPerson.getNextPerson());
            firstPerson = setPerson;
        }
        for (int i = 1; i < index; i++) {
            previousPerson = previousPerson.getNextPerson();
        }
        Person<T> nextPerson = previousPerson.getNextPerson();
        setPerson = new Person<>(element, nextPerson.getNextPerson());
        previousPerson.setNextPerson(setPerson);
        return nextPerson.getParcel();
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (isValidIndex(index)) throw new IndexOutOfBoundsException("Invalid index called. Error 12");

        Iterator<T> itr = this.iterator();
        Person<T> current = firstPerson;
        int counter = 0;
        while (itr.hasNext()) {
            if (counter == index) break;
            else itr.next();
            counter++;
        }
        return itr.next();
    }

    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        if (element == null) throw new IllegalArgumentException("Parcel cannot be null. Error 13");
        Iterator<T> itr = this.iterator();
        while(itr.hasNext()) {
            if(itr.next().equals(element)) return true;
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        firstPerson = null;
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

    /**
     * Recursively reverses the order of the Person instances in the Line.
     */
    public void reverse() {
        reverseRecursion(0);
    }
    private void reverseRecursion(int counter) {
        if (counter / 2 == size / 2) return;
        Person<T> head = getHead(counter);
        Person<T> tail = getTail(counter);
        Person<T> temp = head;
        head.setNextPerson(tail.getNextPerson());
        head.setParcel(tail.getParcel());
        tail.setNextPerson(temp.getNextPerson());
        tail.setParcel(temp.getParcel());


        temp = null;
        reverseRecursion(++counter);
    }
    private void revRecursion(Person<T> current, Person<T> prev) {

    }
    private Person<T> getHead(int index) {
        Person<T> head = firstPerson;
        for (int i = 0; i < index; i++) {
            head = head.getNextPerson();
        }
        return head;
    }
    private Person<T> getTail(int index) {
        Person<T> tail = firstPerson;
        for (int i = 0; i < size - index - 1; i ++) {
            tail = tail.getNextPerson();
        }
        return tail;
    }
    private boolean isValidIndex(int index) {
        return (index < 0 || index >= size);
    }

}
