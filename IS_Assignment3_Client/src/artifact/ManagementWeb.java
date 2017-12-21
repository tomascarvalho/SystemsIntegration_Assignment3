
package artifact;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Management_Web", targetNamespace = "http://is_assignment3/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ManagementWeb {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "removeFollower", targetNamespace = "http://is_assignment3/", className = "artifact.RemoveFollower")
    @ResponseWrapper(localName = "removeFollowerResponse", targetNamespace = "http://is_assignment3/", className = "artifact.RemoveFollowerResponse")
    public String removeFollower(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addFollower", targetNamespace = "http://is_assignment3/", className = "artifact.AddFollower")
    @ResponseWrapper(localName = "addFollowerResponse", targetNamespace = "http://is_assignment3/", className = "artifact.AddFollowerResponse")
    public String addFollower(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listFollowers", targetNamespace = "http://is_assignment3/", className = "artifact.ListFollowers")
    @ResponseWrapper(localName = "listFollowersResponse", targetNamespace = "http://is_assignment3/", className = "artifact.ListFollowersResponse")
    public String listFollowers();

}
