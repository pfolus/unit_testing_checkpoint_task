import java.util.ArrayList;
import java.util.Calendar;

public class Customer {

    private String name;
    private String surname;
    private int birthyear;
    private String gender;
    private ArrayList<Sale> sales;

    public Customer() {
        this.name = "default name";
        this.surname = "default surname";
        this.birthyear = 1999;
        this.gender = "Male";
        this.sales = new ArrayList<Sale>();
    }

    public Customer(String name, String surname, int birthyear, String gender) throws IllegalArgumentException {
        setName(name);
        setSurname(surname);
        setBirthyear(birthyear);
        setGender(gender);
        this.sales = new ArrayList<Sale>();
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

    public void setBirthyear(int birthyear) throws IllegalArgumentException {
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

    public void addSale() {
        this.sales.add(new Sale());
    }

    public int getSalesCount() {
        int count = 0;
        for (Sale item : this.sales) {
            count++;
        }
        return count;
    }
}
