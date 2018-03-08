# Demo Project
## Hibernate 设置
1. 修改`src/resource/hibernate.cfg.xml`中的设置为
```xml
  <property name="connection.url">
  jdbc:mysql://yourDatabaseUrl?useUnicode=true&amp;characterEncoding=utf-8&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC&amp;useSSL=false
  </property>
```
2. 修改src/resource/hibernate.properties的数据库用户名密码
3. 删除`src/resource/hibernate.cfg.xml`中的
```xml 
<mapping class="pojo.StaffEntity"/>
```
4. 删除示范的POJOs类
5. 用Idea生成POJO类 
> 删除示范的DAO层中的接口和实现，Service中的所有接口实现以免发生错误
