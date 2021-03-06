package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;

import java.util.Objects;
import java.util.Set;

import seedu.address.model.grade.Grade;
import seedu.address.model.grade.Marks;
import seedu.address.model.grade.Test;
import seedu.address.model.tag.Tag;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {
    private final Name name;
    private final Phone phone;
    private final Email email;
    private final Gender gender;
    private final Nationality nationality;

    // Data fields
    private final Address address;
    private final Set<Tag> tags = new HashSet<>();
    private final Set<Test> testList = new HashSet<>();
    private Grade grade = new Grade("Undefined");
    private Marks marks = new Marks("0");

    /**
     * Every field must be present and not null.
     */

    public Person(Name name, Gender gender, Nationality nationality, Phone phone,
                  Email email, Address address, Set<Tag> tags, Set<Test> testList) {

        requireAllNonNull(name, gender, nationality, phone, email, address, tags, testList);

        this.name = name;
        this.gender = gender;
        this.nationality = nationality;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
        this.testList.addAll(testList);
    }
    public Grade getGrade() {
        return grade;
    }

    public Marks getMarks() {
        return marks;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void setMarks(Marks marks) {
        this.marks = marks;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public Gender getGender() {
        return gender;
    }


    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    public Set<Test> getTests() {
        return Collections.unmodifiableSet(testList);
    }


    /**
     * Returns true if both persons of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName())
                && (otherPerson.getPhone().equals(getPhone()) || otherPerson.getEmail().equals(getEmail()));
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return otherPerson.getName().equals(getName())
                && otherPerson.getPhone().equals(getPhone())
                && otherPerson.getGender().equals(getGender())
                && otherPerson.getNationality().equals(getNationality())
                && otherPerson.getEmail().equals(getEmail())
                && otherPerson.getAddress().equals(getAddress())
                && otherPerson.getTags().equals(getTags())
                && otherPerson.getTests().equals(getTests());

    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, gender, nationality, phone, email, address, tags, testList);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Gender: ")
                .append(getGender())
                .append(" Nationality: ")
                .append(getNationality())
                .append(" Phone: ")
                .append(getPhone())
                .append(" Email: ")
                .append(getEmail())
                .append(" Address: ")
                .append(getAddress())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        builder.append(" Tests: ");
        getTests().forEach(builder::append);
        return builder.toString();
    }

}
