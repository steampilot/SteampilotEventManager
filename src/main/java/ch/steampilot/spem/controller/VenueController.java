/**
 * Created by Jerome Roethlisberger on 16.05.14.
 */
package ch.steampilot.spem.controller;
import ch.steampilot.spem.entity.Venue;
import ch.steampilot.spem.service.PersonService;
import ch.steampilot.spem.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;


/**
 * Handles and retrieves venue request
 */
@Controller("VenueController")
@RequestMapping("/venues")
public class VenueController {

	@Autowired
	@Resource(name="venueService")
	private VenueService venueService;

	@Autowired
	@Resource(name="personService")
	private PersonService personService;

	/**
	 * Handles and retrieves all venues and show it in a JSP page
	 *
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getRecords(Model model) {

		model.addAttribute("venues", venueService.getDTOs());

		// This will resolve to /WEB-INF/pages/venue/list.jsp
		return "venues/list";
	}

	/**
	 * Retrieves the add page
	 *
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd(Model model) {

		// Create new Venue and add to transfer
		// This is the formBackingObject
		model.addAttribute("venueAttribute", venueService.create());
		model.addAttribute("personList", personService.getDTOs());
		// This will resolve to /WEB-INF/pages/venues/add.jsp
		return "venues/add";
	}

	/**
	 * Adds a new venue by delegating the processing to VenueService.
	 *
	 * @return  Redirect to list all venues
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(@ModelAttribute("venueAttribute") Venue venue) {

		// The "venueAttribute" transfer has been passed to the controller from the JSP
		// We use the name "venueAttribute" because the JSP uses that name

		// Call VenueService to do the actual adding
		venueService.add(venue);

		// This will re to /WEB-INF/pages/venue/list.jsp
		return "redirect:list";
	}

	/**
	 * Retrieves the edit page
	 *
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getEdit(@RequestParam(value="id", required=true) Integer id, Model model) {

		// Retrieve existing Venue and add to transfer
		// This is the formBackingObject
		model.addAttribute("venueAttribute", venueService.get(id));

		// This will resolve to /WEB-INF/pages/venues/edit.jsp
		return "venues/edit";
	}
	/**
	 * Edits an existing venue by delegating the processing to VenueService.
	 *
	 * @return  Redirect to list all venues
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String postEdit(@RequestParam("id") Integer id,
	                       @ModelAttribute("venueAttribute") Venue venue) {

		// The "venueAttribute" transfer has been passed to the controller from the JSP
		// We use the name "venueAttribute" because the JSP uses that name

		// We manually assign the id because we disabled it in the JSP page
		// When a field is disabled it will not be included in the ModelAttribute
		venue.setId(id);

		// Delegate to VenueRepository for editing
		venueService.edit(venue);

		// This will resolve to /WEB-INF/pages/venue/list.jsp
		return "redirect:list";
	}

	/**
	 * Deletes an existing venue by delegating the processing to VenueService.
	 *
	 * @return  Redirect to list all venues
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam(value="id")Integer id) {

		// Delete all associations first
		// creditCardService.deleteAll(venueId);
		// Call VenueRepository to do the actual deleting
		venueService.delete(id);

		// This will resolve to /WEB-INF/pages/venue/list.jsp
		return "redirect:list";
	}

}
