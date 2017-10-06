sudo apt-get update
sudo apt-get install vim mysql-client openjdk-8-jdk maven tomcat-8
sudo keytool -genkey -alias tomcat -keyalg RSA -keystore /var/lib/tomcat8/conf/.keystore
sudo vim /var/lib/tomcat8/conf/server.xml
sudo vim /var/lib/tomcat8/conf/context.xml
sudo vim /etc/default/tomcat8
sudo vim /etc/group

sudo /etc/init.d/tomcat8 restart

https://javaee.github.io/tutorial/toc.html
https://javaee.github.io/firstcup/toc.html

https://mvnrepository.com/artifact/junit/junit/4.12
