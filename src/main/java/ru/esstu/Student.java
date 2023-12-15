package ru.esstu;

import java.util.Objects;
public class Student{
    private String id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String group;

    public Student(String id, String firstName, String lastName, String middleName, String group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(middleName, student.middleName) && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, middleName, group);
    }
}
