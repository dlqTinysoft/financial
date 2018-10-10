# 环境初始化

## 数据库
### 管理端
使用`scripts/manager.sql`创建对应的数据库,修改manager/src/main/resources/application.yml中数据库连接地址

### 销售端
使用`scripts/seller.sql`, `scripts/seller-backup.sql`创建对应数据库,修改seller/src/main/resources/application.yml中数据库连接地址

## activemq
参考[activemq](http://activemq.apache.org/version-5-getting-started.html#Version5GettingStarted-InstallationProcedureforUnix)安装地址进行安装、启动
修改`manager/src/main/resources/application.yml`、`seller/src/main/resources/application.yml`中activemq相关配置





===================================笔记==============

销售端
    订单表
        订单编号，渠道编号，产品编号，用户编号，外部订单编号，
        类型，状态，金额，备注，创建时间，更新时间，
   
管理端 manager
    数据库的设计
        产品表
            编号，名称，收益率，锁定期，状态，起投金额，投资步长，备注
            创建时间，创建者，更新时间，更新者
    
    功能实现，测试=====》轻松玩转springData+jpa
    
    1.添加产品 post  /products
    2.查询单个产品 get  /products/{id}
    3.条件查询产品 get  /products  分页查询是重点 jpa分页查询的使用
    
    application.yml 配置信息
    
    统一错误处理
        用户友好的错误说明
        统一处理，简化业务代码
        异常标准化
        springboot提供了异常的统一处理
            ControllerAdvice是对controller的增强
            自定义错误页面，将个性化页面在浏览器进行展示
         显示日期jackson的配置(响应的json的时间显示真实的格式)
                jack
                time-zone
         
         springboot的BasicErrorController来处理异常
         
         ErrorMvcAutoConfiguration：注册了BasicErrorCOntroller类
         
         MyErrorController extends BasicErrorController
         
         上面就是ControllerAdvice的功能啦
         
         统一异常处理，使用两种方式BasicErrorController和ControllerAdvice
   
         SpringBoot提供的统一异常处理
            1.模仿：spring-boot-autoconfigure
            BasicErrorController
            ErrorMvcAutoConfiguration
            
            2.ControolerAdvice来处理
            其实不仅可以处理异常，也可以有其他的用处
            就是Controller的增强
            
         3.通过在配置文件，配置两个属性，来规范时间的格式化
            spring:
              jackson:
                date-format: yyyy-MM-dd HH:mm:ss.SSS
                time-zone: GMT+8
            
            
            
            
   
   
   
   
模块化开发：
    高内聚，低耦合
    并行开发，提高开发效率
    轮子重复使用
    
    如何划分模块
        业务层次
        功能划分
        重复使用
        Manager Seller == 功能划分
        Entity Api   ===业务层次
        Util Quartz Swagger ====轮子
        
        

开发环境
    gradle
    springboot
    
        
        
        
        
        
        
        
        
        
        
        
        


1.用户管理
2.账户管理
3.支付管理
4.产品管理
5.风险管理


























