public class SortPerson implements Sort {

    Sort sortByNameFromZtoA = new Sort() {
        @Override
        public int compare(Person o1, Person o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };

    Sort sortByAge = new Sort() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge().compareTo(o2.getAge());
        }
    };
    Sort sortByNameAndAge = new Sort() {
        @Override
        public int compare(Person o1, Person o2) {
            int res = o1.getName().compareTo(o2.getName());
            if (res == 0) return o1.getAge().compareTo(o2.getAge());
            return res;
        }
    };

}
