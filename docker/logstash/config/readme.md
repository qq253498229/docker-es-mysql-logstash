```
#-----------------------------------start-----------------------------------
#输入部分
input {
  jdbc {
    #连接MySQL驱动，需要自己下载
    jdbc_driver_library => "/es/mysql-connector-java-5.1.31.jar"
    jdbc_driver_class => "com.mysql.jdbc.Driver"
    jdbc_connection_string => "jdbc:mysql://10.112.29.30:3306/mstore"
    #连接数据库账号信息
    jdbc_user => "MySQL_admin"
    jdbc_password => "password"
    #分页
    jdbc_paging_enabled => true
    #分页大小
    jdbc_page_size => 100000
    #流式获取数据，每次取10000.
    jdbc_fetch_size => 10000
    #Maximum number of times to try connecting to database
    connection_retry_attempts => 3
    #Number of seconds to sleep between connection attempts
    connection_retry_attempts_wait_time => 1
    #Connection pool configuration. The amount of seconds to wait to acquire a connection before raising a PoolTimeoutError (default 5)
    jdbc_pool_timeout => 5
    #Whether to force the lowercasing of identifier fields
    lowercase_column_names => true
    #Whether to save state or not in last_run_metadata_path
    #保存上次运行记录，增量提取数据时使用
    record_last_run = > true
    #"* * * * *"为每分钟执行一次
    schedule => "* * * * *"
    #Use an incremental column value rather than a timestamp
    use_column_value => true
    #sql_last_value
    #The value used to calculate which rows to query. Before any query is run, this is set to Thursday, 1 January 1970, or 0 if use_column_value is true and tracking_column is set. It is updated accordingly after subsequent queries are run.
    tracking_column => "id"
    #查询语句
    statement => "SELECT id,package_name,name,sub_name,editor_comment,high_quality,sub_category,tag,update_time FROM tbl_app WHERE id > :sql_last_value"
  }
}

#过滤部分
filter {
  json {
    source => "message"
    remove_field => ["message"]
  }
  date{
    match => ["update_time","yyy-MM-dd HH:mm:ss"]
  }
}

#输出到elastsicearch
output {
  elasticsearch {
    #elasticsearch集群地址，不用列出所有节点，默认端口号也可省略
    hosts => ["10.127.92.181:9200", "10.127.92.212:9200", "10.127.92.111:9200"]
    #索引值，查询的时候会用到；需要先在elasticsearch中创建对应的mapping，也可以采用默认的mapping
    index => "store"
    #指定插入elasticsearch文档ID，对应input中sql字段id
    document_id => "%{id}"
  }
}

#------------------------------------end------------------------------------
#注：使用时请去掉此文件中的注释，不然会报错
#logstash会把执行记录默认存在账户根目录下： /root/.logstash_jdbc_last_run
#如果需要重新加载数据到elasticsearch，需要删除这个文件
```