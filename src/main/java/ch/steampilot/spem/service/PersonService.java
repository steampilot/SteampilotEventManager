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

@Service("personService")
public class PersonService {
	@Autowired
	@Resource(name = "personRepository")
	private PersonRepository personRepository;

	public List getAll(){
		List<Person> personList = personRepository.getAll();
		return personList;
	}
	public Person get(Integer id) {
		Person person = personRepository.get(id);
		return person;
	}
	public Person create() {
		return personRepository.create();
	}

	public void add(Person person){
		personRepository.add(person);
	}

	public void edit(Person person) {
		personRepository.edit(person);
	}
	public void delete(Integer id) {
		personRepository.delete(id);
	}

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
