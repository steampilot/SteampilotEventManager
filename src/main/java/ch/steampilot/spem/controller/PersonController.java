/**
 * Created by Jerome Roethlisberger on 16.05.14.
 */
package ch.steampilot.spem.controller;
import ch.steampilot.spem.entity.Person;
import ch.steampilot.spem.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;


/**
 * Handles and retrieves person request
 */
@Controller("PersonController")
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	@Resource(name="personService")
	private PersonService personService;

	/**
	 * Handles and retrieves all persons and show it in a JSP page
	 *
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getRecords(Model model) {

		model.addAttribute("persons", personService.getDTOs());

		// This will resolve to /WEB-INF/pages/person/list.jsp
		return "persons/list";
	}

	/**
	 * Retrieves the add page
	 *
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd(Model model) {

		// Create new Person and add to transfer
		// This is the formBackingObject
		model.addAttribute("personAttribute", personService.create());

		// This will resolve to /WEB-INF/pages/person/add.jsp
		return "persons/add";
	}

	/**
	 * Adds a new person by delegating the processing to PersonRepository.
	 * Displays a confirmation JSP page
	 *
	 * @return  the name of the JSP page
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(@ModelAttribute("personAttribute") Person person) {

		// The "personAttribute" transfer has been passed to the controller from the JSP
		// We use the name "personAttribute" because the JSP uses that name

		// Call PersonService to do the actual adding
		personService.add(person);

		// This will re to /WEB-INF/pages/person/list.jsp
		return "redirect:list";
	}

	/**
	 * Retrieves the edit page
	 *
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getEdit(@RequestParam(value="id", required=true) Integer id, Model model) {

		// Retrieve existing Person and add to transfer
		// This is the formBackingObject
		model.addAttribute("personAttribute", personService.get(id));

		// This will resolve to /WEB-INF/pages/person/edit.jsp
		return "persons/edit";
	}
	/**
	 * Edits an existing person by delegating the processing to PersonRepository.
	 * Displays a confirmation JSP page
	 *
	 * @return  the name of the JSP page
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String postEdit(@RequestParam("id") Integer id,
	                       @ModelAttribute("personAttribute") Person person) {

		// The "personAttribute" transfer has been passed to the controller from the JSP
		// We use the name "personAttribute" because the JSP uses that name

		// We manually assign the id because we disabled it in the JSP page
		// When a field is disabled it will not be included in the ModelAttribute
		person.setId(id);

		// Delegate to PersonRepository for editing
		personService.edit(person);

		// This will resolve to /WEB-INF/pages/person/list.jsp
		return "redirect:list";
	}

	/**
	 * Deletes an existing person by delegating the processing to PersonRepository.
	 * Displays a confirmation JSP page
	 *
	 * @return  the name of the JSP page
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam(value="id")Integer id) {

		// Delete all associations first
		// creditCardService.deleteAll(personId);
		// Call PersonRepository to do the actual deleting
		personService.delete(id);

		// This will resolve to /WEB-INF/pages/person/list.jsp
		return "redirect:list";
	}

}
