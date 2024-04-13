public class Person<T>{
    T parcel;
    T nextPerson;
    public Person(T parcel, T nextPerson) {
        if (parcel == null) {
            throw new IllegalArgumentException("Parcel is set to null and shouldn't be.");
        }
        this.parcel = parcel;
        this.nextPerson = nextPerson;
    }
    public Person(T parcel) {
        this(parcel, null);
    }
    public T getParcel() {
        return parcel;
    }
    public void setParcel(T parcel) {
        this.parcel = parcel;
    }

    public T getNextPerson() {
        return nextPerson;
    }

    public void setNextPerson(T nextPerson) {
        this.nextPerson = nextPerson;
    }
}
