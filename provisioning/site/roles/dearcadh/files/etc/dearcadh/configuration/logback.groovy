import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.status.OnConsoleStatusListener
import static ch.qos.logback.classic.Level.*

scan()

statusListener(OnConsoleStatusListener)

final logDir = '/var/log/tomcat7'

appender('DEBUG_LOG', RollingFileAppender) {
  file = "${logDir}/cayova-tomcat.log"
  rollingPolicy('ch.qos.logback.core.rolling.FixedWindowRollingPolicy') {
    fileNamePattern = "${logDir}/cayova-tomcat.%i.log.gz"
    minIndex = 1
    maxIndex = 13
  }

  triggeringPolicy('ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy') {
    maxFileSize = '1024MB'
  }

  encoder(PatternLayoutEncoder) {
    pattern = '%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n%xException{full}'
  }
}

logger 'com.viscis', DEBUG
logger 'com.viscis.storage.index', INFO
logger 'com.viscis.session', INFO
logger 'org.apache.cassandra.service', WARN
logger "kafka.network", INFO
logger 'kafka.message', INFO
logger 'storm.kafka.PartitionManager', WARN
logger 'org.hibernate.type', WARN
logger 'backtype.storm', WARN
logger 'org.apache.http.wire', WARN
logger 'org.apache.shiro.realm.AuthorizingRealm', WARN
logger 'com.viscis.api.server.ViscisAuthenticationRealm', INFO

//logger 'org.hibernate.SQL',DEBUG - the same as show_sql

root INFO, ['DEBUG_LOG']
