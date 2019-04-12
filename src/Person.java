import java.util.Scanner;

/* Person.java - Lightly-modified version of Person class from textbook
 * Author:     Textbook
 * Module:     8
 * Project:    Homework Project 3
 * Description: This class is used throughout the textbook for several demonstrations.
 *
 * Most notable change is that all commas are removed from dates as entered.
 *
 * Class for a person with a name and dates for birth and death.
 * Class invariant: A Person always has a date of birth, and if the Person
 * has a date of death, then the date of death is equal to or later than the
 * date of birth.
 */
public class Person implements Cloneable {

    private String name ;
    private Date born ;
    private Date died ; //null indicates still alive.

    // Full constructor
    public Person(String initialName, String birthMonth, int birthDay, int birthYear,
                  String deathMonth, int deathDay, int deathYear ) {
        // Temporary date Objects used to check consistency
        Date birthDate = new Date(birthMonth, birthDay, birthYear);
        Date deathDate = new Date(deathMonth, deathDay, deathYear);
        // Check that birthDate precedes deathDate
        if (consistent(birthDate, deathDate))         {
            name = initialName ;
            born = birthDate ;
            died = deathDate ;
         } else {
             System.out.println("Inconsistent dates. Aborting.") ;
             System.exit(0) ;
         }
    }

    // Constructor for a Person still alive
    public Person(String initialName, String birthMonth, int birthDay, int birthYear) {
        name = initialName ;
        // No need to check if consistent because born will never be null
        born = new Date(birthMonth, birthDay, birthYear);
        died = null;
    }


    // Copy constructor
    public Person(Person original) {

        if (original == null) {
            System.out.println("Fatal error.") ;
            System.exit(0) ;
        }

        name = original.name ;
        born = new Date(original.born) ;

        if (original.died == null)
            died = null ;
        else
            died = new Date(original.died) ;
    }

    // Private Setter for all instance variables of this Person using Date objects
    private void set(String newName, Date birthDate, Date deathDate) {

        if (consistent(birthDate, deathDate)) {
            name = newName ;
            born = new Date(birthDate) ;
            if (deathDate == null)
                died = null ;
            else
                died = new Date(deathDate) ;
        } else {
            System.out.println("Inconsistent dates. Aborting.") ;
            System.exit(0) ;
        }
    }

    public String toString( ) {
        if (died == null) {
            return (name + ",  Born: " + born) ;
        }
        return (name + ",  Born: " + born + "-" + died) ;
    }

    public boolean equals(Object anObject) {
        if (anObject == null || getClass() != anObject.getClass()) {
            return false ;
        }
        Person otherPerson = (Person) anObject ;
        return (name.equals(otherPerson.name) &&
                born.equals(otherPerson.born) &&
                datesMatch(died, otherPerson.died) ) ;
    }

    // To match date1 and date2, they must either be the same date or both be null.
    private static boolean datesMatch(Date date1, Date date2) {
        if (date1 == null)
            return (date2 == null) ;
        else if (date2 == null) //&& date1 != null
            return false ;
        else // both dates are not null.
            return(date1.equals(date2)) ;
    }

    /**
    Precondition: newDate is a consistent date of birth.
    Postcondition: Date of birth of the calling object is newDate.
    */
    public void setBirthDate(String birthMonth, int birthDay, int birthYear) {
        Date newDate = new Date(birthMonth, birthDay, birthYear);
        if (consistent(newDate, died))
            born = new Date(newDate) ;
        else {
             System.out.println("Inconsistent dates. Aborting.") ;
             System.exit(0) ;
        }
    }

    /**
    Precondition: newDate is a consistent date of death.
    Postcondition: Date of death of the calling object is newDate.
    */
    public void setDeathDate(String deathMonth, int deathDay, int deathYear) {
        Date newDate = new Date(deathMonth, deathDay, deathYear);
        if (!consistent(born, newDate)) {
            System.out.println("Inconsistent dates. Aborting.") ;
            System.exit(0) ;
        }
        died = new Date(newDate) ;
    }

