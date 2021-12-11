package in.ashokit.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name = "CONATCT_DETAILS")
@Data
public class ContactEntity {

	@Id
	@GeneratedValue
	@Column(name = "CONATCT_ID")
	private Integer contactId;

	@Column(name = "CONATCT_NAME")
	private String contactName;

	@Column(name = "CONATCT_EMAIL")
	private String contactEmail;

	@Column(name = "CONATCT_NUMBER")
	private Long contactNumber;

	@Column(name = "ACTIVE_SWITCH")
	private String activeSwitch;

	@Column(name = "CREATED_DATE")
	@CreationTimestamp
	private LocalDate createdDate;

	@Column(name = "UPDATED_DATE")
	@CreationTimestamp
	private LocalDate updatedDate;

}
