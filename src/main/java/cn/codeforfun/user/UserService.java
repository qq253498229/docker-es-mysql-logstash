package cn.codeforfun.user;

import cn.codeforfun.dao.UserDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangbin
 */
@Service
public class UserService {
  @Resource
  private UserDAO userDAO;

  List<User> findAll() {
    return userDAO.findAll();
  }
}
