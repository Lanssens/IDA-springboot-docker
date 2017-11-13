package be.ida.aurora.resources;

import be.ida.aurora.models.Person;
import be.ida.aurora.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonResource {

    @Autowired
    PersonRepository personRepository;

    /**
     * POST --> Create a new person and save it in the database.
     */

    @PostMapping
    public Person postPerson(@RequestBody Person person) {
        person = personRepository.save(person);
        return person;
    }

    /**
     * GET --> Read a person by person id from the database.
     */

    @GetMapping("/{personId}")
    public Person getPerson(@PathVariable long personId) {
        Person person = personRepository.findOne(personId);
        return person;
    }

    /**
     * GET ALL  --> Read all persons from the database.
     */

    @GetMapping
    public List<Person> getPersons() {
        List<Person> persons = (List<Person>)personRepository.findAll();
        return persons;
    }

    /**
     * UPDATE  --> Update a person record and save it in the database.
     */

    @RequestMapping("/{personId}")
    public Person updatePerson(@PathVariable long personId, @RequestBody Person personBody) {
        Person person = personRepository.findOne(personId);
        person.setEmail(personBody.getEmail(  ));
        person.setFirstName(personBody.getFirstName(  ));
        person.setLastName(personBody.getLastName(  ));
        person = personRepository.save(person);
        return person;
    }

    /**
     * DELETE  --> Delete a person from the database.
     */

    @DeleteMapping("/{personId}")
    public String deletePerson(@PathVariable long personId) {
        personRepository.delete(personId);
        return "person #"+personId+" deleted successfully";
    }
}
