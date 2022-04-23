import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	// set protected string and trade phoneNumber for number for simplicity
	protected String contactID, firstNameT, lastNameT, numberT, addressT, longContactID, longFirstName, longLastName,
			longNumber, longAddress, shortNumber;

	// create test information to use and validate
	@BeforeEach
	void setUp() {
		contactID = "1231231234";
		firstNameT = "TEODOIR";
		lastNameT = "OCEALLAIGH";
		numberT = "4321321321";
		addressT = "123 Shorter Than 30";
		longContactID = "123412341234";
		longFirstName = "Monstrosityprime";
		longLastName = "Hastakenovertheplanet";
		longNumber = "123451234512345";
		longAddress = "7485 Lives in the middle of Nowhereville, CA";
		shortNumber = "34";
	}

	// Create testing for new contact creation
	@Test
	void newContactTest() {
		ContactService service = new ContactService();

		// set test for new contact with easy using initial string and number created in
		// contact.java
		service.newContact();
		assertAll("service",
				// asserting not null for contact ID after creation
				() -> assertNotNull(service.getContactList().get(0).getContactID()),
				// asserting initial string for first name
				() -> assertEquals("TEODOIR", service.getContactList().get(0).getFirstName()),
				// asserting initial string for last name
				() -> assertEquals("TEODOIR", service.getContactList().get(0).getLastName()),
				// asserting initial integer for phone number
				() -> assertEquals("1231231234", service.getContactList().get(0).getNumber()),
				// asserting initial string for address
				() -> assertEquals("TEODOIR", service.getContactList().get(0).getAddress()));

		// set test for new contact input of first name
		service.newContact(firstNameT);
		assertAll("service",
				// asserting not null for contact ID after creation
				() -> assertNotNull(service.getContactList().get(1).getContactID()),
				// asserting entered string for first name
				() -> assertEquals(firstNameT, service.getContactList().get(1).getFirstName()),
				// asserting initial string for last name
				() -> assertEquals("TEODOIR", service.getContactList().get(1).getLastName()),
				// asserting initial integer for phone number
				() -> assertEquals("1231231234", service.getContactList().get(1).getNumber()),
				// asserting initial string for address
				() -> assertEquals("TEODOIR", service.getContactList().get(1).getAddress()));

		// set test for new contact input of first name and last name
		service.newContact(firstNameT, lastNameT);
		assertAll("service",
				// asserting not null for contact ID
				() -> assertNotNull(service.getContactList().get(2).getContactID()),
				// asserting entered string for first name
				() -> assertEquals(firstNameT, service.getContactList().get(2).getFirstName()),
				// asserting entered string for last name
				() -> assertEquals(lastNameT, service.getContactList().get(2).getLastName()),
				// asserting initial integer for phone number
				() -> assertEquals("1231231234", service.getContactList().get(2).getNumber()),
				// asserting initial string for address
				() -> assertEquals("TEODOIR", service.getContactList().get(2).getAddress()));

		// set test for new contact input of first name, last name, and phone number
		service.newContact(firstNameT, lastNameT, numberT);
		assertAll("service",
				// asserting not null for contact ID
				() -> assertNotNull(service.getContactList().get(3).getContactID()),
				// asserting entered string for first name
				() -> assertEquals(firstNameT, service.getContactList().get(3).getFirstName()),
				// asserting entered string for last name
				() -> assertEquals(lastNameT, service.getContactList().get(3).getLastName()),
				// asserting entered integer for phone number
				() -> assertEquals(numberT, service.getContactList().get(3).getNumber()),
				// asserting initial string for address
				() -> assertEquals("TEODOIR", service.getContactList().get(3).getAddress()));

		// set test for new contact input of first name, last name, phone number, and
		// address
		service.newContact(firstNameT, lastNameT, numberT, addressT);
		assertAll("service",
				// asserting not null for contact ID
				() -> assertNotNull(service.getContactList().get(4).getContactID()),
				// asserting entered string for first name
				() -> assertEquals(firstNameT, service.getContactList().get(4).getFirstName()),
				// asserting entered string for last name
				() -> assertEquals(lastNameT, service.getContactList().get(4).getLastName()),
				// asserting entered integer for phone number
				() -> assertEquals(numberT, service.getContactList().get(4).getNumber()),
				// asserting entered string for address
				() -> assertEquals(addressT, service.getContactList().get(4).getAddress()));

	}

	// set test for deleting contact ID
	@Test
	void deleteContactTest() {
		ContactService service = new ContactService();
		service.newContact();
		assertThrows(Exception.class, () -> service.deleteContact(contactID));
		assertAll(() -> service.deleteContact(service.getContactList().get(0).getContactID()));
	}

	// set test for updating first name
	@Test
	void updateFirstNameTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.setFirstName(service.getContactList().get(0).getContactID(), firstNameT);
		assertEquals(firstNameT, service.getContactList().get(0).getFirstName());
		assertThrows(IllegalArgumentException.class,
				() -> service.setFirstName(service.getContactList().get(0).getContactID(), longFirstName));
		assertThrows(IllegalArgumentException.class,
				() -> service.setFirstName(service.getContactList().get(0).getContactID(), null));
		assertThrows(Exception.class, () -> service.setFirstName(contactID, firstNameT));
	}

	// set test for updating last name
	@Test
	void updateLastNameTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.setLastName(service.getContactList().get(0).getContactID(), lastNameT);
		assertEquals(lastNameT, service.getContactList().get(0).getLastName());
		assertThrows(IllegalArgumentException.class,
				() -> service.setLastName(service.getContactList().get(0).getContactID(), longLastName));
		assertThrows(IllegalArgumentException.class,
				() -> service.setLastName(service.getContactList().get(0).getContactID(), null));
		assertThrows(Exception.class, () -> service.setLastName(contactID, lastNameT));
	}

	// set test for updating phone number
	@Test
	void updatePhoneNumberTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.setNumber(service.getContactList().get(0).getContactID(), numberT);
		assertEquals(numberT, service.getContactList().get(0).getNumber());
		assertThrows(IllegalArgumentException.class,
				() -> service.setNumber(service.getContactList().get(0).getContactID(), longNumber));
		assertThrows(IllegalArgumentException.class,
				() -> service.setNumber(service.getContactList().get(0).getContactID(), shortNumber));
		assertThrows(IllegalArgumentException.class,
				() -> service.setNumber(service.getContactList().get(0).getContactID(), "5551212"));
		assertThrows(IllegalArgumentException.class,
				() -> service.setNumber(service.getContactList().get(0).getContactID(), null));
		assertThrows(Exception.class, () -> service.setNumber(contactID, lastNameT));
	}

	// set test for updating address
	@Test
	void updateAddressTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.setAddress(service.getContactList().get(0).getContactID(), addressT);
		assertEquals(addressT, service.getContactList().get(0).getAddress());
		assertThrows(IllegalArgumentException.class,
				() -> service.setAddress(service.getContactList().get(0).getContactID(), longAddress));
		assertThrows(IllegalArgumentException.class,
				() -> service.setAddress(service.getContactList().get(0).getContactID(), null));
		assertThrows(Exception.class, () -> service.setAddress(contactID, addressT));
	}

}