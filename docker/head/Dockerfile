FROM registry.cn-beijing.aliyuncs.com/wangdali/cnpm
WORKDIR /usr/share/es-head
RUN git clone https://github.com/mobz/elasticsearch-head.git && \
  cd elasticsearch-head && \
  cnpm install
CMD ["npm","start","--prefix","elasticsearch-head"]