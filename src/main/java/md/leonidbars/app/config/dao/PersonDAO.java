package md.leonidbars.app.config.dao;

import md.leonidbars.app.config.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_ID;

    private List<Person> peopleList;

    {
        peopleList = new ArrayList<>();

        peopleList.add(new Person(++PEOPLE_ID, "Leonid", 29, "leonid19@gmail.com"));
        peopleList.add(new Person(++PEOPLE_ID, "Igor", 31, "igor20@gmail.com"));
        peopleList.add(new Person(++PEOPLE_ID, "Cristian", 25, "cristi@mail.com"));
        peopleList.add(new Person(++PEOPLE_ID, "Olga", 45, "olga@mail.ru"));
        peopleList.add(new Person(++PEOPLE_ID, "Serghei", 34, "serghei@yahoo.ru"));
        peopleList.add(new Person(++PEOPLE_ID, "Andrew", 40, "andrew@mail.ru"));

    }

    public List<Person> index(){
        return peopleList;
    }


    public Person show(int id){
        return peopleList.stream().
                filter(person -> person.getId() == id).
                findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_ID);
        peopleList.add(person);
    }

    public void update(int id, Person updatePerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());
    }

    public void delete(int id){
        peopleList.removeIf(person -> person.getId() == id);
    }


}
