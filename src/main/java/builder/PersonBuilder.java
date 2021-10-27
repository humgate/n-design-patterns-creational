package builder;

public class PersonBuilder {

    private String name = null;
    private String surName = null;
    private int age = Person.UNKNOWN_AGE;
    private String city = Person.UNKNOWN_ADDRESS;

    public PersonBuilder setName(String name) throws IllegalArgumentException {
        if (name != null && !name.isEmpty()) {
            this.name = name;
            return this;
        } else {
            throw new IllegalArgumentException("Указано недопустимое значение имени: null для создания builder.Person");
        }
    }

    public PersonBuilder setSurname(String surname) throws IllegalArgumentException {
        if (surname != null && !surname.isEmpty()) {
            this.surName = surname;
            return this;
        } else {
            throw new IllegalArgumentException("Указано недопустимое значение фамилии: null для создания builder.Person");
        }
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        /*
        * по условиям задания возраст может быть неизвестен, и для этого выбрано значение
        * builder.Person.UNKNOWN_AGE, поэтому недопустимыми являются все значения кроме builder.Person.UNKNOWN_AGE и
        * положительных
        */
        if (age == Person.UNKNOWN_AGE || age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Указано недопустимое значение возраста для создания builder.Person");
        }
        return this;
    };

    public PersonBuilder setAddress(String address) {
        /*
         * по условиям задания адрес может быть неизвестен, и для этого выбрано значение
         * builder.Person.UNKNOWN_ADDRESS, поэтому null будем считать недопустимым значением. Так же будем
         * считать недопустимым значением пустую строку
         */
        if (address != null && !address.isEmpty()) {
            this.city = address;
        } else {
            throw new IllegalArgumentException("Указано недопустимое значение адреса для создания builder.Person");
        }
        return this;
    }

    public Person build() throws IllegalStateException {
        if (name != null && surName != null) {//значит их задали
            Person person = new Person(name, surName, age);
            person.setAddress(city);
            return person;
        } else {
            throw new IllegalStateException("Не указаны все необходимые параметры для создания builder.Person");
        }
    }
}
