package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.ContactForm;
import in.ashokit.service.ContactService;

@RestController
public class ContactRestController {

	@Autowired
	private ContactService mContactService;

	@PostMapping("/saveContact")
	public String saveContact(@RequestBody ContactForm contactForm) {
		return mContactService.saveContact(contactForm);
	}

	@GetMapping("/viewAllContacts")
	public List<ContactForm> viewAllContacts() {
		return mContactService.viewAllContacts();
	}

	@GetMapping("/editContact/{contactId}")
	public ContactForm editConatct(@PathVariable Integer contactId) {
		return mContactService.editConatct(contactId);
	}

	@GetMapping("/deleteContact/{contactId}")
	public List<ContactForm> deleteContact(@PathVariable Integer contactId) {
		return mContactService.deleteContact(contactId);
	}
}
