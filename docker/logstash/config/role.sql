SELECT
  r.*,
  ur.user_id AS parentid
FROM role r
  LEFT JOIN user_role ur ON ur.role_id = r.id