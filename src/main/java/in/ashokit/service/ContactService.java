package in.ashokit.service;

import java.util.List;

import in.ashokit.bindings.ContactForm;

public interface ContactService {

	public String saveContact(ContactForm contactForm);

	public List<ContactForm> viewAllContacts();

	public ContactForm editConatct(Integer contactId);

	public List<ContactForm> deleteContact(Integer contactId);
}
