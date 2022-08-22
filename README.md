#Hazelcast分布式缓存

官方文档Java API：https://docs.hazelcast.com/hazelcast/latest/clients/java
Web管理页面下载：https://hazelcast.com/open-source-projects/downloads/archives/#management-center
## 整合SpringBoot项目
可不安装hazelcast，直接添加jar包或者Maven依赖即可使用
```xml
<dependencies>
    <!--SpringBoot整合Hazelcast START-->
    <dependency>
        <groupId>com.hazelcast</groupId>
        <artifactId>hazelcast</artifactId>
    </dependency>
    <dependency>
        <groupId>com.hazelcast</groupId>
        <artifactId>hazelcast-spring</artifactId>
    </dependency>
    <!--SpringBoot整合Hazelcast END-->
</dependencies>
```



## Docker 部署单节点
```shell
#部署web管理页面
docker pull hazelcast/management-center
docker run -d -p 8200:8080 hazelcast/management-center:latest

#下载hazelcast镜像
docker pull hazelcast/hazelcast
docker run -d -p 8200:8080 hazelcast/management-center:latest
```
使用浏览器访问：http://192.168.153.129:8200


