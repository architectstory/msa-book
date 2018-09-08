FROM java:8
VOLUME /tmp
ADD gs-spring-boot-docker-0.1.0.jar msa-service-coffee-order.jar
RUN bash -c 'touch /msa-service-coffee-order.jar'
ENTRYPOINT ["java","-jar","/msa-service-coffee-order.jar"]