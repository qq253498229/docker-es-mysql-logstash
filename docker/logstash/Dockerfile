FROM logstash:5.6.6
RUN logstash-plugin install logstash-input-jdbc
COPY config/mysql_pipelines.yml /some/config-dir/
COPY jar/mysql-connector-java-5.1.45.jar /some/jar-dir/
CMD ["-f", "/some/config-dir/mysql_pipelines.yml"]