package be.ida.aurora.repositories;

import be.ida.aurora.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PersonRepository extends CrudRepository<Person, Long>{

}