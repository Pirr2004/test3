import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FileTransfer {
    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("file:data/inbox??delete=true")
                        .log(LoggingLevel.INFO, "Processing file ${file:name}")
                        .to("file:data/outbox");
            }
        });
        context.start();
        Thread.sleep(5000);
        context.stop();
    }
}
