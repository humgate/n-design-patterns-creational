package builder;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    public static final int UNKNOWN_AGE = 0;
    public static final String UNKNOWN_ADDRESS = "unknown";

    //имя после создания персоны менять нельзя поэтому final
    protected final String name;

    //фамилию после создания персоны менять нельзя поэтому final
    protected final String surName;

    //age == UNKNOWN_AGE будет означать что возраст неизвестен
    protected int age = UNKNOWN_AGE;

    //city == UNKNOWN_ADDRESS будет означать что город неизвестен
    protected String city = UNKNOWN_ADDRESS;

    /* Мне кажется логичным, чтобы за пределами пакета нельзя было вызвать этот конструктор
    * А, внутри билдера мы сделаем так, чтобы конструктор вызывался с правильными аргументами,
    * он на то и билдер чтобы этим заниматься
    */
    protected Person(String name, String surName, int age) throws IllegalArgumentException {
        if (name != null && !name.isEmpty() &&
                surName != null && !surName.isEmpty() &&
                age >= 0
        ) {
            this.name = name;
            this.surName = surName;
            this.age = age;
        } else throw new IllegalArgumentException("Недопустимые параметры создания builder.Person");
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setSurname(this.surName);
        personBuilder.setAddress(this.getAddress());
        return personBuilder;
    }

    public boolean hasAge() {
        return age != UNKNOWN_AGE;
    }

    public boolean hasAddress() {
        return !city.equals(UNKNOWN_ADDRESS);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surName;
    }

    public OptionalInt getAge() {
        return age != UNKNOWN_AGE ? OptionalInt.of(age) : OptionalInt.empty();
    }

    public String getAddress() {
        return city;
    }

    public String setAddress(String address) {
        return city = address;
    }

    public void happyBirthday() {
       age++;
    }

    @Override
    public String toString() {
        return name + " " + surName + " " + age + " лет от роду, " + "из г. " + city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surName, person.surName) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, age, city);
    }
}
