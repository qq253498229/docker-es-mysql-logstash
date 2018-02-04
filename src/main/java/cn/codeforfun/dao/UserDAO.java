package cn.codeforfun.dao;

import cn.codeforfun.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangbin
 */
@Repository
public interface UserDAO extends JpaRepository<User, Long> {
  /**
   * 根据用户名和密码查询用户列表
   *
   * @param username 用户名
   * @param password 密码
   * @return 用户列表
   */
  List<User> findDistinctByUsernameContainingOrPasswordContaining(String username, String password);

}

