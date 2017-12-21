
package artifact;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the artifact package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RemoveFollower_QNAME = new QName("http://is_assignment3/", "removeFollower");
    private final static QName _AddFollower_QNAME = new QName("http://is_assignment3/", "addFollower");
    private final static QName _ListFollowers_QNAME = new QName("http://is_assignment3/", "listFollowers");
    private final static QName _ListFollowersResponse_QNAME = new QName("http://is_assignment3/", "listFollowersResponse");
    private final static QName _RemoveFollowerResponse_QNAME = new QName("http://is_assignment3/", "removeFollowerResponse");
    private final static QName _AddFollowerResponse_QNAME = new QName("http://is_assignment3/", "addFollowerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: artifact
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RemoveFollower }
     * 
     */
    public RemoveFollower createRemoveFollower() {
        return new RemoveFollower();
    }

    /**
     * Create an instance of {@link AddFollower }
     * 
     */
    public AddFollower createAddFollower() {
        return new AddFollower();
    }

    /**
     * Create an instance of {@link ListFollowers }
     * 
     */
    public ListFollowers createListFollowers() {
        return new ListFollowers();
    }

    /**
     * Create an instance of {@link ListFollowersResponse }
     * 
     */
    public ListFollowersResponse createListFollowersResponse() {
        return new ListFollowersResponse();
    }

    /**
     * Create an instance of {@link RemoveFollowerResponse }
     * 
     */
    public RemoveFollowerResponse createRemoveFollowerResponse() {
        return new RemoveFollowerResponse();
    }

    /**
     * Create an instance of {@link AddFollowerResponse }
     * 
     */
    public AddFollowerResponse createAddFollowerResponse() {
        return new AddFollowerResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveFollower }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://is_assignment3/", name = "removeFollower")
    public JAXBElement<RemoveFollower> createRemoveFollower(RemoveFollower value) {
        return new JAXBElement<RemoveFollower>(_RemoveFollower_QNAME, RemoveFollower.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFollower }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://is_assignment3/", name = "addFollower")
    public JAXBElement<AddFollower> createAddFollower(AddFollower value) {
        return new JAXBElement<AddFollower>(_AddFollower_QNAME, AddFollower.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListFollowers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://is_assignment3/", name = "listFollowers")
    public JAXBElement<ListFollowers> createListFollowers(ListFollowers value) {
        return new JAXBElement<ListFollowers>(_ListFollowers_QNAME, ListFollowers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListFollowersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://is_assignment3/", name = "listFollowersResponse")
    public JAXBElement<ListFollowersResponse> createListFollowersResponse(ListFollowersResponse value) {
        return new JAXBElement<ListFollowersResponse>(_ListFollowersResponse_QNAME, ListFollowersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveFollowerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://is_assignment3/", name = "removeFollowerResponse")
    public JAXBElement<RemoveFollowerResponse> createRemoveFollowerResponse(RemoveFollowerResponse value) {
        return new JAXBElement<RemoveFollowerResponse>(_RemoveFollowerResponse_QNAME, RemoveFollowerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFollowerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://is_assignment3/", name = "addFollowerResponse")
    public JAXBElement<AddFollowerResponse> createAddFollowerResponse(AddFollowerResponse value) {
        return new JAXBElement<AddFollowerResponse>(_AddFollowerResponse_QNAME, AddFollowerResponse.class, null, value);
    }

}
