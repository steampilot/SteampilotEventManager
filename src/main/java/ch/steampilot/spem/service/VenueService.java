/**
 * Created by Jerome Roethlisberger on 24.05.14.
 */
package ch.steampilot.spem.service;

import ch.steampilot.spem.entity.Person;
import ch.steampilot.spem.entity.Venue;
import ch.steampilot.spem.repository.VenueRepository;
import ch.steampilot.spem.transfer.VenueDTO;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("venueService")
public class VenueService {
	@Autowired
	@Resource(name = "venueRepository")
	private VenueRepository venueRepository;

	@Autowired
	@Resource(name = "personService")
	private PersonService personService;

	/**
	 * Delegates to VenueRepository to get all venues
	 * @return the retrieved list of all venues
	 */
	public List getAll(){
		List<Venue> venueList = venueRepository.getAll();
		return venueList;
	}

	/**
	 * Delegates to VenueRepository to get one single venue by id
	 * @param id the identifying id of a single venue
	 * @return the retrieved single venue
	 */
	public Venue get(Integer id) {
		Venue venue = venueRepository.get(id);
		return venue;
	}

	/**
	 * Delegates to VenueRepository to create a new empty venue
	 * @return the new created empty venue
	 */
	public Venue create() {
		return venueRepository.create();
	}

	/**
	 * Delegates to venueRepository to save the created venue
	 * @param venue the venue to process
	 */
	public void add(Venue venue){
		venueRepository.add(venue);
	}

	/**
	 * Delegates to VenueRepository to save the edited venue
	 * @param venue the venue to process
	 */
	public void edit(Venue venue) {
		venueRepository.edit(venue);
	}

	/**
	 * Delegates to VenueRepository to delete an existing venue identified by its id
	 * @param id the identifying id of a single venue
	 */
	public void delete(Integer id) {
		venueRepository.delete(id);
	}
	/**
	 * Delegates to Venue Repository to uncouple all associated person when deleting a person
	 * @param keeperId the identifying id of the person in charge
	 */
	public void decoupleKeeper(Integer keeperId) {
		venueRepository.decoupleKeeper(keeperId);
	}

	/**
	 * Creates a Venue Data Transfer Object to consolidate from one to many associations
	 * @return the list of all created venueDTOs
	 */
	public List<VenueDTO> getDTOs(){
		List<VenueDTO> venueDTOs = new ArrayList<VenueDTO>();
		List<Venue> venues = venueRepository.getAll();
		for (Venue venue: venues) {
			// Create new data transfer object
			VenueDTO dto = new VenueDTO();



			dto.setId(venue.getId());
			dto.setTitle(venue.getTitle());
			dto.setDescription(venue.getDescription());
			dto.setAddress1(venue.getAddress1());
			dto.setAddress2(venue.getAddress2());
			dto.setZipCode(venue.getZipCode());
			dto.setCity(venue.getCity());
			dto.setCountry(venue.getCountry());
			dto.setKeeperId(venue.getKeeperId());

			if (venue.getKeeperId() != null){
				Person person = personService.getOne(venue.getKeeperId());
				dto.setKeeperFirstName(person.getFirstName());
				dto.setKeeperLastName(person.getLastName());
				dto.setKeeperEmail(person.getEmail());
				dto.setKeeperPhone(person.getPhone());
			}

			// Add to model list
			venueDTOs.add(dto);
		}

		return venueDTOs;
	}
}
