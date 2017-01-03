FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD edge-service-0.0.1-SNAPSHOT.jar edge-service.jar
RUN sh -c 'touch /edge-service.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /edge-service.jar" ]
