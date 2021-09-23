import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Robert", 25, Gender.MALE);
        Person person1 = new Person("Patrik", 37, Gender.MALE);
        Person person2 = new Person("Anna", 27, Gender.FEMALE);
        Person person3 = new Person("Raja", 55, Gender.FEMALE);
        Person person4 = new Person("Den", 34, Gender.MALE);
        Person person5 = new Person("Den", 18, Gender.MALE);

        List<Person> people = getPeople(person, person1, person2, person3, person4, person5);

        Scanner scanner = new Scanner(System.in);
        menu();
        int i = scanner.nextInt();

        switch (i) {
            case 1: {
                people.stream()
                        .filter(p -> p.getGender().equals(Gender.MALE))
                        .filter(p -> p.getAge() >= 18 && p.getAge() < 27)
                        .forEach(System.out::println);
                break;
            }
            case 2: {
                Double collect = people.stream()
                        .filter(p -> p.getGender().equals(Gender.MALE))
                        .filter(p -> p.getAge() != null)
                        .collect(Collectors.averagingDouble(Person::getAge));
                System.out.println("Середній вік чоловіків: " + new DecimalFormat("#0.00").format(collect));
                break;
            }
            case 3: {
                people.stream().filter(p -> {
                    if (p.getGender().equals(Gender.FEMALE) && p.getAge() >= 18 && p.getAge() < 55) {
                        return true;
                    }
                    if (p.getGender().equals(Gender.MALE) && p.getAge() >= 18 && p.getAge() < 60) {
                        return true;
                    }
                    return false;
                }).forEach(System.out::println);
                break;
            }
            case 4: {
                people.stream()
                        .sorted(new SortPerson().sortByNameFromZtoA)
                        .forEach(System.out::println);
                break;
            }
            case 5: {
                people.stream()
                        .sorted(new SortPerson().sortByNameAndAge)
                        .forEach(System.out::println);
                break;
            }
            case 6: {
                Optional<Person> max = people.stream().max(new SortPerson().sortByAge);
                max.ifPresent(System.out::println);
                break;
            }
            case 7: {
                Optional<Person> min = people.stream().min(new SortPerson().sortByAge);
                min.ifPresent(System.out::println);
                break;
            }
            case 8: {
                long count = people.stream().filter(p -> p.getGender().equals(Gender.MALE)).count();
                System.out.println("Кількість чоловіків: " + count);
                break;
            }
            case 9: {
                long count = people.stream().filter(p -> p.getGender().equals(Gender.FEMALE)).count();
                System.out.println("Кількість жінок: " + count);
                break;
            }
            case 10: {
                people.stream().filter(p -> p.getName().startsWith("A")).forEach(System.out::println);
                break;
            }

        }
    }

    private static void menu() {
        System.out.println("Виберіть операцію: ");
        System.out.println("1. Вибрати чоловіків-військовозобов'язаних (від 18 до 27 років).");
        System.out.println("2. Знайти середній вік серед чоловіків.");
        System.out.println("3. Знайти кількість потенційно працездатних людей у вибірці (тобто від 18 років і з\n" +
                "огляду на що жінки виходять в 55 років, а чоловік в 60.");
        System.out.println("4. Відсортувати колекцію людей за ім'ям в зворотному алфавітному порядку.");
        System.out.println("5. Відсортувати колекцію людей спочатку за ім’ям, а потім за віком.");
        System.out.println("6. Знайти найстаршу людину.");
        System.out.println("7. Знайти наймолодшу людину.");
        System.out.println("8. Вивести скільки є чоловіків.");
        System.out.println("9. Вивести скільки є жінок");
        System.out.println("10. Вивеcти всіх жінок в яких ім’я починається на “A”");
    }

    private static List<Person> getPeople(Person person, Person person1, Person person2, Person person3, Person person4, Person person5) {
        List<Person> people = new ArrayList<>();
        people.add(person);
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        return people;
    }


}


