package be.ida.aurora.resources;

import be.ida.aurora.exceptions.DbException;
import be.ida.aurora.models.Person;
import be.ida.aurora.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Person> postPerson(@RequestBody Person person) {
        try{
            person = personService.postPerson(person);
            return new ResponseEntity<>( person, HttpStatus.CREATED );
        }catch( DbException db ){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }

    /**
     * GET --> Get a person by person id from the database.
     */

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getPerson(@PathVariable long personId) {
        try{
            Person person = personService.getPerson(personId);
            return new ResponseEntity<>( person, HttpStatus.CREATED );
        }catch( DbException db ){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }

    /**
     * GET ALL  --> Get all people from the database.
     */

    @GetMapping
    public ResponseEntity<List<Person>> getPersons() {
        try{
            List<Person> persons = personService.getPersons();
            return new ResponseEntity<>( persons, HttpStatus.CREATED );
        }catch( DbException db ){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }

    /**
     * UPDATE  --> Update a person record and save it in the database.
     */

    @RequestMapping("/{personId}")
    public ResponseEntity<Person> updatePerson(@PathVariable long personId, @RequestBody Person personBody) {
        try{
            Person person = personService.updatePerson( personId, personBody );
            return new ResponseEntity<>( person, HttpStatus.CREATED );
        }catch( DbException db ){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }

    /**
     * DELETE  --> Delete a person from the database.
     */

    @DeleteMapping("/{personId}")
    public ResponseEntity<Person> deletePerson( @PathVariable long personId) {
        try{
            Person person = personService.deletePerson( personId );
            return new ResponseEntity<>( person, HttpStatus.CREATED );
        }catch( DbException db ){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }
}
