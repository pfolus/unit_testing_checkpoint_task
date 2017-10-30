import java.util.ArrayList;
import java.util.Calendar;

public class Customer {

    String name;
    String surname;
    int birthyear;
    String gender;
    ArrayList<Sale> sales;

    public Customer() {
        this.name = "default name";
        this.surname = "default surname";
        this.birthyear = 1999;
        this.gender = "Male";
        this.sales = new ArrayList<Sale>();
    }

    public Customer(String name, String surname, int birthyear, String gender) throws IllegalArgumentException {

    }

    public void setName(String name) throws IllegalArgumentException {
        if (name.equals("")) {
            throw new IllegalArgumentException("Empty name parameter provided!");
        }
        this.name = name;
    }

    public void setSurname(String surname) throws IllegalArgumentException {
        if(surname.equals("")) {
            throw new IllegalArgumentException("Empty surname parameter provided!");
        }
        this.surname = surname;
    }

    public void setBirthyear(int birthyear) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        if (birthyear <= 1900 || birthyear > year ){
            throw new IllegalArgumentException("Wrong birthyear ( should be between 1900 and current year)");
        }
        this.birthyear = birthyear;
    }

    public void setGender(String gender) throws IllegalArgumentException {
        if (!gender.equals("Male") && !gender.equals("Female")) {
            throw new IllegalArgumentException("Incorrect gender (only Male/Female available!");
        }
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return year - birthyear;
    }
}
