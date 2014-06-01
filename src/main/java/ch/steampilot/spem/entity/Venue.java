
/**
 * Created by Jerome Roethlisberger on 16.05.14.
 */
package ch.steampilot.spem.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Venue entity
 *
 * Holds the data of one single venue and maps it to its corresponding mysql table using Hibernate annotations
 * For a complete reference see
 * <a href="http://docs.jboss.org/hibernate/stable/annotations/reference/en/html_single/">
 * Hibernate Annotations Community Documentations</a>
 */


@Entity
@Table(name = "venue")
public class Venue implements Serializable {
	private static final long serialVersionUID = -5527566248002296042L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "address_1")
	private String address1;

	@Column(name = "address_2")
	private String address2;

	@Column(name = "city")
	private String city;

	@Column(name = "zip_code")
	private Integer zipCode;

	@Column(name = "country")
	private String country;

	@Column(name = "keeper_id")
	private Integer keeperId;

	public Integer getId() {return id;}

	public void setId(Integer id) {this.id = id;}

	public String getTitle() {return title;}

	public void setTitle(String title) {this.title = title;}

	public String getDescription() {return description;}

	public void setDescription(String description) {this.description = description;}

	public String getAddress1() {return address1;}

	public void setAddress1(String address1) {this.address1 = address1;}

	public String getAddress2() {return address2;}

	public void setAddress2(String address2) {this.address2 = address2;}

	public String getCity() {return city;}

	public void setCity(String city) {this.city = city;}

	public Integer getZipCode() {return zipCode;}

	public void setZipCode(Integer zipCode) {this.zipCode = zipCode;}

	public String getCountry() {return country;}

	public void setCountry(String country) {this.country = country;}

	public Integer getKeeperId() {return keeperId;}

	public void setKeeperId(Integer keeperId) {this.keeperId = keeperId;}
}
