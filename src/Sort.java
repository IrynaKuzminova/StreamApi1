import java.util.Comparator;

public interface Sort extends Comparator<Person> {
    @Override
    default int compare(Person o1, Person o2) {
        return 0;
    }
}
