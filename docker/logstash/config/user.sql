SELECT
  u.id,
  u.password,
  u.username,
  r.id   AS role_id,
  r.name AS role_name
FROM user u
  LEFT JOIN user_role ru ON ru.user_id = u.id
  LEFT JOIN role r ON r.id = ru.role_id