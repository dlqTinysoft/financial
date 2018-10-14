# 环境初始化

## 数据库
### 管理端
使用`scripts/manager.sql`创建对应的数据库,修改manager/src/main/resources/application.yml中数据库连接地址

### 销售端
使用`scripts/seller.sql`, `scripts/seller-backup.sql`创建对应数据库,修改seller/src/main/resources/application.yml中数据库连接地址

## activemq
参考[activemq](http://activemq.apache.org/version-5-getting-started.html#Version5GettingStarted-InstallationProcedureforUnix)安装地址进行安装、启动
修改`manager/src/main/resources/application.yml`、`seller/src/main/resources/application.yml`中activemq相关配置





===================================笔记==================

销售端
    订单表
        订单编号，渠道编号，产品编号，用户编号，外部订单编号，
        类型，状态，金额，备注，创建时间，更新时间
        

    功能：产品查询，申购、赎回，对账
         
    swagger文档交互
    swagger编写
    swagger手动编写文档
    已有代码生成接口文档
    
    产品查询功能：
            从管理端查询，然后给第三方
            jsonrpc:内部系统之间交互
            http不如rpc写法简单
            webservice  xml方式浪费带宽
            Thrift grpc等性能高，但是写法复杂
            
            内部交互选择jsonRpc通信协议来进行交互
            
            jsonRpc： 是什么 类似于http的模式
                       怎么用
                  jsonrpc4j框架
                  https：//github.com/briandilley/jsonrpc4j
                 api: ProductRpc：产品相关的rpc服务
                        查询多个产品，查询一个产品
                 
                      小技巧：传参数的时候，请求参数使用对象，如果需修改，直接改对象就ok，不用动函数
                       
                 在manager里端来实现接口
                    rpc：ProductRpcImpl
                    把productService注入进来
                    把rpc地址交给spring来管理
                    configuration:RpcConfiguration
                 seller里代码编写
                    
                 rpc原理：
                    运行原理
                    路径、参数限制
                    简化、封装
                    
                    客户端：
                        logging:
                            level:
                                com.googlecode.jsonrpc4j:debug
                         seller客户端
                         manager：服务端
                    配置客户端：
                    step1:   AutoJsonRpcClientProxyCreator
                             setBaseUrl
                             setScanPackage
                    step2:
                        JsonProxyFactoryBean
                        objectMapper
                        JsonRpcHttpClient
                        
                     step3:Invoke，
                      step4:配置服务端，AutoJsonRpcServiceImplExporter
                                               
            
            JSonRpc个性化配置
                简化、封装
                    使用类名作为路径
                    路径、参数限制
                    自动配置
                
            
            
            
            
            
            
            
            
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
   
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
            
    自动化测试
           功能测试
           src/test/java
           @BeforeClass:这个类会执行一次
           @Before，执行每个用例之前都会执行该方法
           @Test:测试用例
           Assert
           @After：每个测试用例执行之后
           @AfterClass:整个类销魂，之后执行一次
           
           @RunWith(SpringRunner.class)
           @SpringBootTest：启动个随机端口
           
           学习java8的lama表达式
           
           点击gradle中的任务 build
           会把测试任务全部执行一遍，如果如有任务都通过，则打包成功否则打包失败
           
           @FixMethodOrder() 来定义测试方法的执行顺序
           
           自动化测试-总结
            测试覆盖率，边界条件
            执行顺序 @FixMethodOrder
            条件查询测试用例
            
            
           
           
           
           
           
           
           
           
           
            
            
   
   
   
   
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


























