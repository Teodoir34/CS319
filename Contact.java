
class Contact {

	// create any necessary variables in private class for access restrictions

	// Rule for contact ID: The contact object shall have a required unique contact
	// ID string that cannot be longer than 10 characters. The contact ID shall not
	// be null and shall not be updatable.
	private String contactID;
	// Rule for first name: The contact object shall have a required firstName
	// String field that cannot be longer than 10 characters. The firstName field
	// shall not be null.
	private String firstName;
	// Rule for last name: The contact object shall have a required lastName String
	// field that cannot be longer than 10 characters. The lastName field shall not
	// be null.
	private String lastName;
	// Rule for phone number:The contact object shall have a required phone String
	// field that must be exactly 10 digits. The phone field shall not be null.
	private String phoneNumber;
	// Rule for address: The contact object shall have a required address field that
	// must be no longer than 30 characters. The address field shall not be null.
	private String address;
	// Initialize starting string and integer - using my name for shenanigans
	private static final String INITIAL_STRING = "TEODOIR";
	private static final String INITIAL_INT = "1231231234";

	// Initial constructor set up
	Contact() {
		this.contactID = INITIAL_INT;
		this.firstName = INITIAL_STRING;
		this.lastName = INITIAL_STRING;
		this.phoneNumber = INITIAL_INT;
		this.address = INITIAL_STRING;
	}

	// Overload the constructors to assist with argument reading
	// sourcing: https://www.geeksforgeeks.org/constructor-overloading-java/

	// overload construct for contact id
	Contact(String contactID) {
		setContactID(contactID);
		this.firstName = INITIAL_STRING;
		this.lastName = INITIAL_STRING;
		this.phoneNumber = INITIAL_INT;
		this.address = INITIAL_STRING;
	}

	// overload construct for first name
	Contact(String contactID, String firstName) {
		setContactID(contactID);
		setFirstName(firstName);
		this.lastName = INITIAL_STRING;
		this.phoneNumber = INITIAL_INT;
		this.address = INITIAL_STRING;
	}

	// overload construct for last name
	Contact(String contactID, String firstName, String lastName) {
		setContactID(contactID);
		setFirstName(firstName);
		setLastName(lastName);
		this.phoneNumber = INITIAL_INT;
		this.address = INITIAL_STRING;
	}

	// overload construct for phone number
	Contact(String contactID, String firstName, String lastName, String phoneNumber) {
		setContactID(contactID);
		setFirstName(firstName);
		setLastName(lastName);
		setNumber(phoneNumber);
		this.address = INITIAL_STRING;
	}

	// overload construct for address
	Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
		setFirstName(firstName);
		setLastName(lastName);
		setNumber(phoneNumber);
		setAddress(address);
		setContactID(contactID);
	}

	// get and return contact id
	protected final String getContactID() {
		return contactID;
	}

	// get and return first name
	protected final String getFirstName() {
		return firstName;
	}

	// get and return last name
	protected final String getLastName() {
		return lastName;
	}

	// get and return phone number
	protected final String getNumber() {
		return phoneNumber;
	}

	// get and return address
	protected final String getAddress() {
		return address;
	}

	// set contact id attribute or throw exception based on rules
	public void setContactID(String contactID) {
		// thrown exception if null
		if (contactID == null) {
			throw new IllegalArgumentException("ContactID cannot be null.");
		}
		// thrown exception if greater than 10 characters
		else if (contactID.length() > 10) {
			throw new IllegalArgumentException("ContactID must be shorter than 10 digits.");
		}
		// set contact ID
		else {
			this.contactID = contactID;
		}
	}

	// set first name for attribute or throw exception based on rules
	protected void setFirstName(String firstName) {
		// thrown exception if null
		if (firstName == null) {
			throw new IllegalArgumentException("Field cannot be empty.");
		}
		// thrown exception if greater than 10 characters
		else if (firstName.length() > 10) {
			throw new IllegalArgumentException("Name must be less than 10 characters.");
		}
		// set first name
		else {
			this.firstName = firstName;
		}
	}

	// set last name for attribute or throw exception based on rules
	protected void setLastName(String lastName) {
		// thrown exception if null
		if (lastName == null) {
			throw new IllegalArgumentException("Field cannot be empty.");
		}
		// thrown exception if greater than 10 characters
		else if (lastName.length() > 10) {
			throw new IllegalArgumentException("Name must be less than 10 characters.");
		}
		// set last name
		else {
			this.lastName = lastName;
		}
	}

	// set phone number for attribute or throw exception based on rules
	protected void setNumber(String phoneNumber) {
		String regexTest = "[0-9]+"; // https://www.geeksforgeeks.org/how-to-check-if-string-contains-only-digits-in-java/
		// thrown exception if null
		if (phoneNumber == null) {
			throw new IllegalArgumentException("Number cannot be null.");
		}
		// thrown exception if not exactly 10 numbers
		else if (!(phoneNumber.length() == 10)) {
			throw new IllegalArgumentException("Number must have a length of 10.");
		}
		// thrown exception if non-numbers input
		else if (!(phoneNumber.matches(regexTest))) {
			throw new IllegalArgumentException("Only numbers are allowed for phone numbers.");
		}
		// set phone number
		else {
			this.phoneNumber = phoneNumber;
		}
	}

	// set address for attribute or throw exception based on rules
	public void setAddress(String address) {
		// thrown exception if null
		if (address == null) {
			throw new IllegalArgumentException("Address field may not be empty.");
		}
		// thrown exception if greater than 30 characters
		else if (address.length() > 30) {
			throw new IllegalArgumentException("Address max length is 30.");
		}
		// set address
		else {
			this.address = address;
		}
	}
}