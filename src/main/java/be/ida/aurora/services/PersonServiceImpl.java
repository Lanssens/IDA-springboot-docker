package be.ida.aurora.services;

import be.ida.aurora.exceptions.DbException;
import be.ida.aurora.models.Person;
import be.ida.aurora.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepository;

    /**
     * POST --> Create a new person and save it in the database.
     */

    public Person postPerson(Person person) throws DbException{
        try{
            return personRepository.save(person);
        }catch( Exception e ){
            throw new DbException( "Error in aurora" );
        }
    }

    /**
     * GET --> Get a person by person id from the database.
     */

    public Person getPerson(long personId) throws DbException{
        try{
            return personRepository.findOne(personId);
        }catch( Exception e ){
            throw new DbException( "Error in aurora" );
        }
    }

    /**
     * GET ALL  --> Get all people from the database.
     */

    public List<Person> getPersons() throws DbException{
        try{
            return (List<Person>)personRepository.findAll();
        }catch( Exception e ){
            throw new DbException( "Error in aurora" );
        }
    }

    /**
     * UPDATE  --> Update a person record and save it in the database.
     */

    public Person updatePerson( long personId, Person personBody) throws DbException{
        try{
            Person person = personRepository.findOne(personId);
            person.setEmail(personBody.getEmail(  ));
            person.setFirstName(personBody.getFirstName(  ));
            person.setLastName(personBody.getLastName(  ));
            return personRepository.save(person);
        }catch( Exception e ){
            throw new DbException( "Error in aurora" );
        }
    }

    /**
     * DELETE  --> Delete a person from the database.
     */

    public Person deletePerson(long personId) throws DbException{
        try{
            Person person = personRepository.findOne(personId);
            personRepository.delete(personId);
            return person;
        }catch( Exception e ){
            throw new DbException( "Error in aurora" );
        }
    }
}
