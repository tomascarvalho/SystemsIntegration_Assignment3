package dto;

import javax.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDTO implements Serializable {

    @XmlAttribute
    public long id;
    @XmlAttribute
    public String email;
    public String firstName;
    public String lastName;

    @XmlElementWrapper(name="cars")
    @XmlElement(name="car")
    public List<CarDTO> cars;

    public CustomerDTO() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<CarDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarDTO> cars) {
        this.cars = cars;
    }
}
