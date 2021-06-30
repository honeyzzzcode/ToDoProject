import java.time.LocalDate;
import java.time.LocalDateTime;

public class Person extends Record{

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private LocalDate birthday;
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        var str = super.toString();
        return String.format("%s first name: %s ; last name %s phone %s email %s BD %s", str, firstName, lastName, phone, email, InputUtils.dateToString(birthday));
    }

    @Override
    public void askData() {
        firstName = InputUtils.askString("First name");
        lastName = InputUtils.askString("Last name");
        phone = InputUtils.askString("phone");
        email = InputUtils.askString("email");
        birthday = InputUtils.askDate("Birthday");
    }

    @Override
    public boolean contains(String substr) {
        return super.contains(substr)
                || firstName.toLowerCase().contains(substr)
                || lastName.toLowerCase().contains(substr)
                || phone.toLowerCase().contains(substr)
                || email.toLowerCase().contains(substr)
                || InputUtils.dateToString(birthday).toLowerCase().contains(substr)
                ;
    }
}
