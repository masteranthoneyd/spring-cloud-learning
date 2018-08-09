FROM yangbingdong/docker-oraclejdk8:latest
MAINTAINER yangbingdong1994@gmail.com
ENV PROJECT_NAME="@project.build.finalName@.@project.packaging@" JAVA_OPTS=""
ADD $PROJECT_NAME app.jar
RUN sh -c 'touch /app.jar'
#CMD ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -DLog4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector -Dspring.profiles.active=${ACTIVE:-docker} -jar /app.jar"]
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -DLog4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector -Dspring.profiles.active=${ACTIVE:-docker} -jar /app.jar