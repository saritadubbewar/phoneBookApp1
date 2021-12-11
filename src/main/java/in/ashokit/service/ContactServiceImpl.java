package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.ContactForm;
import in.ashokit.entities.ContactEntity;
import in.ashokit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository mContactRepository;

	@Override
	public String saveContact(ContactForm contactForm) {
		ContactEntity contactEntity = new ContactEntity();
		BeanUtils.copyProperties(contactForm, contactEntity);
		contactEntity.setActiveSwitch("Y");
		
		contactEntity = mContactRepository.save(contactEntity);

		if (contactEntity != null) {
			return "Success";
		}

		return "Failure";
	}

	@Override
	public List<ContactForm> viewAllContacts() {
		List<ContactForm> contactForms = new ArrayList<>();
		
		List<ContactEntity> contactEntities = mContactRepository.findAll();

		for (ContactEntity entity : contactEntities) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			contactForms.add(form);
		}

		return contactForms;
	}

	@Override
	public ContactForm editConatct(Integer contactId) {
		Optional<ContactEntity> contact = mContactRepository.findById(contactId);

		if (contact.isPresent()) {
			ContactEntity contactEntity = contact.get();
			ContactForm contactForm = new ContactForm();
			BeanUtils.copyProperties(contactEntity, contactForm);

			return contactForm;
		}

		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		mContactRepository.deleteById(contactId);

		return viewAllContacts();
	}

}
