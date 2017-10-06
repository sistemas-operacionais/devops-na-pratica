
## Inicializando apenas o container web

```bash
cd devops-na-pratica/vagrant
vagrant up maven
```

## Configurando permissões do SO

```bash
cd devops-na-pratica/vagrant
vagrant ssh web
sudo vim /etc/group
exit
vagrant reload web
```


## Criando um projeto web com o Maven

```bash
mkdir devops-na-pratica/maven
vagrant ssh web
cd /src
mvn archetype:generate -DgroupId=br.edu.ifrn.cnat.diatinf.tads -DartifactId=hello -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
```

## Compilando

```bash
cd /src/hello
mvn compile
```

## Criando um Servlet

1. Criar um arquivo java

## Arquivos


### ```Vagrantfile```

```ruby
VAGRANT_API_VERSION = "2"

Vagrant.configure(VAGRANT_API_VERSION) do |config|
    config.vm.box = "hashicorp/precise32"

    config.vm.define :db do |db_config|
        db_config.vm.hostname = "db"
        db_config.vm.network :private_network,
            :ip => "192.168.33.10"
    end

    config.vm.define :web do |www|
        www.vm.hostname = "web"
        www.vm.network :private_network,
            :ip => "192.168.33.12"
        www.vm.synced_folder "../maven/",
            "/src"
    end
end
```

**ATENÇÃO** a mudança na configuração ```www.vm.synced_folder```!!!

### ```pom.xml``` original

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>br.edu.ifrn.cnat.diatinf.tads</groupId>
    <artifactId>hello</artifactId>
    <packaging>war</packaging>
    <version>1.0-SNAPSHOT</version>
    <name>hello Maven Webapp</name>
    <url>http://maven.apache.org</url>
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    <build>
        <finalName>hello</finalName>
    </build>
</project>
```

### ```pom.xml``` modificado para copiar o war

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>br.edu.ifrn.cnat.diatinf.tads</groupId>
    <artifactId>hello</artifactId>
    <packaging>war</packaging>
    <version>1.0-SNAPSHOT</version>
    <name>Hello Maven Webapp Example</name>
    <url>http://maven.apache.org</url>
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    <build>
        <finalName>hello</finalName>
        <plugins>
            <plugin>
                <artifactId>maven-war-plugin</artifactId>
                <configuration>
                    <outputDirectory>
                        /var/lib/tomcat7/webapps
                    </outputDirectory>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

### ```/etc/group```

**última linha**
- Antes ```tomcat7:x:111:```
- Depois ```tomcat7:x:111:vagrant```
