package cn.codeforfun.user;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wangbin
 */
@Document(indexName = "user", type = "user")
@Data
@Entity
@Table
public class User {
  @Id
  @GeneratedValue
  private Long id;
  private String username;
  private String password;
}
