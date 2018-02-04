package cn.codeforfun.esdao;

import cn.codeforfun.user.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wangbin
 */
@Repository
public interface UserEsDAO extends ElasticsearchRepository<User, Long> {
}
