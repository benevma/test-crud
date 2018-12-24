@echo off
echo Setting JAVA_HOME
set JAVA_HOME=C:\Program Files (x86)\IBM\WebSphere\AppServer8.5_1\java_1.8_64
echo Display java version
java -version
c:
cd C:\_csework\_gitrep\eb20bgsxlgn
mvn clean install

mvn spring-boot:run