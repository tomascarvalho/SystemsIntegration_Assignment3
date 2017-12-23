package dto;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Cars")
public class CarDTO implements Serializable {
    @XmlAttribute
    public long id;
    @XmlAttribute
    public String brand;
    @XmlAttribute
    public String model;
    @XmlAttribute
    public String month;
    @XmlAttribute
    public String imageUrl;
    @XmlAttribute
    public int year;
    @XmlAttribute
    public int price;
    @XmlAttribute
    public int mileage;
    @XmlAttribute
    public long ownerId;
    @XmlElementWrapper(name="related_cars")
    @XmlElement(name="related_car")
    public List<CarDTO> relatedCars;


    public CarDTO() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMonth() {
        return month;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }


    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public List<CarDTO> getRelatedCars() {
        return relatedCars;
    }

    public void setRelatedCars(List<CarDTO> relatedCars) {
        this.relatedCars = relatedCars;
    }
}