    public void setName(String newName) {
        name = newName ;
    }

    /**
    Precondition: The date of birth has been set, and changing the year
    part of the date of birth will give a consistent date of birth.
    Postcondition: The year of birth is (changed to) newYear.
    */
    public void setBirthYear(int newYear) {
        if (born == null) { //Precondition is violated
             System.out.println("Fata ; Error. Aborting.") ;
             System.exit(0) ;
        }
        born.setYear(newYear) ;
        if (!consistent(born, died)) {
             System.out.println("Inconsistent dates. Aborting.") ;
             System.exit(0) ;
        }
    }

    /**
    Precondition: The date of death has been set, and changing the year
    part of the date of death will give a consistent date of death.
    Postcondition: The year of death is (changed to) newYear.
    */
    public void setDeathYear(int newYear) {
        if (died == null) { //Precondition is violated
             System.out.println("Fata ; Error. Aborting.") ;
             System.exit(0) ;
        }
        died.setYear(newYear) ;
        if (!consistent(born, died)) {
             System.out.println("Inconsistent dates. Aborting.") ;
             System.exit(0) ;
        }
    }

    public String getName() {
        return name ;
    }

    public Date getBirthDate( ) {
        return new Date(born) ;
    }

    public Date getDeathDate( ) {
        if (died == null)
            return null ;
        else
            return new Date(died) ;
     }

    /**
    To be consistent, birthDate must not be null. If there is no date of
    death (deathDate == null), that is consistent with any birthDate.
    Otherwise, the birthDate must come before or be equal to the deathDate.
    */

    private static boolean consistent(Date birthDate, Date deathDate) {
        if (birthDate == null)
            return false ;
        else if (deathDate == null)
            return true ;
        else
            return (birthDate.precedes(deathDate)
                      || birthDate.equals(deathDate )) ;
    }

    // Implement clone method, using set() method to make a deep copy of Date Objects
    public Object clone( ) {

        Person copy;
        try {
            copy = (Person) super.clone( );
            copy.set(name, born, died);
        }
        catch(CloneNotSupportedException e) {         //This should not happen.
            return null; //To keep compiler happy.
        }
        return copy;
    }


    private class Date{

        private String month;
        private int day;
        private int year; //a four digit number.

        public Date( ) {
            month = "January";
            day = 1;
            year = 1000;
        }

        public Date(int monthInt, int day, int year) {
            setDate(monthInt, day, year);
        }

        public Date(String monthString, int day, int year) {
            setDate(monthString, day, year);
        }

        public Date(int year) {
            setDate(1, 1, year);
        }

        public Date(Date aDate) {
            if (aDate == null) {          //Not a real date.
                System.out.println("Fatal Error.");
                System.exit(0);
            }

            month = aDate.month;
            day = aDate.day;
            year = aDate.year;
        }

        public void setDate(int monthInt, int day, int year) {
            if (dateOK(monthInt, day, year)) {
                this.month = monthString(monthInt);
                this.day = day;
                this.year = year;
            } else {
                System.out.println("Fatal Error");
                System.exit(0);
            }
        }

        public void setDate(String monthString, int day, int year) {
            if (dateOK(monthString, day, year)) {
                this.month = monthString;
                this.day = day;
                this.year = year;
            } else {
                System.out.println("Fatal Error");
                System.exit(0);
            }
        }

        public void setDate(int year) {
            setDate(1, 1, year);
        }

        public void setYear(int year) {
            if ( (year < 1000) || (year > 9999) ) {
                System.out.println("Fatal Error");
                System.exit(0);
            }
            else
                this.year = year;
        }
        public void setMonth(int monthNumber) {
            if ((monthNumber <= 0) || (monthNumber > 12)) {
                System.out.println("Fatal Error");
                System.exit(0);
            } else {
                month = monthString(monthNumber);
            }
        }

