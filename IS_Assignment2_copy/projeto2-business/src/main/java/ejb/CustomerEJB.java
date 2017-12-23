package ejb;

import data.Car;
import data.Customer;
import dto.CarDTO;
import dto.CustomerDTO;
import dto.ListCustomerDTO;
import security.BCrypt;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.gson.Gson;

/**
 * Created by jorgearaujo on 15/11/2017.
 */
@Stateless
public class CustomerEJB implements CustomerEJBRemote{
    @PersistenceContext(name="Cars")
    EntityManager em;

    public String createCustomerAccount(String email, String Password, String firstName, String lastName)
    {
        try {
            Query newQuery = em.createQuery(" FROM Customer cost where cost.email=?1");
            newQuery.setParameter(1, email);
            Customer customer = (Customer) newQuery.getSingleResult();
            if (customer != null) {
                return "Email already in use!";
            }
        } catch (NoResultException NRE) {
            try {
                String hashedPass = hashPassword(Password);
                Customer newCustomer = new Customer(email, firstName, lastName, hashedPass);
                em.persist(newCustomer);
                return "Success";
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error creating user.");
                return "Error creating a new user!";
            }
        }
        return "Error creating a new user!";
    }



    // get costumer with email and password hash
    public CustomerDTO readCustomer(String email, String password)
    {
        try{
            Query newQuery = em.createQuery(" FROM Customer cost where cost.email=?1");
            newQuery.setParameter(1, email);
            System.out.println(email);
            Customer customerToAuth = (Customer) newQuery.getSingleResult();
            if(BCrypt.checkpw(password, customerToAuth.getPasswordHash()) == true)
            {
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO = customerToCustomerDTO(customerToAuth);
                return customerDTO;
            }


        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;

    }

    // get costumer with email and password hash
    public Customer readCustomerById(long id) {
        try {
            Query newQuery = em.createQuery(" FROM Customer cost where cost.id=?1");
            newQuery.setParameter(1, id);
            Customer customer = (Customer) newQuery.getSingleResult();
            return customer;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public CustomerDTO readCustomerDTOById(long id)
    {
        try{
            Customer customer = (Customer) em.find(Customer.class,id);
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO = customerToCustomerDTO(customer);
            return customerDTO;

        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public String hashPassword(String password)
    {
        String hashed =  BCrypt.hashpw(password,BCrypt.gensalt());
        return hashed;
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }

    public String updateCustomerAccount(String password, String newPassword, String confirmPassword,
                                         String firstName, String lastName, long uid) {

        System.out.println("updateCustomerAccount");

        String response = "";

        Customer toUpdate = (Customer) em.find(Customer.class, uid);
        if (toUpdate == null) {
            response = "Something went wrong!";
            return response;
        }
        System.out.println("Found Customer: " + toUpdate.toString());

        if(password.length() > 6 &&  BCrypt.checkpw(password,toUpdate.getPasswordHash()) == true) {
            if (newPassword.equals(confirmPassword) && newPassword.length()< 6) {
                toUpdate.setPasswordHash(hashPassword(newPassword));
                response = "Success";
            } else {
                return (response = "Invalid password");
            }
        }

        if (firstName.length() > 1 && !firstName.equals(toUpdate.getFirstName())) {
            if (firstName.length() >= 2) {
                toUpdate.setFirstName(firstName);
                System.out.println("Updated first name to: "+ firstName);
                response = "Success";
            } else {
                return (response = "Invalid First Name");
            }
        }

        if (lastName.length() > 1 && !lastName.equals(toUpdate.getLastName())) {
            if (lastName.length() >= 2) {
                toUpdate.setLastName(lastName);
                System.out.println("Updated last name to: "+ lastName);
                response = "Success";
            } else {
                return (response = "Invalid Last Name");
            }
        }
        return response;

    }

    public boolean deleteCustomer(long customerId)
    {
        try{
            Customer customerToRemove = readCustomerById(customerId);
            em.remove(customerToRemove);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;

    }

    private ArrayList<CustomerDTO> getAllCustomers() {
        System.out.println("CALLED");
        try {
            Query newQuery = em.createQuery(" FROM Customer");
            List<Customer> allCustomers = newQuery.getResultList();
            ArrayList<CustomerDTO> allCustomersDTO = new ArrayList<>();
            for (Customer customer : allCustomers) {
                System.out.println(customer.toString());
                allCustomersDTO.add(customerToCustomerDTO(customer));
            }

            return allCustomersDTO;

        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public String getAllCustomersJSON() {

        Gson gson = new Gson();
        try {
            String json = gson.toJson(getAllCustomers());
            return json;
        } catch (Exception ex) {
            return "";
        }

    }

    public String getAllCustomersXML() {
        try {
            ArrayList<CustomerDTO> allCustomers = getAllCustomers();
            System.out.println(allCustomers);
            ListCustomerDTO lc = new ListCustomerDTO();
            lc.setCustomers(allCustomers);
            System.out.println(lc.customer);

            JAXBContext jaxbContext = JAXBContext.newInstance(ListCustomerDTO.class);
            Marshaller m = jaxbContext.createMarshaller();
            StringWriter sw = new StringWriter();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            m.marshal(lc, System.out);
            m.marshal(lc, sw);

            return sw.toString();
        } catch (Exception ex) {
            System.err.println(ex);
            return "";
        }

    }

    private CarDTO carToCarDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setBrand(car.getBrand());
        carDTO.setModel(car.getModel());
        carDTO.setMileage(car.getMileage());
        carDTO.setPrice(car.getPrice());
        carDTO.setOwnerId(car.getCustomer().getId());
        carDTO.setImageUrl(car.getImageUrl());
        carDTO.setYear(car.getYear());
        carDTO.setMonth(car.getMonth());

        return carDTO;
    }

    private CustomerDTO customerToCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        ArrayList cars = new ArrayList();
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        for (Car car : customer.getCars()) {
            cars.add(carToCarDTO(car));
        }
        customerDTO.setCars(cars);

        return customerDTO;
    }
}

