package crawler;


import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import data.Car;

/**
 * Created by jorgearaujo on 26/09/2017.
 */


public class TopicSender {
    private ConnectionFactory cf;
    private Topic tpc;


    public TopicSender() throws NamingException {
        this.cf = InitialContext.doLookup("jms/RemoteConnectionFactory");


        //lookup for Topic
        this.tpc = (Topic) InitialContext.doLookup("jms/topic/TopicExample");

    }

    public void sendToTopic(Car car) throws NamingException {

        try (JMSContext cntx = this.cf.createContext("joao", "br1o+sa*")) {

            //topic producer
            JMSProducer prod = cntx.createProducer();
            //send message to topic
            ObjectMessage objectMessage = cntx.createObjectMessage(car);
            prod.send(tpc,objectMessage);
        }
    }

}