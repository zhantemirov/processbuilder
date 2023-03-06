```
git clone git@github.com:zhantemirov/processbuilder.git && cd processbuilder

mvn clean org.wildfly.plugins:wildfly-maven-plugin:4.0.0.Final:package

mvn compile exec:java -Dexec.mainClass="org.example.Main"
```
