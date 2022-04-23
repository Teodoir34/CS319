
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {
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

	// set a test for creating the contactID with no args
	@Test
	void contactConstructorTest() {
		Contact contact = new Contact();
		assertAll("No Arguments Contstructor", () -> assertNotNull(contact.getContactID()),
				() -> assertNotNull(contact.getFirstName()), () -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getNumber()), () -> assertNotNull(contact.getAddress()));
	}

	// set a test for creating the contact with no ID args
	@Test
	void contactIDConstructorTest() {
		Contact contact = new Contact(contactID);
		assertAll("Contact ID Constructor Test", () -> assertEquals(contactID, contact.getContactID()),
				() -> assertNotNull(contact.getFirstName()), () -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getNumber()), () -> assertNotNull(contact.getAddress()));
	}

	// set a test for creating the contact with no ID or first name args
	@Test
	void firstNameConstructorTest() {
		Contact contact = new Contact(contactID, firstNameT);
		assertAll("firstNameConstructorTest", () -> assertEquals(contactID, contact.getContactID()),
				() -> assertEquals(firstNameT, contact.getFirstName()), () -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getNumber()), () -> assertNotNull(contact.getAddress()));
	}

	// set a test for creating the contact with no ID, first name or last name args
	@Test
	void lastNameConstructorTest() {
		Contact contact = new Contact(contactID, firstNameT, lastNameT);
		assertAll("lastNameConstructorTest", () -> assertEquals(contactID, contact.getContactID()),
				() -> assertEquals(firstNameT, contact.getFirstName()),
				() -> assertEquals(lastNameT, contact.getLastName()), () -> assertNotNull(contact.getNumber()),
				() -> assertNotNull(contact.getAddress()));
	}

	// set a test for creating the contact with no ID, first name, last name or
	// number args
	@Test
	void numberConstructorTest() {
		Contact contact = new Contact(contactID, firstNameT, lastNameT, numberT);
		assertAll("numberConstructorTest", () -> assertEquals(contactID, contact.getContactID()),
				() -> assertEquals(firstNameT, contact.getFirstName()),
				() -> assertEquals(lastNameT, contact.getLastName()), () -> assertEquals(numberT, contact.getNumber()),
				() -> assertNotNull(contact.getAddress()));
	}

	// set a test for creating the contact with all info and no args
	@Test
	void addressConstructorTest() {
		Contact contact = new Contact(contactID, firstNameT, lastNameT, numberT, addressT);
		assertAll("addressConstructorTest", () -> assertEquals(contactID, contact.getContactID()),
				() -> assertEquals(firstNameT, contact.getFirstName()),
				() -> assertEquals(lastNameT, contact.getLastName()), () -> assertEquals(numberT, contact.getNumber()),
				() -> assertEquals(addressT, contact.getAddress()));
	}

	// test contact ID rules
	// Rule: The contact object shall have a required unique contact ID string that
	// cannot be longer than 10 characters. The contact ID shall not be null and
	// shall not be updatable.
	@Test
	void setContactIDTest() {
		Contact contact = new Contact();
		contact.setContactID(contactID);
		assertAll("contactIDTest", () -> assertEquals(contactID, contact.getContactID()),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.setContactID(null)),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.setContactID(longContactID)));
	}

	// test first name rules
	// Rule: The contact object shall have a required firstName String field that
	// cannot be longer than 10 characters. The firstName field shall not be null.
	@Test
	void setFirstNameTest() {
		Contact contact = new Contact();
		contact.setFirstName(firstNameT);
		assertAll("firstNameTest", () -> assertEquals(firstNameT, contact.getFirstName()),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null)),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(longFirstName)));
	}

	// test last name rules
	// Rule: The contact object shall have a required lastName String field that
	// cannot be longer than 10 characters. The lastName field shall not be null.
	@Test
	void setLastNameTest() {
		Contact contact = new Contact();
		contact.setLastName(lastNameT);
		assertAll("lastNameTest", () -> assertEquals(lastNameT, contact.getLastName()),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null)),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.setLastName(longLastName)));
	}

	// test number rules
	// Rule: The contact object shall have a required phone String field that must
	// be exactly 10 digits. The phone field shall not be null.
	@Test
	void setNumberTest() {
		Contact contact = new Contact();
		contact.setNumber(numberT);
		assertAll("numberTest", () -> assertEquals(numberT, contact.getNumber()),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.setNumber(null)),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.setNumber(longNumber)));
	}

	// test address rules
	// Rule: The contact object shall have a required address field that must be no
	// longer than 30 characters. The address field shall not be null.
	@Test
	void setAddressTest() {
		Contact contact = new Contact();
		contact.setAddress(addressT);
		assertAll("addressTest", () -> assertEquals(addressT, contact.getAddress()),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null)),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.setAddress(longAddress)));
	}
}