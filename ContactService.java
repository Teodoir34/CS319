import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {

	// set string for unique contact id since unchangeable
	private String uniqueContactID;

	// create unique contact id
	private String newUniqueContactID() {
		uniqueContactID = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
		return uniqueContactID;
	}

	// create the contact list in an array
	private List<Contact> contactList = new ArrayList<>();

	// establish for new contacts
	public void newContact() {
		Contact contact = new Contact(newUniqueContactID());
		contactList.add(contact);
	}

	// input for new contact first name
	public void newContact(String firstName) {
		Contact contact = new Contact(newUniqueContactID(), firstName);
		contactList.add(contact);
	}

	// input for new contact first and last name
	public void newContact(String firstName, String lastName) {
		Contact contact = new Contact(newUniqueContactID(), firstName, lastName);
		contactList.add(contact);
	}

	// input for new contact first name, last name, and phone number
	public void newContact(String firstName, String lastName, String phoneNumber) {
		Contact contact = new Contact(newUniqueContactID(), firstName, lastName, phoneNumber);
		contactList.add(contact);
	}

	// input for new contact first name, last name, phone number and address
	public void newContact(String firstName, String lastName, String phoneNumber, String address) {
		Contact contact = new Contact(newUniqueContactID(), firstName, lastName, phoneNumber, address);
		contactList.add(contact);
	}

	// create ability to delete contact
	public void deleteContact(String ID) throws Exception {
		contactList.remove(searchContacts(ID));
	}

	// create exception throw for first name
	public void setFirstName(String ID, String firstName) throws Exception {
		searchContacts(ID).setFirstName(firstName);
	}

	// create exception throw for last name
	public void setLastName(String ID, String lastName) throws Exception {
		searchContacts(ID).setLastName(lastName);
	}

	// create exception throw for phone number
	public void setNumber(String ID, String phoneNumber) throws Exception {
		searchContacts(ID).setNumber(phoneNumber);
	}

	// create exception throw for address
	public void setAddress(String ID, String address) throws Exception {
		searchContacts(ID).setAddress(address);
	}

	// set ability to get the list
	protected List<Contact> getContactList() {
		return contactList;
	}

	// set error throw for no contact id found
	private Contact searchContacts(String ID) throws Exception {
		int i = 0;
		while (i < contactList.size()) {
			if (ID.equals(contactList.get(i).getContactID())) {
				return contactList.get(i);
			}
			i++;
		}
		throw new Exception("Not found.");
	}
}