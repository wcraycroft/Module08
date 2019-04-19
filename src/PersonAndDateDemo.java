/* LabDemo.java
 * Author:  William Craycroft
 * Module:  8
 * Project: Homework 8 - Project 2
 * Problem Statement: This class demonstrates the functionality of the Person class, its Date inner class and their
 *      Cloneable interface.
 *
 * Algorithm / Plan:
 *      1. Create a Person object using its full parameterized constructor
 *      2. Set the birth and death dates
 *      3. Clone the Person object
 *      4. Test if clone is equals to the original Person (should return true)
 *      5. Set the birth and death dates of the clone object, print both objects' toString
 *      6. Test if clone is equals to the original Person (should return false)
 */

public class PersonAndDateDemo {

    public static void main (String[] args) {

        // Declarations
        String name = "Thomas Edison", birthMonth = "August", deathMonth = "November";
        int birthDay = 19, birthYear = 1800, deathDay = 18, deathYear = 1847;

        // Instantiate Person object using Full Constructor
        Person testPerson = new Person(name, birthMonth, birthDay, birthYear, deathMonth, deathDay, deathYear);

        // Test setters
        testPerson.setBirthDate("February", 11, 1847);
        testPerson.setDeathDate("October", 18, 1931);

        // Clone objects
        Person clone = (Person) testPerson.clone();

        // Test if clone is equals
        System.out.println("Before setters, are the clones equals? " + testPerson.equals(clone));
        System.out.println();

        // Change clone data back to original data
        clone.setBirthDate(birthMonth, birthDay, birthYear);
        clone.setDeathDate(deathMonth, deathDay, deathYear);

        // Display both Person objects' toString()
        System.out.println("After setters...");
        System.out.println(testPerson.toString());
        System.out.println(clone.toString());
        System.out.println();

        // Test if clone is equals
        System.out.println("After setters, are the clones equals? " + testPerson.equals(clone));
    }
}
