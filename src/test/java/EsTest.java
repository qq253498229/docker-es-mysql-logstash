import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class EsTest {
  private TransportClient client;

  @Before
  public void before() throws UnknownHostException {
    this.client = new PreBuiltTransportClient(Settings.EMPTY);
//    Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
//    this.client = new PreBuiltTransportClient(settings);
    this.client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
  }

  @Test
  public void test() {
    GetRequestBuilder getRequestBuilder = client.prepareGet("user", "user", "1");
    System.out.println(getRequestBuilder.toString());
    GetResponse response = getRequestBuilder.get();
    System.out.println(response);
  }
}
