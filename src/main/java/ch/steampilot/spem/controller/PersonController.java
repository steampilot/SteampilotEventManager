/**
 * Created by Jerome Roethlisberger on 16.05.14.
 */
package ch.steampilot.spem.controller;
import java.util.List;

import javax.annotation.Resource;

import ch.steampilot.spem.entity.Person;
import ch.steampilot.spem.repository.PersonRepository;
import ch.steampilot.spem.service.PersonService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Handles and retrieves person request
 */
@Controller("PersonController")
@RequestMapping("/spem")
public class PersonController {
	protected static Logger logger = Logger.getLogger("controller");
	@Resource(name = "personRepository")
	private PersonRepository personRepository;
	@Resource(name = "personService")
	private PersonService personService;

	/**
	 * Handles and retrieves all persons and show it in a JSP page
	 *
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String getPersons(Model model) {

		logger.debug("Received request to show all persons");

		// Retrieve all persons by delegating the call to PersonRepository
		List<Person> persons = personRepository.getAll();

		// Attach persons to the Model
		model.addAttribute("persons", persons);

		// This will resolve to /WEB-INF/pages/person/list.jsp
		return "person/list";
	}


	/**
	 * Retrieves the add page
	 *
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/persons/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		logger.debug("Received request to show add page");

		// Create new Person and add to model
		// This is the formBackingObject
		model.addAttribute("personAttribute", new Person());

		// This will resolve to /WEB-INF/pages/person/add.jsp
		return "person/add";
	}

	/**
	 * Adds a new person by delegating the processing to PersonRepository.
	 * Displays a confirmation JSP page
	 *
	 * @return  the name of the JSP page
	 */
	@RequestMapping(value = "/persons/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("personAttribute") Person person) {
		logger.debug("Received request to add new person");

		// The "personAttribute" model has been passed to the controller from the JSP
		// We use the name "personAttribute" because the JSP uses that name

		// Call PersonRepository to do the actual adding
		personRepository.add(person);

		// This will re to /WEB-INF/pages/person/after-add.jsp
		return "person/after-add";
	}
	/**
	 * Retrieves the view page
	 *
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/persons/view", method = RequestMethod.GET)
	public String getView(@RequestParam(value="id", required=true) Integer id, Model model) {
		logger.debug("Received request to show view page");

		// Retrieve existing Person and add to model
		// This is the formBackingObject
		model.addAttribute("personAttribute", personRepository.get(id));

		// This will resolve to /WEB-INF/pages/person/view.jsp
		return "/person/view";
	}
	/**
	 * Retrieves the edit page
	 *
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/persons/edit", method = RequestMethod.GET)
	public String getEdit(@RequestParam(value="id", required=true) Integer id, Model model) {
		logger.debug("Received request to show edit page");

		// Retrieve existing Person and add to model
		// This is the formBackingObject
		model.addAttribute("personAttribute", personRepository.get(id));

		// This will resolve to /WEB-INF/pages/person/edit.jsp
		return "person/edit";
	}
	/**
	 * Edits an existing person by delegating the processing to PersonRepository.
	 * Displays a confirmation JSP page
	 *
	 * @return  the name of the JSP page
	 */
	@RequestMapping(value = "/persons/edit", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("personAttribute") Person person,
	                       @RequestParam(value="id", required=true) Integer id, Model model) {
		logger.debug("Received request to update person");

		// The "personAttribute" model has been passed to the controller from the JSP
		// We use the name "personAttribute" because the JSP uses that name

		// We manually assign the id because we disabled it in the JSP page
		// When a field is disabled it will not be included in the ModelAttribute
		person.setId(id);

		// Delegate to PersonRepository for editing
		personRepository.edit(person);

		// Add id reference to Model
		model.addAttribute("id", id);

		// This will resolve to /WEB-INF/pages/person/after-edit.jsp
		return "person/after-edit";
	}

	/**
	 * Deletes an existing person by delegating the processing to PersonRepository.
	 * Displays a confirmation JSP page
	 *
	 * @return  the name of the JSP page
	 */
	@RequestMapping(value = "/persons/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value="id", required=true) Integer id,
	                     Model model) {

		logger.debug("Received request to delete existing person");

		// Call PersonRepository to do the actual deleting
		personRepository.delete(id);

		// Add id reference to Model
		model.addAttribute("id", id);

		// This will resolve to /WEB-INF/pages/after-delete.jsp
		return "person/after-delete";
	}
}
