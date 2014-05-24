/**
 * Created by Jerome Roethlisberger on 24.05.14.
 */
package ch.steampilot.spem.service;

import ch.steampilot.spem.repository.PersonRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("personService")
public class PersonService {
	protected static Logger logger = Logger.getLogger("service");
	@Resource(name = "personRepository")
	private PersonRepository personRepository;

}
