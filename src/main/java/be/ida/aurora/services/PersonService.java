package be.ida.aurora.services;

import be.ida.aurora.exceptions.DbException;
import be.ida.aurora.models.Person;

import java.util.List;

public interface PersonService{

    Person postPerson(Person person) throws DbException;

    Person getPerson(long personId) throws DbException;

    List<Person> getPersons() throws DbException;

    Person updatePerson( long personId, Person personBody) throws DbException;

    Person deletePerson(long personId) throws DbException;
}
