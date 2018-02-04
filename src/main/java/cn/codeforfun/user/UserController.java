package cn.codeforfun.user;

import cn.codeforfun.dao.UserDAO;
import cn.codeforfun.esdao.UserEsDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wangbin
 */
@RestController
@RequestMapping("/user")
public class UserController {
  @Resource
  private UserService userService;
  @Resource
  private UserDAO userDAO;
  @Resource
  private UserEsDAO userEsDAO;

  @GetMapping
  public ResponseEntity list() {
    return ResponseEntity.ok(userEsDAO.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity get(@PathVariable("id") Long id) {
    return ResponseEntity.ok(userDAO.getOne(id));
  }

  @PostMapping("/findByUsernameAndPassword")
  public ResponseEntity findByUsernameAndPassword(@RequestBody User user) {
    return ResponseEntity.ok(userDAO.findDistinctByUsernameContainingOrPasswordContaining(user.getUsername(), user.getPassword()));
  }

  @PostMapping
  public ResponseEntity save(@RequestBody User user) {
    User save = userDAO.save(user);
    userEsDAO.save(user);
    return ResponseEntity.ok(save);
  }
}



