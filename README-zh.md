> 前后端分离,专注于后端服务

## 目标
> 每个人都可以独立、快速、高效地开发项目！

#### [GITHUB](https://github.com/geekidea/spring-boot-plus) | [GITEE](https://gitee.com/geekidea/spring-boot-plus)

#### [springboot.plus](http://springboot.plus)

### 主要特性
- 集成spring boot 常用开发组件集、公共配置、AOP日志等
- Maven多模块架构
- 集成mybatis plus快速dao操作
- 快速生成后台代码: entity/param/vo/controller/service/mapper/xml
- 集成Swagger/Knife4j，可自动生成api文档
- 集成jwt、shiro权限控制
- 集成Redis缓存
- 集成HikariCP连接池，JDBC性能和慢查询检测
- 集成spring boot admin，实时检测项目运行情况
- 使用assembly maven插件进行不同环境打包部署,包含启动、重启命令，配置文件提取到外部config目录

## [V2.0视频介绍](https://www.bilibili.com/video/BV16A41187XE/)
<p align="center">
  <a href="https://www.bilibili.com/video/BV16A41187XE/">
   <img alt="spring-boot-plus videos" src="https://geekidea.oss-cn-chengdu.aliyuncs.com/spring-boot-plus/img/videos-acfun-ui.png">
  </a>
</p>

## 项目结构
```text
    └── spring-boot-plus
    ├── admin               SpringBootAdmin Server模块
    ├── bootstrap           spring-boot-plus 启动模块
    ├── config              配置模块
    ├── distribution        打包模块
    ├── docs                文档目录
    ├── example             示例模块，自己的业务可新建多个模块处理
    ├── framework           框架核心模块
    ├── generator           代码生成模块
    ├── scheduled           任务调度模块
    └── system              系统模块
```

### 项目环境 
中间件 | 版本 |  备注
-|-|-
JDK | 1.8+ | JDK1.8及以上 |
MySQL | 5.7+ | 5.7及以上 |
Redis | 3.2+ |  |

### 技术选型 
技术 | 版本 |  备注
-|-|-
Spring Boot | 2.2.0.RELEASE | 最新发布稳定版 |
Spring Framework | 5.2.0.RELEASE | 最新发布稳定版 |
Spring Boot Admin| 2.2.2 | 管理和监控SpringBoot应用程序 |
Mybatis | 3.5.3 | 持久层框架 |
Mybatis Plus | 3.3.1 | mybatis增强框架 |
HikariCP | 3.4.2 | 数据源 |
Fastjson | 1.2.67 | JSON处理工具集 |
Swagger2 | 2.9.2 | api文档生成工具 |
Knife4j | 2.0.2 | api文档生成工具 |
commons-lang3 | 3.9 | 常用工具包 |
commons-io | 2.6 | IO工具包 |
commons-codec | 1.14 | 加密解密等工具包 |
commons-collections4 | 4.4 | 集合工具包 |
reflections | 0.9.9 | 反射工具包 |
hibernate-validator | 6.0.18.Final | 后台参数校验注解 |
Shiro | 1.5.1 | 权限控制 |
JWT | 3.10.1 | JSON WEB TOKEN |
hutool-all | 5.2.4 | 常用工具集 |
lombok | 1.18.12 | 注解生成Java Bean等工具 |
mapstruct | 1.3.1.Final | 对象属性复制工具 |

### Maven 构建
> 默认使用dev环境,对应配置文件：application-dev.yml

```bash
mvn clean package -Pdev
```