# 项目说明

FreeMarker代码生成

## 使用步骤

 >1. 预先使用sql包下的`test.sql`文件生成数据库表；
 >2. 在`application.yml`中配置数据库连接信息；
 >3. 运行test目录下的测试用例，目前只添加了通过数据库表生成JPA Entity类的支持。