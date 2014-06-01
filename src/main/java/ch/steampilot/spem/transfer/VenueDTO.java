/**
 * Created by Jerome Roethlisberger on 29.05.14.
 */
package ch.steampilot.spem.transfer;

import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Venue Data Transfer Object
 *
 * Holds the consolidated data of a person with all its parent data
 * for the use as single model attribute passed by the controller to its view
 */
@Component
public class VenueDTO {
	private Integer id;
	private String title;
	private String description;
	private String address1;
	private String address2;
	private String city;
	private Integer zipCode;
	private String country;
	private Integer keeperId;

	//consolidates data from the corresponding person table
	private String keeperFirstName;
	private String keeperLastName;
	private String keeperEmail;
	private String keeperPhone;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getKeeperId() {
		return keeperId;
	}

	public void  setKeeperId(Integer keeperId) {
		this.keeperId = keeperId;
	}

	/**
	 * gets the first name of the venue contact person
	 * @return the first Name of the person in charge or a reminder that this person is not yet selected
	 */
	public String getKeeperFirstName() {
		if (keeperFirstName == null) {
			return "no Person selected";
		} else {
		return keeperFirstName;
		}
	}

	public void setKeeperFirstName(String keeperFirstName) { this.keeperFirstName = keeperFirstName; }

	/**
	 *  gets the last name of the venue contact person
	 * @return the last name of the person in charge or an empty string
	 */
	public String getKeeperLastName() {
		if (keeperLastName == null) {
			return " ";
		} else {
		return keeperLastName;
		}
	}

	public void setKeeperLastName(String keeperLastName) { this.keeperLastName = keeperLastName; }

	/**
	 * gets the email of the venue contact person
	 * @return the email of the person in charge or a reminder that the email is not yet specified
	 */
	public String getKeeperEmail() {
		if (keeperEmail == null) {
			return "No email specified";
		} else {
		return keeperEmail;
		}
	}

	public void setKeeperEmail(String keeperEmail) { this.keeperEmail = keeperEmail; }

	/**
	 * gets the phone number of the venue contact person
	 * @return the phone number of the person in charge or a reminder that the phone number is not yet specified
	 */
	public String getKeeperPhone() {
		if (keeperPhone == null) {
			return "no phone specified";
		} else {
			return keeperPhone;
		}
	}

	public void setKeeperPhone(String keeperPhone) { this.keeperPhone = keeperPhone; }

}
