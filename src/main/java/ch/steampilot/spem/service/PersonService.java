/**
 * Created by Jerome Roethlisberger on 24.05.14.
 */
package ch.steampilot.spem.service;

import ch.steampilot.spem.entity.Person;
import ch.steampilot.spem.transfer.PersonDTO;
import ch.steampilot.spem.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Service Layer to process persons
 */
@Service("personService")
public class PersonService {
	@Autowired
	@Resource(name = "personRepository")
	private PersonRepository personRepository;

	/**
	 * Delegates to PersonRepository to get all Persons
	 * @return the retrieved list of all persons
	 */
	public List getAll(){
		List<Person> personList = personRepository.getAll();
		return personList;
	}

	/**
	 * Delegates to PersonRepository to get one single Person by ID
	 * @param id the identifying id of a single person
	 * @return the retrieved single person
	 */
	public Person getOne(Integer id) {
		Person person = personRepository.getOne(id);
		return person;
	}

	/**
	 * Delegates to PersonRepository to create a new empty Person
	 * @return the new created empty person
	 */
	public Person create() {
		return personRepository.create();
	}

	/**
	 * Delegates to PersonRepository to save the created person
	 * @param person the person to process
	 */
	public void add(Person person){
		personRepository.add(person);
	}

	/**
	 * Delegates to PersonRepository to save the edited Person
	 * @param person the person to process
	 */
	public void edit(Person person) {
		personRepository.edit(person);
	}

	/**
	 * Delegates to PersonRepository to delete the existing Person identified by its id
	 * @param id the identifying id of a single person
	 */
	public void delete(Integer id) {
		personRepository.delete(id);
	}

	/**
	 * Creates a Person Data Transfer Object to consolidate data from one to many associations
	 * @return the list of all created personDTOs
	 */
	public List<PersonDTO> getDTOs(){
		List<PersonDTO> personDTOs = new ArrayList<PersonDTO>();
		List<Person> persons = personRepository.getAll();
		for (Person person: persons) {
			// Create new data transfer object
			PersonDTO dto = new PersonDTO();

			dto.setId(person.getId());
			dto.setTitle(person.getTitle());
			dto.setFirstName(person.getFirstName());
			dto.setLastName(person.getLastName());
			dto.setEmail(person.getEmail());
			dto.setPhone(person.getPhone());
			dto.setAddress1(person.getAddress1());
			dto.setAddress2(person.getAddress2());
			dto.setZipCode(person.getZipCode());
			dto.setCity(person.getCity());
			dto.setCountry(person.getCountry());
			// Add to model list
			personDTOs.add(dto);
		}
		return personDTOs;
	}
}
