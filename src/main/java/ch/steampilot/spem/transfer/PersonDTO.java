
/**
 * Created by Jerome Roethlisberger on 29.05.14.
 */

package ch.steampilot.spem.transfer;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 * Person Data Transfer Object
 *
 * Holds the consolidated data of a person with all its parent data
 * for the use as single model attribute passed by the controller to its view
 */
@Component
public class PersonDTO {
	private Integer id;
	private String title;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String address1;
	private String address2;
	private String city;
	private Integer zipCode;
	private String country;
	//private List<Event> event;


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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

}
