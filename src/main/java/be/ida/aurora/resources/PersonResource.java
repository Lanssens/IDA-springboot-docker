package be.ida.aurora.resources;

import be.ida.aurora.models.Person;
import be.ida.aurora.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonResource {

    @Autowired
    PersonService personService;

    /**
     * POST --> Create a new person and save it in the database.
     */

    @PostMapping
    public Person postPerson(@RequestBody Person person) {
        person = personService.postPerson(person);
        return person;
    }

    /**
     * GET --> Get a person by person id from the database.
     */

    @GetMapping("/{personId}")
    public Person getPerson(@PathVariable long personId) {
        Person person = personService.getPerson(personId);
        return person;
    }

    /**
     * GET ALL  --> Get all people from the database.
     */

    @GetMapping
    public List<Person> getPersons() {
        List<Person> persons = personService.getPersons();
        return persons;
    }

    /**
     * UPDATE  --> Update a person record and save it in the database.
     */

    @RequestMapping("/{personId}")
    public Person updatePerson(@PathVariable long personId, @RequestBody Person personBody) {
        Person person = personService.updatePerson( personId, personBody );
        return person;
    }

    /**
     * DELETE  --> Delete a person from the database.
     */

    @DeleteMapping("/{personId}")
    public Person deletePerson(@PathVariable long personId) {
        Person person = personService.deletePerson( personId );
        return person;
    }
}
