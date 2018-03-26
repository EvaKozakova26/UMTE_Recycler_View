package cz.uhk.fim.kozakev1.demofragment.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kozakev1 on 19.03.2018.
 */

public class PersonData extends ArrayList<Person> {
//    Person person = new Person();
//    List<Person> personList = new ArrayList<>();
//
//
//    public List<Person> getAll() {
//        return  personList;
//    }
//
//    public void add(String name, int age, boolean male) {
//        person.setName(name);
//        person.setAge(age);
//        person.setMale(male);
//
//    }

    // vraci nehlede na instanci to stejne
    public static PersonData newTestInstance() {
        PersonData testPersonData = new PersonData();
        testPersonData.add(new Person("Eva", 22, false));
        testPersonData.add(new Person("David", 24, true));
        testPersonData.add(new Person("Katka", 24, false));
        testPersonData.add(new Person("Eva", 22, false));
        testPersonData.add(new Person("David", 24, true));
        testPersonData.add(new Person("Katka", 24, false));
        return testPersonData;
    }


}
