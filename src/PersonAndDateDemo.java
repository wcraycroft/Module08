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

        // Test if clone is equals
        System.out.println("After setters...");
        System.out.println(testPerson.toString());
        System.out.println(clone.toString());
        System.out.println();

        // Test if clone is equals
        System.out.println("After setters, are the clones equals? " + testPerson.equals(clone));
    }
}