        public void setDay(int day) {
            if ((day <= 0) || (day > 31)) {
                System.out.println("Fatal Error");
                System.exit(0);
            } else {
                this.day = day;
            }
        }

        public int getMonth( ) {
            if (month.equals("January"))
                return 1;
            else if (month.equals("February"))
                return 2;
            else if (month.equalsIgnoreCase("March"))
                return 3;
            else if (month.equalsIgnoreCase("April"))
                return 4;
            else if (month.equalsIgnoreCase("May"))
                return 5;
            else if (month.equals("June"))
                return 6;
            else if (month.equalsIgnoreCase("July"))
                return 7;
            else if (month.equalsIgnoreCase("August"))
                return 8;
            else if (month.equalsIgnoreCase("September"))
                return 9;
            else if (month.equalsIgnoreCase("October"))
                return 10;
            else if (month.equals("November"))
                return 11;
            else if (month.equals("December"))
                return 12;
            else {
                System.out.println("Fatal Error");
                System.exit(0);
                return 0; //Needed to keep the compiler happy
            }
        }

        public int getDay( ) {
            return day;
        }

        public int getYear( ) {
            return year;
        }

        public String toString( ) {
            return (month + " " + day + ", " + year);
        }

        public boolean equals(Date otherDate) {
            if (otherDate == null)
                return false;
            else
                return ( (month.equals(otherDate.month)) &&
                        (day == otherDate.day) && (year == otherDate.year) );
        }

        public boolean precedes(Date otherDate) {
            return ( (year < otherDate.year) ||
                    (year == otherDate.year && getMonth( ) < otherDate.getMonth( )) ||
                    (year == otherDate.year && month.equals(otherDate.month)
                            && day < otherDate.day) );
        }

        public void readInput( ) {

            boolean tryAgain = true;
            Scanner keyboard = new Scanner(System.in);
            while (tryAgain) {
                System.out.println("Enter month, day, and year.");
                System.out.println("Do not use a comma.");
                String monthInput = keyboard.next( );
                int dayInput = keyboard.nextInt( );
                int yearInput = keyboard.nextInt( );
                if (dateOK(monthInput, dayInput, yearInput) ) {
                    setDate(monthInput, dayInput, yearInput);
                    tryAgain = false;
                } else
                    System.out.println("Illegal date. Reenter input.");
            }
        }

        private boolean dateOK(int monthInt, int dayInt, int yearInt) {
            return ( (monthInt >= 1) && (monthInt <= 12) &&
                    (dayInt >= 1) && (dayInt <= 31) &&
                    (yearInt >= 1000) && (yearInt <= 9999) );
        }

        private boolean dateOK(String monthString, int dayInt, int yearInt) {
            return ( monthOK(monthString) &&
                    (dayInt >= 1) && (dayInt <= 31) &&
                    (yearInt >= 1000) && (yearInt <= 9999) );
        }

        private boolean monthOK(String month) {
            return (month.equals("January") || month.equals("February") ||
                    month.equals("March") || month.equals("April") ||
                    month.equals("May") || month.equals("June") ||
                    month.equals("July") || month.equals("August") ||
                    month.equals("September") || month.equals("October") ||
                    month.equals("November") || month.equals("December") );
        }

        private String monthString(int monthNumber) {
            switch (monthNumber) {
                case 1:
                    return "January";
                case 2:
                    return "February";
                case 3:
                    return "March";
                case 4:
                    return "April";
                case 5:
                    return "May";
                case 6:
                    return "June";
                case 7:
                    return "July";
                case 8:
                    return "August";
                case 9:
                    return "September";
                case 10:
                    return "October";
                case 11:
                    return "November";
                case 12:
                    return "December";
                default:
                    System.out.println("Fatal Error");
                    System.exit(0);
                    return "Error"; //to keep the compiler happy
            }
        }

        public Object clone( ) {
            try {
                return super.clone( );//Invocation of
                //clone in the base class Object
            }
            catch(CloneNotSupportedException e) {         //This should not happen.
                return null; //To keep compiler happy.
            }
        }
    }
}