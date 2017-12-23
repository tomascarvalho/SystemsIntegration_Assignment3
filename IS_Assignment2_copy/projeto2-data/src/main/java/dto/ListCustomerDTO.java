package dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="ListCustomers")
public class ListCustomerDTO {
    public List<CustomerDTO> customer;

    public void setCustomers(List<CustomerDTO> customers) {
        this.customer= customers;
    }
}
