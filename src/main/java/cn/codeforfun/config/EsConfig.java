package cn.codeforfun.config;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@EnableElasticsearchRepositories(basePackages = "cn.codeforfun.esdao")
@EnableConfigurationProperties(ElasticsearchProperties.class)
public class EsConfig {
  private final ElasticsearchProperties properties;
//  @Resource
//  private TransportClient transportClient;
//

  /**
   * 将配置文件中的参数注入到field中
   */
  public EsConfig(ElasticsearchProperties properties) {
    this.properties = properties;
  }

  //
//  @Bean
//  public TransportClient transportClient() throws UnknownHostException {
//    TransportClient client;
//    String clusterName = properties.getClusterName();
//    String[] split = properties.getClusterNodes() != null ? properties.getClusterNodes().split(":") : null;
//    String host = split != null && split[0] != null ? split[0] : "localhost";
//    Integer port = split != null && split[0] != null ? Integer.parseInt(split[1]) : 9300;
//    if (clusterName != null && !clusterName.trim().isEmpty()) {
//      Settings settings = Settings.builder().put("cluster.name", properties.getClusterName()).build();
//      client = new PreBuiltTransportClient(settings);
//    } else {
//      client = new PreBuiltTransportClient(Settings.EMPTY);
//    }
//    client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
//    return client;
//  }
//
  @Bean
  public ElasticsearchTemplate elasticsearchTemplate() throws UnknownHostException {
    Settings settings = Settings.builder().put("cluster.name","elasticsearch").build();
    InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300);
    PreBuiltTransportClient client = new PreBuiltTransportClient(settings);
    client.addTransportAddress(address);
//    TransportClient client;
//    String clusterName = properties.getClusterName();
//    String[] split = properties.getClusterNodes() != null ? properties.getClusterNodes().split(":") : null;
//    String host = split != null && split[0] != null ? split[0] : "localhost";
//    Integer port = split != null && split[0] != null ? Integer.parseInt(split[1]) : 9300;
//    if (clusterName != null && !clusterName.trim().isEmpty()) {
//      Settings settings = Settings.builder().put("cluster.name", properties.getClusterName()).build();
//      client = new PreBuiltTransportClient(settings);
//    } else {
//      client = new PreBuiltTransportClient(Settings.EMPTY);
//    }
//    client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
    return new ElasticsearchTemplate(client);
  }
}
