package be.ida.aurora.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERSONS")
public class Person implements Serializable{

    /**
     * PERSON KLASSE
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long personId;
    @Column
    String firstName;
    @Column
    String lastName;
    @Column
    String email;

    public Long getPersonId(){
        return personId;
    }

    public void setPersonId( Long personId ){
        this.personId = personId;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName( String firstName ){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName( String lastName ){
        this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail( String email ){
        this.email = email;
    }
}
